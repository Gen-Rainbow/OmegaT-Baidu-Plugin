package omegat.baidu;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omegat.core.Core;
import org.omegat.core.machinetranslators.BaseTranslate;
import org.omegat.gui.exttrans.MTConfigDialog;
import org.omegat.util.Language;

import java.awt.Window;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@SuppressWarnings("SpellCheckingInspection")
public class BaiduTranslate extends BaseTranslate {

    private static final String PROPERTY_APP_ID = "baidu.app.id";
    private static final String PROPERTY_APP_KEY = "baidu.app.key";

    public static void loadPlugins() {
        Core.registerMachineTranslationClass(BaiduTranslate.class);
    }

    public static void unloadPlugins() {
    }

    @Override
    protected String getPreferenceName() {
        return "allow_baidu_translate";
    }

    /**
     * 在OmegaT软件-首选项-机器翻译
     * 中显示本插件的名字
     */
    @Override
    public String getName() {
        return "Baidu Translate";
    }

    /**
     * <tr>相关参数:</tr>
     * <p>q    &emsp;string&emsp;是&emsp;请求翻译query &emsp;UTF-8编码
     * <p>from &emsp;string&emsp;是&emsp;翻译源语言    &emsp;可设置为auto
     * <p>to   &emsp;string&emsp;是&emsp;翻译目标语言  &emsp;不可设置为auto
     * <p>appid&emsp;string&emsp;是&emsp;APPID      &emsp;可在管理控制台查看
     * <p>salt &emsp;string&emsp;是&emsp;随机数      &emsp;可为字母或数字的字符串
     * <p>sign &emsp;string&emsp;是&emsp;签名       &emsp;appid+q+salt+密钥的MD5值
     * <tr>以下字段仅开通了词典、TTS用户需要填写:</tr>
     * <p> tts    &emsp;integer&emsp;否&emsp;是否显示语音合成资源&emsp;0-显示，1-不显示
     * <p> dict   &emsp;integer&emsp;否&emsp;是否显示词典资源&emsp;0-显示，1-不显示
     * <tr>以下字段仅开通了”我的术语库“用户需要填写:</tr>
     * <p> action &emsp;integer&emsp;否&emsp;判断是否需要使用自定义术语干预API&emsp;1-是，0-否
     */
    @Override
    protected String translate(final Language sLang, final Language tLang, final String text) {

        String queryText = text.length() > 5000 ? text.substring(0, 4997) + "…" : text;
        String appId = getCredential(PROPERTY_APP_ID);
        String secretKey = getCredential(PROPERTY_APP_KEY);

        // 从缓存中加载翻译内容
        String prev = getFromCache(sLang, tLang, queryText);
        if (prev != null) return prev;

        // 确定源语言的语种代码
        String langFrom = sLang.getLanguageCode();
        langFrom = OLang2BLang.translateOLang2BLang(langFrom);

        // 确定目标语言的语种代码
        String langTo = tLang.getLanguageCode();
        langTo = OLang2BLang.translateOLang2BLang(langTo);

        // 生成随机数
        String salt = UUID.randomUUID().toString();

        // 生成签名
        String sign = MD5.calSign(appId + queryText + salt + secretKey);

        // 构建URL
        String url = "https://fanyi-api.baidu.com/api/trans/vip/translate"
                + "?q=" + URLEncoder.encode(queryText, StandardCharsets.UTF_8)
                + "&from=" + langFrom
                + "&to=" + langTo
                + "&appid=" + appId
                + "&salt=" + salt
                + "&sign=" + sign;

        // 创建HTTP客户端
        HttpClient client = HttpClient.newHttpClient();

        // 创建HTTP GET请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        StringBuilder translation = new StringBuilder();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 处理json格式的响应
            JSONObject responseJson = new JSONObject(response.body());
            if (responseJson.has("error_code")) {
                int errorCode = responseJson.getInt("error_code");
                String errorCodeDesc = ErrorCode2Desc.translateErrorCode2Desc(errorCode);
                translation = new StringBuilder(errorCode + "-" + errorCodeDesc);
            } else {
                JSONArray transResultArray = responseJson.getJSONArray("trans_result");
                for (int i = 0; i < transResultArray.length(); i++) {
                    JSONObject transObj = transResultArray.getJSONObject(i);
                    translation.append(transObj.getString("dst"));
                }
                // 把这次结果添加进缓存
                putToCache(sLang, tLang, queryText, translation.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return translation.toString();
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public void showConfigurationUI(final Window parent) {
        MTConfigDialog dialog = new MTConfigDialog(parent, getName()) {
            @Override
            protected void onConfirm() {
                String id = panel.valueField1.getText().trim();
                String key = panel.valueField2.getText().trim();
                boolean temporary = panel.temporaryCheckBox.isSelected();

                setCredential(PROPERTY_APP_ID, id, temporary);
                setCredential(PROPERTY_APP_KEY, key, temporary);
            }
        };
        dialog.panel.valueLabel1.setText("APP ID");
        dialog.panel.valueField1.setText(getCredential(PROPERTY_APP_ID));

        dialog.panel.valueLabel2.setText("密钥");
        dialog.panel.valueField2.setText(getCredential(PROPERTY_APP_KEY));

        dialog.panel.temporaryCheckBox.setSelected(isCredentialStoredTemporarily(PROPERTY_APP_KEY));
        dialog.show();
    }

}

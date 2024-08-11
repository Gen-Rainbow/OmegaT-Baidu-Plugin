package omegat.baidu;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/** 请求错误码（点击链接跳转开发者文档）
 * <a href="https://fanyi-api.baidu.com/doc/21">...</a>
 * <p> 52001    请求超时 	            请重试
 * <p> 52002    系统错误 	            请重试
 * <p> 52003    未授权用户 	        请检查appid是否正确或者服务是否开通
 * <p> 54000    必填参数为空 	        请检查是否少传参数
 * <p> 54001    签名错误 	            请检查您的签名生成方法
 * <p> 54003    访问频率受限 	        请降低您的调用频率，或进行身份认证后切换为高级版/尊享版
 * <p> 54004    账户余额不足 	        请前往管理控制台为账户充值
 * <p> 54005    长query请求频繁 	    请降低长query的发送频率，3s后再试
 * <p> 58000    客户端IP非法          检查个人资料里填写的IP地址是否正确，可前往开发者信息-基本信息修改
 * <p> 58001    译文语言方向不支持      检查译文语言是否在语言列表里
 * <p> 58002    服务当前已关闭 	    请前往管理控制台开启服务
 * <p> 90107    认证未通过或未生效      请前往我的认证查看认证进度
 */
public final class ErrorCode2Desc {

    private static final Map<Integer, String> ERROR_CODE_2_DESC_MAP = ImmutableMap.<Integer, String>builder()
            .put(52001, "请求超时")
            .put(52002, "系统错误")
            .put(52003, "未授权用户")
            .put(54000, "必填参数为空")
            .put(54001, "签名错误")
            .put(54003, "访问频率受限")
            .put(54004, "账户余额不足")
            .put(54005, "长query请求频繁")
            .put(58000, "客户端IP非法")
            .put(58001, "译文语言方向不支持")
            .put(58002, "服务当前已关闭")
            .put(90107, "认证未通过或未生效")
            .build();

    /**
     * 返回码解析
     */
    public static String translateErrorCode2Desc(final Integer errorCode) {
        String errorCodeDesc = ERROR_CODE_2_DESC_MAP.get(errorCode);
        if (errorCodeDesc == null) {
            errorCodeDesc = "未知错误";
        }
        return errorCodeDesc;
    }

    private ErrorCode2Desc() {
    }
}

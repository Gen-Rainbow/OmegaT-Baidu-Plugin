package omegat.baidu;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Objects;

/**
 * 用于将OmegaT识别的语种代码转换为百度翻译提供的语种代码
 */
public final class OLang2BLang {

    private static final Map<String, String> OLANG_2_BLANG_MAP = ImmutableMap.<String, String>builder()
            .put("", "auto")// 自动检测
            .put("AA", "")// 阿发文
            .put("AA-DJ", "")// 阿法文 (吉布提)
            .put("AA-ER", "")// 阿法文 (厄里特尼亚)
            .put("AB", "")// 阿布哈西亚文
            .put("AE", "")// 阿维斯陀文
            .put("AF", "afr")// 南非荷兰文
            .put("AF-NA", "")// 南非荷兰文 (纳米比亚)
            .put("AF-ZA", "")// 南非荷兰文 (南非)
            .put("AF-ZW", "")// 南非荷兰文 (津巴布韦)
            .put("AK", "")// 库阿文
            .put("AM", "amh")// 阿姆哈拉文
            .put("AN", "arg")// 阿拉贡文
            .put("AR", "ara")// 阿拉伯文
            .put("AR-AE", "")// 阿拉伯文 (阿拉伯联合酋长国)
            .put("AR-BH", "")// 阿拉伯文 (巴林)
            .put("AR-DZ", "arq")// 阿拉伯文 (阿尔及利亚)
            .put("AR-EG", "")// 阿拉伯文 (埃及)
            .put("AR-IQ", "")// 阿拉伯文 (伊拉克)
            .put("AR-JO", "")// 阿拉伯文 (约旦)
            .put("AR-KW", "")// 阿拉伯文 (科威特)
            .put("AR-LB", "")// 阿拉伯文 (黎巴嫩)
            .put("AR-LY", "")// 阿拉伯文 (利比亚)
            .put("AR-MA", "")// 阿拉伯文 (摩洛哥)
            .put("AR-OM", "")// 阿拉伯文 (摩洛哥)
            .put("AR-QA", "")// 阿拉伯文 (卡塔尔)
            .put("AR-SA", "")// 阿拉伯文 (沙特阿拉伯)
            .put("AR-SD", "")// 阿拉伯文 (苏丹)
            .put("AR-SY", "syr")// 阿拉伯文 (叙利亚)
            .put("AR-TN", "tua")// 阿拉伯文 (突尼斯)
            .put("AR-US", "")// 阿拉伯文 (美国)
            .put("AR-YE", "")// 阿拉伯文 (也门)
            .put("AS", "阿萨姆文")// 阿萨姆文
            .put("AV", "")// 阿瓦尔文
            .put("AY", "aym")// 艾马拉文
            .put("AZ", "阿塞拜疆文")// 阿塞拜疆文
            .put("BA", "")// 巴什客尔文
            .put("BE", "bel")// 白俄罗斯文
            .put("BG", "bul")// 保加利亚文
            .put("BH", "")// 比哈尔文
            .put("BI", "bis")// 比斯拉马文
            .put("BM", "")// 班巴拉文
            .put("BN", "ben")// 孟加拉文
            .put("BO", "")// 西藏文
            .put("BR", "")// 布里多尼文
            .put("BS", "bos")// 波斯尼亚文
            .put("CA", "cat")// 加泰罗尼亚文
            .put("CE", "")// 车臣文
            .put("CH", "")// 查莫罗文
            .put("CO", "cos")// 科西嘉文
            .put("CR", "克里克")// 克里文
            .put("CS", "cs")// 捷克文
            .put("CU", "")// 教会斯拉夫文
            .put("CV", "楚瓦什文")// 楚瓦什文
            .put("CY", "wel")// 威尔士文
            .put("DA", "dan")// 丹麦文
            .put("DE", "de")// 德文
            .put("DE-AT", "")// 德文 (奥地利)
            .put("DE-CH", "")// 德文 (瑞士)
            .put("DE-DE", "")// 德文 (德国)
            .put("DE-LU", "ltz")// 德文 (卢森堡)
            .put("DV", "div")// 迪维希文
            .put("DZ", "")// 不丹文
            .put("EE", "")// 埃维文
            .put("EL", "el")// 希腊文
            .put("EN", "en")// 英文
            .put("EN-AU", "en")// 英文 (澳大利亚)
            .put("EN-CA", "en")// 英文 (加拿大)
            .put("EN-GB", "en")// 英文 (英国)
            .put("EN-IE", "gle")// 英文 (爱尔兰)
            .put("EN-IN", "en")// 英文 (印度)
            .put("EN-NZ", "en")// 英文 (新西兰)
            .put("EN-US", "en")// 英文 (美国)
            .put("EN-ZA", "en")// 英文 (南非)
            .put("EO", "epo")// 世界文
            .put("ES", "spa")// 西班牙文
            .put("ES-AR", "")// 西班牙文 (阿根廷)
            .put("ES-BO", "")// 西班牙文 (玻利维亚)
            .put("ES-CL", "")// 西班牙文 (智利)
            .put("ES-CO", "")// 西班牙文 (哥伦比亚)
            .put("ES-CR", "")// 西班牙文 (哥斯达黎加)
            .put("ES-DO", "")// 西班牙文 (多米尼加共和国)
            .put("ES-EC", "")// 西班牙文 (厄瓜多尔)
            .put("ES-ES", "spa")// 西班牙文 (西班牙)
            .put("ES-GT", "")// 西班牙文 (危地马拉)
            .put("ES-HN", "")// 西班牙文 (洪都拉斯)
            .put("ES-MX", "")// 西班牙文 (墨西哥)
            .put("ES-NI", "")// 西班牙文 (尼加拉瓜)
            .put("ES-PA", "")// 西班牙文 (巴拿马)
            .put("ES-PE", "")// 西班牙文 (秘鲁)
            .put("ES-PR", "")// 西班牙文 (波多黎哥)
            .put("ES-PY", "")// 西班牙文 (巴拉圭)
            .put("ES-SV", "")// 西班牙文 (萨尔瓦多)
            .put("ES-US", "")// 西班牙文 (美国)
            .put("ES-UY", "")// 西班牙文 (乌拉圭)
            .put("ES-VE", "")// 西班牙文 (委内瑞拉)
            .put("ET", "est")// 爱沙尼亚文
            .put("EU", "baq")// 巴斯克文
            .put("FA", "per")// 波斯文
            .put("FA-AF", "")// 波斯文 (阿富汗)
            .put("FA-IR", "ir")// 波斯文 (伊朗)
            .put("FF", "ful")// 富拉文
            .put("FI", "fin")// 芬兰文
            .put("FJ", "")// 斐济文
            .put("FO", "fao")// 法罗文
            .put("FR", "fra")// 法文
            .put("FR-BE", "")// 法文 (比利时)
            .put("FR-CA", "frn")// 法文 (加拿大)
            .put("FR-CH", "")// 法文 (瑞士)
            .put("FR-FR", "fra")// 法文 (法国)
            .put("FR-LU", "")// 法文 (卢森堡)
            .put("FY", "")// 弗里斯兰文
            .put("GA", "gle")// 爱尔兰文
            .put("GD", "gla")// 苏格兰- 盖尔文
            .put("GL", "glg")// 加利西亚文
            .put("GN", "grn")// 瓜拉尼文
            .put("GU", "")// 古加拉提文
            .put("GV", "")// 马恩文
            .put("HA", "")// 豪撒文
            .put("HE", "heb")// 希伯来文
            .put("HI", "hi")// 印地文
            .put("HO", "")// 新里木托文
            .put("HR", "hrv")// 克罗地亚文
            .put("HT", "")// 海地文
            .put("HU", "hu")// 匈牙利文
            .put("HY", "arm")// 亚美尼亚文
            .put("HZ", "")// 赫雷罗文
            .put("IA", "")// 拉丁国际文
            .put("ID", "")// 印度尼西亚文
            .put("IE", "")// 拉丁国际文
            .put("IG", "ibo")// 伊博文
            .put("II", "")// 四川彝文
            .put("IK", "")// 依奴皮维克文
            .put("IO", "ido")// 伊多文
            .put("IS", "ice")// 冰岛文
            .put("IT", "it")// 意大利文
            .put("IT-CH", "")// 意大利文 (瑞士)
            .put("IT-IT", "")// 意大利文 (意大利)
            .put("IU", "")// 爱斯基摩文
            .put("JA", "jp")// 日文
            .put("JV", "jav")// 爪哇文
            .put("KA", "geo")// 格鲁吉亚文
            .put("KG", "kon")// 刚果文
            .put("KI", "")// 吉库尤文
            .put("KJ", "")// 卡湾亚马文
            .put("KK", "")// 哈萨克文
            .put("KL", "kal")// 格陵兰文
            .put("KM", "")// 柬埔寨文
            .put("KN", "")// 埃纳德文
            .put("KO", "")// 朝鲜文
            .put("KR", "kau")// 卡努里文
            .put("KS", "kas")// 克什米尔文
            .put("KU", "kur")// 库尔德文
            .put("KV", "")// 科米文
            .put("KW", "")// 康沃尔文
            .put("KY", "kir")// 吉尔吉斯文
            .put("LA", "lat")// 拉丁文
            .put("LB", "ltz")// 卢森堡文
            .put("LG", "lug")// 干达文
            .put("LI", "lim")// 林堡文
            .put("LN", "lin")// 林加拉文
            .put("LO", "lao")// 老挝文
            .put("LT", "lit")// 立陶宛文
            .put("LU", "")// 卢巴-加丹加
            .put("LV", "")// 拉托维亚文(列托)
            .put("MG", "")// 马尔加什文
            .put("MH", "mah")// 马绍尔文
            .put("MI", "mao")// 毛利文
            .put("MK", "mac")// 马其顿文
            .put("ML", "")// 马来亚拉姆文
            .put("MN", "")// 蒙古文
            .put("MO", "")// 摩尔多瓦文
            .put("MR", "mar")// 马拉地文
            .put("MS", "may")// 马来文
            .put("MT", "mlt")// 马耳他文
            .put("MY", "bur")// 缅甸文
            .put("NA", "")// 瑙鲁文
            .put("NB", "")// 挪威博克马尔文
            .put("ND", "")// 北恩德比利文
            .put("NE", "nep")// 尼泊尔文
            .put("NG", "")// 恩东加文
            .put("NL", "nl")// 荷兰文
            .put("NL-BE", "")// 荷兰文 (比利时)
            .put("NL-NL", "nl")// 荷兰文 (荷兰)
            .put("NN", "")// 挪威尼诺斯克文
            .put("NO", "nor")// 挪威文
            .put("NR", "")// 南恩德比利文
            .put("NV", "")// 纳瓦霍文
            .put("NY", "")// 尼扬扎文
            .put("OC", "")// 奥西坦文
            .put("OJ", "")// 奥吉布瓦文
            .put("OM", "")// 阿曼文
            .put("OR", "")// 欧里亚文
            .put("OS", "oss")// 奥塞梯文
            .put("PA", "pan")// 旁遮普文
            .put("PA-IN", "")// 旁遮普文 (印度)
            .put("PA-PK", "")// 旁遮普文 (巴基斯坦)
            .put("PI", "")// 巴利文
            .put("PL", "pl")// 波兰文
            .put("PS", "pus")// 普什图文
            .put("PT", "pt")// 葡萄牙文
            .put("PT-BR", "pot")// 葡萄牙文 (巴西)
            .put("PT-PT", "pt")// 葡萄牙文 (葡萄牙)
            .put("QU", "")// 盖丘亚文
            .put("RM", "")// 里托罗曼斯文
            .put("RN", "")// 基隆迪文
            .put("RO", "rom")// 罗马尼亚文
            .put("RU", "ru")// 俄文
            .put("RU-BY", "bel")// 俄文 (白俄罗斯)
            .put("RU-RU", "ru")// 俄文 (俄罗斯)
            .put("RW", "kin")// 卢旺达文
            .put("SA", "san")// 梵文
            .put("SC", "")// 撒丁文
            .put("SD", "")// 苏丹文
            .put("SD-IN", "")// 苏丹文 (印度)
            .put("SD-PK", "")// 苏丹文 (巴基斯坦)
            .put("SE", "")// 北沙密文
            .put("SG", "")// 桑戈文
            .put("SI", "sin")// 僧伽罗文
            .put("SK", "sk")// 斯洛伐克文
            .put("SL", "slo")// 斯洛文尼亚文
            .put("SM", "sm")// 萨摩亚文
            .put("SM-AS", "")// 萨摩亚文 (东萨摩亚)
            .put("SM-WS", "")// 萨摩亚文 (东萨摩亚)
            .put("SN", "")// 塞内加尔文
            .put("SO", "som")// 索马里文
            .put("SQ", "alb")// 阿尔巴尼亚文
            .put("SR", "srp")// 塞尔维亚文
            .put("SS", "")// 辛辛那提文
            .put("ST", "")// 塞索托文
            .put("SU", "")// 苏丹文
            .put("SV", "swe")// 瑞典文
            .put("SW", "swa")// 斯瓦希里文
            .put("TA", "tam")// 泰米尔文
            .put("TE", "tel")// 泰卢固文
            .put("TG", "tgk")// 塔吉克文
            .put("TH", "th")// 泰文
            .put("TI", "")// 提格里尼亚文
            .put("TK", "tuk")// 土库曼文
            .put("TL", "")// 塔加路族文
            .put("TN", "tua")// 突尼斯文
            .put("TO", "")// 汤加文
            .put("TR", "tr")// 土耳其文
            .put("TS", "")// 特松加文
            .put("TT", "tat")// 鞑靼文
            .put("TW", "twi")// 契维文
            .put("TY", "")// 塔希提文
            .put("UG", "")// 维吾尔文
            .put("UK", "ukr")// 乌克兰文
            .put("UR", "urd")// 乌尔都文
            .put("UR-IN", "")// 乌尔都文 (印度)
            .put("UR-PK", "")// 乌尔都文 (巴基斯坦)
            .put("UZ", "")// 乌兹别克文
            .put("VE", "ven")// 文达文
            .put("VI", "vie")// 越南文
            .put("VO", "")// 沃拉普克文
            .put("WA", "")// 瓦龙文
            .put("WO", "")// 沃尔夫文
            .put("XH", "")// 班图文
            .put("YI", "")// 依地文
            .put("YO", "yor")// 约鲁巴文
            .put("ZA", "")// 藏文
            .put("ZH", "zh")// 中文
            .put("ZH-CN", "zh")// 中文 (中国)
            .put("ZH-HK", "yue")// 中文 (香港)
            .put("ZH-TW", "cht")// 中文 (台湾地区)
            .put("ZU", "zul")// 祖鲁文
            .build();

    public static String translateOLang2BLang(final String sLang) {
        String tLang = OLANG_2_BLANG_MAP.get(sLang.toUpperCase());
        if (Objects.equals(tLang, "")) {
            // 百度翻译官方平台上没有的语种一律设为自动
            tLang = "auto";
        }
        return tLang;
    }

    private OLang2BLang() {
    }

}

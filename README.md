# OmegaT-百度翻译插件

一个能让 OmegaT 从百度翻译开放平台获取翻译的插件。官方没有提供测试 Key，必须先申请再配置使用。

### 使用方法

1. 登录百度翻译开放平台，根据提示信息，完成应用创建。应用创建成功后即可获取APP ID和密钥。
2. 克隆本项目，在项目根目录打开cmd，然后运行`./gradlew build`。
3. 在build/libs/目录下，拷贝.jar文件到OmegaT的/plugin目录。
4. 打开OmegaT，在“选项——首选项——机器翻译”中，勾选Baidu Translate，点击配置，然后填入第1步得到APP ID和密钥。
5. 打开你的翻译项目，此时应该能在机器翻译面板看到来自百度翻译的结果了。Enjoy it!

### 本项目参考了以下内容：

* [https://gitee.com/FengFeiYuTian/omegat-baidu-plugin](https://gitee.com/FengFeiYuTian/omegat-baidu-plugin)
* [https://gitee.com/xffish/omegat-youdao-plugin](https://gitee.com/xffish/omegat-youdao-plugin)
* [https://github.com/yoyicue/omegat-tencent-plugin](https://github.com/yoyicue/omegat-tencent-plugin)

### 请参阅：百度翻译开放平台官方文档

[http://api.fanyi.baidu.com/doc/21](http://api.fanyi.baidu.com/doc/21)
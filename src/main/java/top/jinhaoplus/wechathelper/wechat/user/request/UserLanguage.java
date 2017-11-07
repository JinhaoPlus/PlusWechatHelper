package top.jinhaoplus.wechathelper.wechat.user.request;

public enum UserLanguage {
    zh_CN("zh_CN"),
    zh_TW("zh_TW"),
    en("en");

    private String lang;

    UserLanguage(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}

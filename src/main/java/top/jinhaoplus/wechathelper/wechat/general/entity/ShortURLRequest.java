package top.jinhaoplus.wechathelper.wechat.general.entity;

public class ShortURLRequest {
    private String action = "long2short";
    private String long_url;

    public String getAction() {
        return action;
    }

    public ShortURLRequest(String long_url) {
        this.long_url = long_url;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }
}

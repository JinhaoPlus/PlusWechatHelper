package top.jinhaoplus.wechathelper.wechat.general.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class ShortURLResponse extends APIResponse {
    private String short_url;

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
}

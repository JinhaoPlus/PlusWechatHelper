package top.jinhaoplus.wechathelper.wechat.media.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class UploadImgResponse extends APIResponse {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

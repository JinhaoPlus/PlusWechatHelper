package top.jinhaoplus.wechathelper.wechat.media.request;

public class MaterialGetRequest {
    private String media_id;

    public MaterialGetRequest(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}

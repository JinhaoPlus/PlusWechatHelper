package top.jinhaoplus.wechathelper.wechat.media.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class NewsUploadResponse extends APIResponse {
    private String type;

    private String media_id;

    private Long created_at;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }
}

package top.jinhaoplus.wechathelper.wechat.user.response.tag;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.user.entity.Tag;

public class TagCreateResponse extends APIResponse{
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

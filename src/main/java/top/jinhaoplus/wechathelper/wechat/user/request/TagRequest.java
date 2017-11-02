package top.jinhaoplus.wechathelper.wechat.user.request;

import top.jinhaoplus.wechathelper.wechat.user.entity.Tag;

public class TagRequest {
    private Tag tag;

    public TagRequest(Integer tagId) {
        this.tag = new Tag();
        this.tag.setId(tagId);
    }

    public TagRequest(String tagName) {
        this.tag = new Tag();
        this.tag.setName(tagName);
    }

    public TagRequest(Integer tagId, String tagName) {
        this.tag = new Tag();
        this.tag.setId(tagId);
        this.tag.setName(tagName);
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

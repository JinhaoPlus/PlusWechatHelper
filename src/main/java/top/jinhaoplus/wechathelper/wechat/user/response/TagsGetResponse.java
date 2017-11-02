package top.jinhaoplus.wechathelper.wechat.user.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.user.entity.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagsGetResponse extends APIResponse{
    private List<Tag> tags = new ArrayList<>();

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

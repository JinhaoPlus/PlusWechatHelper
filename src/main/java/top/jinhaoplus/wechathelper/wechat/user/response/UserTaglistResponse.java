package top.jinhaoplus.wechathelper.wechat.user.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class UserTaglistResponse extends APIResponse{
    private List<Integer> tagid_list;

    public List<Integer> getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(List<Integer> tagid_list) {
        this.tagid_list = tagid_list;
    }
}

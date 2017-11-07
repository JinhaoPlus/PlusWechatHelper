package top.jinhaoplus.wechathelper.wechat.user.request.tag;

import java.util.ArrayList;
import java.util.List;

public class UserTagRequest {
    private List<String> openid_list = new ArrayList<>();
    private Integer tagid;

    public UserTagRequest(Integer tagid, List<String> openid_list) {
        this.tagid = tagid;
        this.openid_list = openid_list;
    }

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}

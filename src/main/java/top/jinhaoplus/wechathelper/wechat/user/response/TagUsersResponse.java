package top.jinhaoplus.wechathelper.wechat.user.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class TagUsersResponse extends APIResponse {
    private Integer count;
    private TagUsersData data;
    private String next_openid;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public TagUsersData getData() {
        return data;
    }

    public void setData(TagUsersData data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}

class TagUsersData{
    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}

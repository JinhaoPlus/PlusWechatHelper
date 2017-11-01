package top.jinhaoplus.wechathelper.wechat.user.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class UsersResponse extends APIResponse {
    private Long total;
    private Long count;
    private Openids data = new Openids();
    private String next_openid;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Openids getData() {
        return data;
    }

    public void setData(Openids data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}


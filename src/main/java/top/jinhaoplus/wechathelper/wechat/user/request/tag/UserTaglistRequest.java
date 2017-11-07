package top.jinhaoplus.wechathelper.wechat.user.request.tag;

public class UserTaglistRequest {
    private String openid;

    public UserTaglistRequest(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}

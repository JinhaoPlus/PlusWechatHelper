package top.jinhaoplus.wechathelper.wechat.user.request.blacklist;

public class BlackListRequest {
    private String begin_openid;

    public BlackListRequest(String begin_openid) {
        this.begin_openid = begin_openid;
    }

    public String getBegin_openid() {
        return begin_openid;
    }

    public void setBegin_openid(String begin_openid) {
        this.begin_openid = begin_openid;
    }
}

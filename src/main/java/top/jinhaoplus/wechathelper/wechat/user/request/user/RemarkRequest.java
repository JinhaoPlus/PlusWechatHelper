package top.jinhaoplus.wechathelper.wechat.user.request.user;

public class RemarkRequest {
    private String openid;
    private String remark;

    public RemarkRequest(String openid, String remark) {
        this.openid = openid;
        this.remark = remark;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

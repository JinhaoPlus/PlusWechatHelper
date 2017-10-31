package top.jinhaoplus.wechathelper.wechat.menu.response;


import top.jinhaoplus.wechathelper.wechat.api.APIResponse;

public class CustomizedMenuResponse extends APIResponse {
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

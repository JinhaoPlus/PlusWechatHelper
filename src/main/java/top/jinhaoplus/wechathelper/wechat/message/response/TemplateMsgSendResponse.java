package top.jinhaoplus.wechathelper.wechat.message.response;


import top.jinhaoplus.wechathelper.wechat.api.response.ErrorResponse;

public class TemplateMsgSendResponse extends ErrorResponse {

    private Integer msgid;

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }
}

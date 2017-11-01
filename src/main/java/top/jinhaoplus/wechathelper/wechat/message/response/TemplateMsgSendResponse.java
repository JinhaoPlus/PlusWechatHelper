package top.jinhaoplus.wechathelper.wechat.message.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class TemplateMsgSendResponse extends APIResponse {

    private Integer msgid;

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }
}

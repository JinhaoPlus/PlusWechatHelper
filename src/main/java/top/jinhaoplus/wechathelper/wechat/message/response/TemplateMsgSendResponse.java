package top.jinhaoplus.wechathelper.wechat.message.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class TemplateMsgSendResponse extends APIResponse {

    private Long msgid;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }
}

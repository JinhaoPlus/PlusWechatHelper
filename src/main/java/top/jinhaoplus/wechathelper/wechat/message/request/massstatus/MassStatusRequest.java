package top.jinhaoplus.wechathelper.wechat.message.request.massstatus;

public class MassStatusRequest {
    private Long msg_id;

    public MassStatusRequest(Long msg_id) {
        this.msg_id = msg_id;
    }

    public Long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Long msg_id) {
        this.msg_id = msg_id;
    }
}



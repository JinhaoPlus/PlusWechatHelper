package top.jinhaoplus.wechathelper.wechat.message.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class MassStatusResponse extends APIResponse {
    private Long msg_id;
    private String msg_status;

    public Long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Long msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_status() {
        return msg_status;
    }

    public void setMsg_status(String msg_status) {
        this.msg_status = msg_status;
    }
}

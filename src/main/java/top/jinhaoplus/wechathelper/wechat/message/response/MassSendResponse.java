package top.jinhaoplus.wechathelper.wechat.message.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class MassSendResponse extends APIResponse{
    private Long msg_id;
    private Long msg_data_id;

    public Long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Long msg_id) {
        this.msg_id = msg_id;
    }

    public Long getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(Long msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}

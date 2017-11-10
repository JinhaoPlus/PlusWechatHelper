package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.Filter;

import java.util.List;

public class MassSendRequest {

    protected Filter filter;

    protected List<String> touser;

    protected String msgtype;

    // 开发者侧群发msgid,长度限制64字节,如不填,则后台默认以群发范围和群发内容的摘要值做为clientmsgid
    protected String clientmsgid;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getClientmsgid() {
        return clientmsgid;
    }

    public void setClientmsgid(String clientmsgid) {
        this.clientmsgid = clientmsgid;
    }
}



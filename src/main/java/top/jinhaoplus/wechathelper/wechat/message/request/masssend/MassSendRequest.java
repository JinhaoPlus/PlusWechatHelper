package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.models.masssend.Filter;

import java.util.List;

public class MassSendRequest {
    protected Filter filter;
    protected List<String> touser;
    protected String msgtype;

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
}



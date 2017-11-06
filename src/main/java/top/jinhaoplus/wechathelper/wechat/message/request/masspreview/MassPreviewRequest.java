package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.models.masssend.Filter;

public class MassPreviewRequest {
    protected Filter filter;
    protected String touser;
    protected String msgtype;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}



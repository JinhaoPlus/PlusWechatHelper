package top.jinhaoplus.wechathelper.wechat.message.models.masssend;

public enum MassSendMessageType {
    text("text"),
    image("image"),
    voice("voice"),
    mpvideo("mpvideo"),
    mpnews("mpnews"),
    wxcard("wxcard");

    private String msgType;

    MassSendMessageType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return msgType;
    }

    public Boolean equals(String type) {
        if (msgType.equals(type))
            return true;
        return false;
    }
}

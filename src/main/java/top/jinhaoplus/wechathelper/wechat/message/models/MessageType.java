package top.jinhaoplus.wechathelper.wechat.message.models;

public enum MessageType {
    text("text"),
    image("image"),
    voice("voice"),
    video("video"),
    shortvideo("shortvideo"),
    location("location"),
    link("link"),
    music("music"),
    news("news"),
    event("event");

    private String msgType;

    MessageType(String msgType) {
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

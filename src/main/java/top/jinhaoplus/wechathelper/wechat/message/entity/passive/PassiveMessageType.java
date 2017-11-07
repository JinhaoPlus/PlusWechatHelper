package top.jinhaoplus.wechathelper.wechat.message.entity.passive;

public enum PassiveMessageType {
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

    PassiveMessageType(String msgType) {
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

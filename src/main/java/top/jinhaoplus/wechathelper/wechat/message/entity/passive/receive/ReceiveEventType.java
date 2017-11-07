package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive;

public enum ReceiveEventType {
    subscribe("subscribe"),
    unsubscribe("unsubscribe"),
    SCAN("SCAN"),
    LOCATION("LOCATION"),
    CLICK("CLICK"),
    VIEW("VIEW"),
    TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH"),
    MASSSENDJOBFINISH("MASSSENDJOBFINISH");

    private String eventType;

    ReceiveEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return eventType;
    }

    public Boolean equals(String type) {
        if (eventType.equals(type))
            return true;
        return false;
    }
}

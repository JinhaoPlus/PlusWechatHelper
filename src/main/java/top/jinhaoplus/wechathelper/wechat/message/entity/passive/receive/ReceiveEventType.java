package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive;

// 收到消息的事件类型
public enum ReceiveEventType {
    // 订阅公众号事件
    subscribe("subscribe"),

    // 退订公众号事件
    unsubscribe("unsubscribe"),

    // 扫描带参数二维码事件
    SCAN("SCAN"),

    // 上报地理位置事件
    LOCATION("LOCATION"),

    // 自定义菜单事件
    //// 点击菜单拉取消息时的事件
    CLICK("CLICK"),
    //// 点击菜单跳转链接时的事件
    VIEW("VIEW"),
    //// 扫码推事件的事件推送
    scancode_push("scancode_push"),
    //// 扫码推事件且弹出"消息接收中"提示框的事件推送
    scancode_waitmsg("scancode_waitmsg"),
    //// 弹出系统拍照发图的事件推送
    pic_sysphoto("pic_sysphoto"),
    //// 弹出拍照或者相册发图的事件推送
    pic_photo_or_album("pic_photo_or_album"),
    //// 弹出微信相册发图器的事件推送
    pic_weixin("pic_weixin"),

    // 弹出地理位置选择器的事件
    location_select("location_select"),

    // 模版消息发送成功事件
    TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH"),
    // 群发消息发送成功事件
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

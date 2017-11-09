package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveLocationReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveQRCodeReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveSubUnsubReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.menuevent.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveEventMessage extends ReceiveMessage {

    private final static Map<String, Class<? extends ReceiveEventMessage>> eventBindMap = new HashMap<String, Class<? extends ReceiveEventMessage>>() {{
        put("subscribe", ReceiveSubUnsubReceiveEventMessage.class);
        put("unsubscribe", ReceiveSubUnsubReceiveEventMessage.class);
        put("SCAN", ReceiveQRCodeReceiveEventMessage.class);
        put("LOCATION", ReceiveLocationReceiveEventMessage.class);
        put("CLICK", ReceiveMenuClickEventMessage.class);
        put("VIEW", ReceiveMenuViewEventMessage.class);
        put("scancode_push", ReceiveMenuScancodeEventMessage.class);
        put("scancode_waitmsg", ReceiveMenuScancodeEventMessage.class);
        put("pic_sysphoto", ReceiveMenuPicEventMessage.class);
        put("pic_photo_or_album", ReceiveMenuPicEventMessage.class);
        put("pic_weixin", ReceiveMenuPicEventMessage.class);
        put("location_select", ReceiveMenuLocationSelectEventMessage.class);
        put("TEMPLATESENDJOBFINISH", ReceiveSubUnsubReceiveEventMessage.class);
        put("MASSSENDJOBFINISH", ReceiveSubUnsubReceiveEventMessage.class);
    }};

    @XmlElement(name = "Event")
    protected String event;

    public ReceiveEventMessage() {
        super.msgType = "event";
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public static Class<? extends ReceiveEventMessage> getEventClass(String messageStr, ReceiveEventMessage receiveEventMessage) {
        return eventBindMap.get(receiveEventMessage.getEvent());
    }
}

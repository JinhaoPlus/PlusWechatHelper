package top.jinhaoplus.wechathelper.wechat.message.models.receive;

import top.jinhaoplus.wechathelper.wechat.message.models.receive.event.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveEventMessage extends ReceiveMessage {

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
        if ((ReceiveEventType.subscribe.equals(receiveEventMessage.getEvent())
                || ReceiveEventType.unsubscribe.equals(receiveEventMessage.getEvent()))
                && !messageStr.contains("EventKey")) {
            return ReceiveSubUnsubReceiveEventMessage.class;
        } else if ((ReceiveEventType.subscribe.equals(receiveEventMessage.getEvent())
                || ReceiveEventType.SCAN.equals(receiveEventMessage.getEvent()))
                && messageStr.contains("EventKey")) {
            return ReceiveQRCodeReceiveEventMessage.class;
        } else if (ReceiveEventType.LOCATION.equals(receiveEventMessage.getEvent())) {
            return ReceiveLocationReceiveEventMessage.class;
        } else if (ReceiveEventType.CLICK.equals(receiveEventMessage.getEvent())
                || ReceiveEventType.VIEW.equals(receiveEventMessage.getEvent())) {
            return ReceiveCustomizedMenuReceiveEventMessage.class;
        } else if (ReceiveEventType.TEMPLATESENDJOBFINISH.equals(receiveEventMessage.getEvent())) {
            return ReceiveTemplateJobFinishEventMessage.class;
        } else
            return ReceiveEventMessage.class;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveCustomizedMenuReceiveEventMessage extends ReceiveEventMessage {

    @XmlElement(name = "EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.jobevent;


import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveTemplateJobFinishEventMessage extends ReceiveEventMessage {

    @XmlElement(name = "Status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

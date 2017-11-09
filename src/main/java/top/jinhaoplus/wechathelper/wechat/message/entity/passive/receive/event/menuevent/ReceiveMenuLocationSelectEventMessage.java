package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.menuevent;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//扫码推事件的事件推送

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveMenuLocationSelectEventMessage extends ReceiveEventMessage {

    @XmlElement(name = "EventKey")
    private String eventKey;

    @XmlElement(name = "ScanCodeInfo")
    private SendLocationInfo sendLocationInfo;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }
}

class SendLocationInfo{

    private String location_X;

    private String location_Y;

    private String scale;

    private String label;

    private String poiname;

    @XmlElement(name = "Location_X")
    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    @XmlElement(name = "Location_Y")
    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    @XmlElement(name = "Scale")
    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @XmlElement(name = "Label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name = "Poiname")
    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }
}
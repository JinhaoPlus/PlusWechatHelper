package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data;


//    <xml>
//        <ToUserName><![CDATA[toUser]]></ToUserName>
//        <FromUserName><![CDATA[fromUser]]></FromUserName>
//        <CreateTime>1348831860</CreateTime>
//        <MsgType><![CDATA[text]]></MsgType>
//        <Content><![CDATA[this is a test]]></Content>
//        <MsgId>1234567890123456</MsgId>
//    </xml>

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveLocationMessage extends ReceiveMessage {

    @XmlElement(name = "Location_X")
    private Double locationX;

    @XmlElement(name = "Location_Y")
    private Double locationY;

    @XmlElement(name = "Scale")
    private Double scale;

    @XmlElement(name = "Label")
    private String label;

    public ReceiveLocationMessage(){
        super.msgType="location";
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

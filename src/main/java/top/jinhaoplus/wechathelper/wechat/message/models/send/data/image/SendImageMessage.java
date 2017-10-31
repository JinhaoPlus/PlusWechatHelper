package top.jinhaoplus.wechathelper.wechat.message.models.send.data.image;


//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1348831860</CreateTime>
//    <MsgType><![CDATA[image]]></MsgType>
//    <PicUrl><![CDATA[this is a url]]></PicUrl>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    <MsgId>1234567890123456</MsgId>
//</xml>

import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendImageMessage extends SendMessage {

    @XmlElement(name = "Image")
    private Image image;

    public SendImageMessage() {
        super.msgType = "image";
        image = new Image();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}


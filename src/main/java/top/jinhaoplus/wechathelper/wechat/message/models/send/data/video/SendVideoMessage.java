package top.jinhaoplus.wechathelper.wechat.message.models.send.data.video;


import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[video]]></MsgType>
//    <Video>
//        <MediaId><![CDATA[media_id]]></MediaId>
//        <Title><![CDATA[title]]></Title>
//        <Description><![CDATA[description]]></Description>
//    </Video>
//</xml>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendVideoMessage extends SendMessage {

    @XmlElement(name = "Video")
    private Video video;

    public SendVideoMessage() {
        super.msgType = "video";
        video = new Video();
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}


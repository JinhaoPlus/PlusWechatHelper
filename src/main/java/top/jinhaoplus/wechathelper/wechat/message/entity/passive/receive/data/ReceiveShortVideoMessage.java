package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data;


import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1357290913</CreateTime>
//    <MsgType><![CDATA[shortvideo]]></MsgType>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
//    <MsgId>1234567890123456</MsgId>
//</xml>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveShortVideoMessage extends ReceiveMessage {

    @XmlElement(name = "MediaId")
    private String mediaId;
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    public ReceiveShortVideoMessage(){
        super.msgType="shortvideo";
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}

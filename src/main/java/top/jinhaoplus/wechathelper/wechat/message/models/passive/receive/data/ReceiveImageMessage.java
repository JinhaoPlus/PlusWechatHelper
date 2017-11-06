package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data;


//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1348831860</CreateTime>
//    <MsgType><![CDATA[image]]></MsgType>
//    <PicUrl><![CDATA[this is a url]]></PicUrl>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    <MsgId>1234567890123456</MsgId>
//</xml>

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveImageMessage extends ReceiveMessage {

    @XmlElement(name = "PicUrl")
    private String picUrl;
    @XmlElement(name = "MediaId")
    private String mediaId;

    public ReceiveImageMessage(){
        super.msgType="image";
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

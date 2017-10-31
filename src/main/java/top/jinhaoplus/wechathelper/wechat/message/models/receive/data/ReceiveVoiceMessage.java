package top.jinhaoplus.wechathelper.wechat.message.models.receive.data;


//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1357290913</CreateTime>
//    <MsgType><![CDATA[voice]]></MsgType>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    <Format><![CDATA[Format]]></Format>
//    <MsgId>1234567890123456</MsgId>
//</xml>

import top.jinhaoplus.wechathelper.wechat.message.models.receive.ReceiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveVoiceMessage extends ReceiveMessage {

    @XmlElement(name = "MediaId")
    private String mediaId;
    @XmlElement(name = "Format")
    private String format;
    @XmlElement(name = "Recognition")
    private String recognition;

    public ReceiveVoiceMessage(){
        super.msgType="voice";
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}

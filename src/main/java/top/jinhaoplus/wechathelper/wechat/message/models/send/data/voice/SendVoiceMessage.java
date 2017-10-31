package top.jinhaoplus.wechathelper.wechat.message.models.send.data.voice;


import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[voice]]></MsgType>
//    <Voice>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    </Voice>
//</xml>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendVoiceMessage extends SendMessage {

    @XmlElement(name = "Voice")
    private Voice voice;

    public SendVoiceMessage() {
        super.msgType = "voice";
        voice = new Voice();
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}


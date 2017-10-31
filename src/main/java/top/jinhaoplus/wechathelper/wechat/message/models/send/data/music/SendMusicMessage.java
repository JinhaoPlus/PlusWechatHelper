package top.jinhaoplus.wechathelper.wechat.message.models.send.data.music;


//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>1357290913</CreateTime>
//    <MsgType><![CDATA[voice]]></MsgType>
//    <MediaId><![CDATA[media_id]]></MediaId>
//    <Format><![CDATA[Format]]></Format>
//    <MsgId>1234567890123456</MsgId>
//</xml>

import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendMusicMessage extends SendMessage {

    @XmlElement(name = "MediaId")
    private Music music;

    public SendMusicMessage() {
        super.msgType = "music";
        music = new Music();
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}


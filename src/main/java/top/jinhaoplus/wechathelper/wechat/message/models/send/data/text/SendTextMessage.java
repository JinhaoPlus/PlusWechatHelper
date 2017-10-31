package top.jinhaoplus.wechathelper.wechat.message.models.send.data.text;


import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[text]]></MsgType>
//    <Content><![CDATA[你好]]></Content>
//</xml>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendTextMessage extends SendMessage {

    @XmlElement(name = "Content")
    private String content;

    public SendTextMessage(){
        super.msgType="text";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

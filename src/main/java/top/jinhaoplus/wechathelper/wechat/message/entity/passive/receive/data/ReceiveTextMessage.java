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
public class ReceiveTextMessage extends ReceiveMessage {

    @XmlElement(name = "Content")
    private String content;

    public ReceiveTextMessage(){
        super.msgType="text";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

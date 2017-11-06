package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data;


//    <xml>
//        <ToUserName><![CDATA[toUser]]></ToUserName>
//        <FromUserName><![CDATA[fromUser]]></FromUserName>
//        <CreateTime>1348831860</CreateTime>
//        <MsgType><![CDATA[text]]></MsgType>
//        <Content><![CDATA[this is a test]]></Content>
//        <MsgId>1234567890123456</MsgId>
//    </xml>

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveLinkMessage extends ReceiveMessage {

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Url")
    private String url;

    public ReceiveLinkMessage() {
        super.msgType = "link";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

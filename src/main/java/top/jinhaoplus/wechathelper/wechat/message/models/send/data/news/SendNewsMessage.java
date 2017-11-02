package top.jinhaoplus.wechathelper.wechat.message.models.send.data.news;


import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

//<xml>
//    <ToUserName><![CDATA[toUser]]></ToUserName>
//    <FromUserName><![CDATA[fromUser]]></FromUserName>
//    <CreateTime>12345678</CreateTime>
//    <MsgType><![CDATA[news]]></MsgType>
//    <ArticleCount>2</ArticleCount>
//    <Articles>
//        <item>
//            <Title><![CDATA[title1]]></Title>
//            <Description><![CDATA[description1]]></Description>
//            <PicUrl><![CDATA[picurl]]></PicUrl>
//            <Url><![CDATA[url]]></Url>
//        </item>
//        <item>
//            <Title><![CDATA[title]]></Title>
//            <Description><![CDATA[description]]></Description>
//            <PicUrl><![CDATA[picurl]]></PicUrl>
//            <Url><![CDATA[url]]></Url>
//        </item>
//    </Articles>
//</xml>

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class SendNewsMessage extends SendMessage {

    @XmlElement(name = "ArticleCount")
    private Integer articleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name="item")
    private List<Item> articles;

    public SendNewsMessage() {
        super.msgType = "news";
        articles = new ArrayList<>();
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }
}
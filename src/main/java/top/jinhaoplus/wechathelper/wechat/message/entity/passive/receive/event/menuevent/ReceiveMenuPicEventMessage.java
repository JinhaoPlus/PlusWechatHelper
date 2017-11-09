package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.menuevent;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.*;
import java.util.List;

//扫码推事件的事件推送

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveMenuPicEventMessage extends ReceiveEventMessage {

    @XmlElement(name = "EventKey")
    private String eventKey;

    @XmlElement(name = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }


}

class SendPicsInfo {


    private Integer count;

    private List<PicListItem> picList;

    @XmlElement(name = "Count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @XmlElementWrapper(name = "PicList")
    @XmlElement(name="item")
    public List<PicListItem> getPicList() {
        return picList;
    }

    public void setPicList(List<PicListItem> picList) {
        this.picList = picList;
    }
}

class PicListItem {
    private String picMd5Sum;

    @XmlElement(name = "PicMd5Sum")
    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }
}

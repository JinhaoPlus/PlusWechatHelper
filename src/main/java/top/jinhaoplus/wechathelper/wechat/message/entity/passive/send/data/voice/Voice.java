package top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.data.voice;

import javax.xml.bind.annotation.XmlElement;

public class Voice {

    private String mediaId;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

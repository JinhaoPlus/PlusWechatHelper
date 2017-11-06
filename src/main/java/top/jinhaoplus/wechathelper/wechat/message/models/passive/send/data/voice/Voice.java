package top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.voice;

import javax.xml.bind.annotation.XmlElement;

public class Voice {
    @XmlElement(name = "MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

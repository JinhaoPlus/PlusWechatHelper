package top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.image;

import javax.xml.bind.annotation.XmlElement;

public class Image{
    @XmlElement(name = "MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

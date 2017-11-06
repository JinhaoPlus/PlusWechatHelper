package top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.video;

import javax.xml.bind.annotation.XmlElement;

public class Video {
    @XmlElement(name = "MediaId")
    private String mediaId;

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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
}

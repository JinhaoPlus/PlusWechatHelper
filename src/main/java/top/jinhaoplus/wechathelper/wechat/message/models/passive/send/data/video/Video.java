package top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.video;

import javax.xml.bind.annotation.XmlElement;

public class Video {

    private String mediaId;

    private String title;

    private String description;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MediaMassSendContent;

public class ImageMassSendRequest extends MassSendRequest {

    public ImageMassSendRequest(MediaMassSendContent image) {
        this.image = image;
        super.msgtype = MassSendMessageType.image.toString();
    }

    private MediaMassSendContent image;

    public MediaMassSendContent getImage() {
        return image;
    }

    public void setImage(MediaMassSendContent image) {
        this.image = image;
    }
}



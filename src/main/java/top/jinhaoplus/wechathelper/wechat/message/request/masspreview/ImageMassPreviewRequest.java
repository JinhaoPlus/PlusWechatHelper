package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.models.masssend.MediaMassSendContent;
import top.jinhaoplus.wechathelper.wechat.message.models.masssend.MassSendMessageType;

public class ImageMassPreviewRequest extends MassPreviewRequest {

    public ImageMassPreviewRequest(MediaMassSendContent image) {
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



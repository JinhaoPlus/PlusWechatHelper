package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.models.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.masssend.MediaMassSendContent;

public class MpVideoMassPreviewRequest extends MassPreviewRequest {

    public MpVideoMassPreviewRequest(MediaMassSendContent mpvideo) {
        this.mpvideo = mpvideo;
        super.msgtype = MassSendMessageType.mpvideo.toString();
    }

    private MediaMassSendContent mpvideo;


    public MediaMassSendContent getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(MediaMassSendContent mpvideo) {
        this.mpvideo = mpvideo;
    }
}



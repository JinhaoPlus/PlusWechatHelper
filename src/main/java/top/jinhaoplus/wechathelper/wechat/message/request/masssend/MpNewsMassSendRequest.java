package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MediaMassSendContent;

public class MpNewsMassSendRequest extends MassSendRequest {

    public MpNewsMassSendRequest(MediaMassSendContent mpnews) {
        this.mpnews = mpnews;
        super.msgtype = MassSendMessageType.mpnews.toString();
    }

    private MediaMassSendContent mpnews;
    private Integer send_ignore_reprint;


    public MediaMassSendContent getMpnews() {
        return mpnews;
    }

    public void setMpnews(MediaMassSendContent mpnews) {
        this.mpnews = mpnews;
    }

    public Integer getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(Integer send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }
}



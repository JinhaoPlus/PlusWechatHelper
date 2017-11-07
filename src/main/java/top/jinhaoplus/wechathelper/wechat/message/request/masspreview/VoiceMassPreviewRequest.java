package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MediaMassSendContent;

public class VoiceMassPreviewRequest extends MassPreviewRequest {

    public VoiceMassPreviewRequest(MediaMassSendContent voice) {
        this.voice = voice;
        super.msgtype = MassSendMessageType.voice.toString();
    }

    private MediaMassSendContent voice;

    public MediaMassSendContent getVoice() {
        return voice;
    }

    public void setVoice(MediaMassSendContent voice) {
        this.voice = voice;
    }
}



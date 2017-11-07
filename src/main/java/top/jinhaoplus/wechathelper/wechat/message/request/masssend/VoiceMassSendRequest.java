package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MediaMassSendContent;

public class VoiceMassSendRequest extends MassSendRequest {

    public VoiceMassSendRequest(MediaMassSendContent voice) {
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



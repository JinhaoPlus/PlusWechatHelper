package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.WxcardMassSendContent;

public class WxcardMassPreviewRequest extends MassPreviewRequest {

    public WxcardMassPreviewRequest(WxcardMassSendContent wxcard) {
        this.wxcard = wxcard;
        super.msgtype = MassSendMessageType.wxcard.toString();
    }

    private WxcardMassSendContent wxcard;

    public WxcardMassSendContent getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxcardMassSendContent wxcard) {
        this.wxcard = wxcard;
    }
}



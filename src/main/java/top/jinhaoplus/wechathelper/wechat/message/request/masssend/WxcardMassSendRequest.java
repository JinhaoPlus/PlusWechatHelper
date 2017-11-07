package top.jinhaoplus.wechathelper.wechat.message.request.masssend;

import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.WxcardMassSendContent;

public class WxcardMassSendRequest extends MassSendRequest {

    public WxcardMassSendRequest(WxcardMassSendContent wxcard) {
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



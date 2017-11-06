package top.jinhaoplus.wechathelper.wechat.message.request.masspreview;

import top.jinhaoplus.wechathelper.wechat.message.models.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.masssend.TextMassSendContent;

public class TextMassPreviewRequest extends MassPreviewRequest {

    public TextMassPreviewRequest(TextMassSendContent text) {
        this.text = text;
        super.msgtype = MassSendMessageType.text.toString();
    }

    private TextMassSendContent text;

    public TextMassSendContent getText() {
        return text;
    }

    public void setText(TextMassSendContent text) {
        this.text = text;
    }
}



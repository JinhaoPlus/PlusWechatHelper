package top.jinhaoplus.wechathelper.wechat.message.models.masssend;

public class WxcardMassSendContent {
    private String card_id;

    public WxcardMassSendContent(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}

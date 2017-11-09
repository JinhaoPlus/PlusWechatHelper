package top.jinhaoplus.wechathelper.wechat.message;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.TemplateDataItem;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.TemplateSendRequest;
import top.jinhaoplus.wechathelper.wechat.message.request.massspeed.MassSpeedRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageAPITest {
    @Test
    public void getTemplateList() throws Exception {
        MessageAPI.getTemplateList(BasicAPI.getAccessTokenStr());
    }

    @Test
    public void sendTemplateMessage() throws Exception {
        TemplateSendRequest request = new TemplateSendRequest();
        request.setTemplate_id("NkGqYrq6wttxNzzvv_xVRnwUTq24ZXLfz-qhK43GH94");
        request.setTouser("oAW2LwuROOjVpKJLGZlVEaq0h60c");
        request.setData(new HashMap<String, TemplateDataItem>() {{
            put("result", new TemplateDataItem("恭喜您得奖", "#173177"));
            put("withdrawMoney", new TemplateDataItem("1000元", "#173177"));
            put("withdrawTime", new TemplateDataItem("2017年1月16日", "#173177"));
            put("cardInfo", new TemplateDataItem("62010011112222", "#173177"));
            put("arrivedTime", new TemplateDataItem("2017年1月16日", "#173177"));
            put("remark", new TemplateDataItem("领奖喽", "#173177"));
        }});
        MessageAPI.sendTemplateMessage(BasicAPI.getAccessTokenStr(), request);
    }

    @Test
    public void deleteTemplate() throws Exception {
        MessageAPI.deleteTemplate(BasicAPI.getAccessTokenStr(), "pcawJaexVnm1klrMoBRhQ6HX-uSfN3DfJC5ZNdjj7Bg");
    }

    @Test
    public void massSendByTag() throws Exception {
        MessageAPI.massSendByTag(BasicAPI.getAccessTokenStr(), MassSendMessageType.text, "你好呀abc", 102);
//        MessageAPI.massSendByTag(BasicAPI.getAccessTokenStr(), MassSendMessageType.image, "TfyMrCu3iSoUpqscSAt-3XGCmmuanPsBs_qD1vEt1kk", 102);
    }

    @Test
    public void massSendByOpenIds() throws Exception {
        MessageAPI.massSendByOpenIds(BasicAPI.getAccessTokenStr(), MassSendMessageType.text, "你好呀呀呀", new ArrayList<String>() {{
            add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
            add("oAW2LwuROOjVpKJLGZlVEaq0h60c");
        }});
    }

    @Test
    public void previewMassSend() throws Exception {
//        MessageAPI.previewMassSend(BasicAPI.getAccessTokenStr(), MassSendMessageType.text, "hhh", "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        MessageAPI.previewMassSend(BasicAPI.getAccessTokenStr(), MassSendMessageType.mpnews, "TfyMrCu3iSoUpqscSAt-3Xb-EmFL_UJDC4-Vwc9-RCk", "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
    }

    @Test
    public void deleteMassSend() throws Exception {
        MessageAPI.deleteMassSend(BasicAPI.getAccessTokenStr(), 3147483654L, 0);
    }

    @Test
    public void getMassSendStatus() throws Exception {
        MessageAPI.getMassSendStatus(BasicAPI.getAccessTokenStr(), 3147483654L);
    }

    @Test
    public void setMassSendSpeed() throws Exception {
        MessageAPI.setMassSendSpeed(BasicAPI.getAccessTokenStr(), MassSpeedRequest.MassSpeed.MASS_SPEED4);
    }

}
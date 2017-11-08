package top.jinhaoplus.wechathelper.wechat.message;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.MassSendMessageType;
import top.jinhaoplus.wechathelper.wechat.message.request.massspeed.MassSpeedRequest;

import java.util.ArrayList;

public class MessageAPITest {

    @Test
    public void deleteTemplate() throws Exception {
        MessageAPI.deleteTemplate(BasicAPI.getAccessTokenStr(), "pcawJaexVnm1klrMoBRhQ6HX-uSfN3DfJC5ZNdjj7Bg");
    }

    @Test
    public void massSendByTag() throws Exception {
        MessageAPI.massSendByTag(BasicAPI.getAccessTokenStr(), MassSendMessageType.text, "你好哈CCC", 102);
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
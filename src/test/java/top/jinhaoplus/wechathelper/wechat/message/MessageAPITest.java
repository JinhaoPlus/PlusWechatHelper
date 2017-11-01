package top.jinhaoplus.wechathelper.wechat.message;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;

public class MessageAPITest {
    @Test
    public void deleteTemplate() throws Exception {
        MessageAPI.deleteTemplate(BasicAPI.getAccessTokenStr(),"pcawJaexVnm1klrMoBRhQ6HX-uSfN3DfJC5ZNdjj7Bg");
    }

}
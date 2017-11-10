package top.jinhaoplus.wechathelper.wechat.basic;

import org.junit.Test;

public class BasicAPITest {

    @Test
    public void getRefreshAccessToken() throws Exception {
        System.out.println(BasicAPI.getRefreshAccessToken().getAccess_token());
    }

    @Test
    public void getAccessToken() throws Exception {
        BasicAPI.getAccessToken();
    }

    @Test
    public void getAccessTokenStr() throws Exception {
        System.out.println(BasicAPI.getAccessTokenStr());
    }

    @Test
    public void getWechatIPList() throws Exception {
        BasicAPI.getWechatIPList();
    }


}
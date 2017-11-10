package top.jinhaoplus.wechathelper.wechat.analyse;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.analyse.response.ArticleDailyAnalyseResponse;
import top.jinhaoplus.wechathelper.wechat.analyse.response.UpsteamMsgAnalyseResponse;
import top.jinhaoplus.wechathelper.wechat.analyse.response.UserAnalyseResponse;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;

public class AnalyseAPITest {


    @Test
    public void getUserCumulate() throws Exception {
        UserAnalyseResponse response = AnalyseAPI.getUserCumulate(BasicAPI.getAccessTokenStr(), "2017-10-16", "2017-10-22");
        System.out.println(response);
    }

    @Test
    public void getUserSummary() throws Exception {
        UserAnalyseResponse response = AnalyseAPI.getUserSummary(BasicAPI.getAccessTokenStr(), "2017-10-16", "2017-10-22");
        System.out.println(response);
    }

    @Test
    public void getArticleSummary() throws Exception {
        ArticleDailyAnalyseResponse response = AnalyseAPI.getArticleSummary(BasicAPI.getAccessTokenStr(), "2017-11-08", "2017-11-08");
        System.out.println(response);
    }

    @Test
    public void getUpstreamMsg() throws Exception {
        UpsteamMsgAnalyseResponse response = AnalyseAPI.getUpstreamMsg(BasicAPI.getAccessTokenStr(),"2017-11-08", "2017-11-08");
        System.out.println(response);
    }
}
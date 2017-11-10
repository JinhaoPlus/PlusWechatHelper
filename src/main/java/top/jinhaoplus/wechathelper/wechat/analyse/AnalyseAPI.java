package top.jinhaoplus.wechathelper.wechat.analyse;

import top.jinhaoplus.wechathelper.wechat.analyse.request.AnalyseRequest;
import top.jinhaoplus.wechathelper.wechat.analyse.response.*;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.exception.WechatAPIException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnalyseAPI extends ServiceAPI {

    /**
     * 判断输入的起始日期是否在合法时间跨度内
     *
     * @param beginDate    开始日期
     * @param endDate      结束日期
     * @param legalDaySpan 合法跨度天数
     * @return
     */
    private static boolean isDatespanIllegal(String beginDate, String endDate, Integer legalDaySpan) {
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDay = dateFormater.parse(beginDate);
            Date endDay = dateFormater.parse(endDate);
            return endDay.getTime() - beginDay.getTime() >= legalDaySpan * 24 * 3600 * 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new WechatAPIException("输入的日期格式存在错误");
        }
    }

    /**
     * 获取用户增减数据(最大时间跨度设置为7)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为7时,begin_date和end_date的差值只能为6,才能小于7),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UserAnalyseResponse getUserSummary(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 7))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getusersummary"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UserAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UserAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取累计用户数据(最大时间跨度设置为7)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为7时,begin_date和end_date的差值只能为6,才能小于7),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UserAnalyseResponse getUserCumulate(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 7))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getusercumulate"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UserAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UserAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文群发每日数据(最大时间跨度设置为1)
     * 获取的是某天所有被阅读过的文章(仅包括群发的文章)在当天的阅读次数等数据
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleDailyAnalyseResponse getArticleSummary(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 1))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getarticlesummary"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleDailyAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleDailyAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文群发总数据(最大时间跨度设置为1)
     * 获取的是某天群发的文章从群发日起到接口调用日(但最多统计发表日后7天数据),每天的到当天的总数据
     * 例如某篇文章是12月1日发出的,发出后在1日、2日、3日的阅读次数分别为1万
     * 则getarticletotal获取到的数据为,距发出到12月1日24时的总阅读量为1万,距发出到12月2日24时的总阅读量为2万,距发出到12月1日24时的总阅读量为3万
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleTotalAnalyseResponse getArticleTotal(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 1))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getarticletotal"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleTotalAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleTotalAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文统计数据(最大时间跨度设置为3)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleDailyAnalyseResponse getUserRead(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 3))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getuserread"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleDailyAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleDailyAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文统计分时数据(最大时间跨度设置为1)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleHourAnalyseResponse getUserReadHour(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 1))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getuserreadhour"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleHourAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleHourAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文分享转发数据(最大时间跨度设置为7)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleDailyAnalyseResponse getUserShare(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 7))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getusershare"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleDailyAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleDailyAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取图文分享转发分时数据(最大时间跨度设置为1)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static ArticleHourAnalyseResponse getUserShareHour(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 1))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getusersharehour"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        ArticleHourAnalyseResponse response = invokeAPI(url, ApiMethod.POST, ArticleHourAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送概况数据(最大时间跨度设置为7)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsg(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 7))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsg"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息分送分时数据(最大时间跨度设置为1)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgHour(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 7))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsghour"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送周数据(最大时间跨度设置为30)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgWeek(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 30))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsgweek"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送月数据(最大时间跨度设置为30)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgMonth(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 30))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsgmonth"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送分布数据(最大时间跨度设置为15)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgDist(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 15))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsgdist"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送分布周数据(最大时间跨度设置为30)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgDistWeek(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 30))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsgdistweek"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取消息发送分布月数据(最大时间跨度设置为30)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static UpsteamMsgAnalyseResponse getUpstreamMsgDistMonth(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 30))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getupstreammsgdistmonth"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        UpsteamMsgAnalyseResponse response = invokeAPI(url, ApiMethod.POST, UpsteamMsgAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取接口分析数据(最大时间跨度设置为30)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static InterfaceAnalyseResponse getInterfaceSummary(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 30))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getinterfacesummary"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        InterfaceAnalyseResponse response = invokeAPI(url, ApiMethod.POST, InterfaceAnalyseResponse.class, request);
        return response;
    }

    /**
     * 获取接口分析分时数据(最大时间跨度设置为1)
     *
     * @param accessToken
     * @param beginDate   获取数据的起始日期: 格式为YYYY-mm-dd
     *                    begin_date和end_date的差值需小于"最大时间跨度"(比如最大时间跨度为1时,begin_date和end_date的差值只能为0,才能小于1),否则会报错
     * @param endDate     获取数据的结束日期,end_date允许设置的最大值为昨日
     * @return
     */
    public static InterfaceAnalyseResponse getInterfaceSummaryHour(String accessToken, String beginDate, String endDate) {
        if (isDatespanIllegal(beginDate, endDate, 1))
            throw new WechatAPIException("输入日期跨度不合法");
        String url = formatUrl(wechatProperties.getProperty("url.analyse.getinterfacesummaryhour"), new String[]{accessToken});
        AnalyseRequest request = new AnalyseRequest(beginDate, endDate);
        InterfaceAnalyseResponse response = invokeAPI(url, ApiMethod.POST, InterfaceAnalyseResponse.class, request);
        return response;
    }
}

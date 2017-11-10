package top.jinhaoplus.wechathelper.wechat.analyse.response;

import top.jinhaoplus.wechathelper.wechat.analyse.entity.ArticleAnalyseDailyTotalResult;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class ArticleTotalAnalyseResponse extends APIResponse{
    private List<ArticleAnalyseDailyTotalResult> list;

    public List<ArticleAnalyseDailyTotalResult> getList() {
        return list;
    }

    public void setList(List<ArticleAnalyseDailyTotalResult> list) {
        this.list = list;
    }
}

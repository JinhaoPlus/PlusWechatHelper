package top.jinhaoplus.wechathelper.wechat.analyse.response;

import top.jinhaoplus.wechathelper.wechat.analyse.entity.ArticleAnalyseDailyResult;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class ArticleDailyAnalyseResponse extends APIResponse{
    private List<ArticleAnalyseDailyResult> list;

    public List<ArticleAnalyseDailyResult> getList() {
        return list;
    }

    public void setList(List<ArticleAnalyseDailyResult> list) {
        this.list = list;
    }
}

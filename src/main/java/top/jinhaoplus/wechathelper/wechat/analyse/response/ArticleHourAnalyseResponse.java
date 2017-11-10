package top.jinhaoplus.wechathelper.wechat.analyse.response;

import top.jinhaoplus.wechathelper.wechat.analyse.entity.ArticleAnalyseHourResult;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class ArticleHourAnalyseResponse extends APIResponse{
    private List<ArticleAnalyseHourResult> list;

    public List<ArticleAnalyseHourResult> getList() {
        return list;
    }

    public void setList(List<ArticleAnalyseHourResult> list) {
        this.list = list;
    }
}

package top.jinhaoplus.wechathelper.wechat.media.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.media.entity.FullArticle;

import java.util.List;

public class NewsGetResponse extends APIResponse{

    private List<FullArticle> news_item;

    private Long create_time;

    private Long update_time;

    public List<FullArticle> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<FullArticle> news_item) {
        this.news_item = news_item;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}

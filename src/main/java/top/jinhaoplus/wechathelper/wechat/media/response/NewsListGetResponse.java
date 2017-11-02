package top.jinhaoplus.wechathelper.wechat.media.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.media.entity.FullArticle;

import java.util.List;

public class NewsListGetResponse extends APIResponse{

    private Integer total_count;
    private Integer item_count;
    private List<NewslistItem> item;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public List<NewslistItem> getItem() {
        return item;
    }

    public void setItem(List<NewslistItem> item) {
        this.item = item;
    }
}


class NewslistItem{
    private String media_id;
    private NewsListContent content;
    private Long update_time;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public NewsListContent getContent() {
        return content;
    }

    public void setContent(NewsListContent content) {
        this.content = content;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}

class NewsListContent{
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
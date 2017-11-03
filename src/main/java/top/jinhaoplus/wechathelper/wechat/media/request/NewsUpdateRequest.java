package top.jinhaoplus.wechathelper.wechat.media.request;

import top.jinhaoplus.wechathelper.wechat.media.entity.Article;

public class NewsUpdateRequest {
    private String media_id;

    private Integer index;

    private Article articles;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }
}

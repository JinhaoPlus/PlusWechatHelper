package top.jinhaoplus.wechathelper.wechat.media.entity;

import java.util.ArrayList;
import java.util.List;

public class NewsAddRequest {
    private List<Article> articles = new ArrayList<>();

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

package top.jinhaoplus.wechathelper.wechat.media.entity;

public class FullArticle extends Article{
    private String url;
    private String thumb_url;
    private Integer need_open_comment;
    private Integer only_fans_can_comment;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public Integer getNeed_open_comment() {
        return need_open_comment;
    }

    public void setNeed_open_comment(Integer need_open_comment) {
        this.need_open_comment = need_open_comment;
    }

    public Integer getOnly_fans_can_comment() {
        return only_fans_can_comment;
    }

    public void setOnly_fans_can_comment(Integer only_fans_can_comment) {
        this.only_fans_can_comment = only_fans_can_comment;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.request.massdelete;

public class MassDeleteRequest {
    private Long msg_id;
    private Integer article_idx;

    public MassDeleteRequest(Long msg_id, Integer article_idx) {
        this.msg_id = msg_id;
        this.article_idx = article_idx;
    }

    public Long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Long msg_id) {
        this.msg_id = msg_id;
    }

    public Integer getArticle_idx() {
        return article_idx;
    }

    public void setArticle_idx(Integer article_idx) {
        this.article_idx = article_idx;
    }
}



package top.jinhaoplus.wechathelper.wechat.comment.request;

public class CommentListRequest {
    public enum CommentType {
        all(0),
        common(1),
        markelect(2);

        private Integer type;

        CommentType(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }

        public String toString() {
            return String.valueOf(type);
        }
    }

    // 群发返回的msg_data_id
    private Long msg_data_id;

    // 多图文时，用来指定第几篇图文，从0开始
    // 不带默认操作该msg_data_id的第一篇图文
    private Integer index;

    // 起始位置
    private Integer begin;

    // 获取数目（>=50会被拒绝）
    private Integer count;

    // type=0 普通评论&精选评论
    // type=1 普通评论
    // type=2 精选评论
    private Integer commentType;

    public CommentListRequest(Long msg_data_id, Integer index, Integer begin, Integer count, CommentType commentType) {
        this.msg_data_id = msg_data_id;
        this.index = index;
        this.begin = begin;
        this.count = count;
        this.commentType = commentType.getType();
    }

    public Long getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(Long msg_data_id) {
        this.msg_data_id = msg_data_id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }
}

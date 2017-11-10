package top.jinhaoplus.wechathelper.wechat.comment.request;

public class CommentOperateRequest {
    // 群发返回的msg_data_id
    private Long msg_data_id;

    // 多图文时，用来指定第几篇图文，从0开始
    // 不带默认操作该msg_data_id的第一篇图文
    private Integer index;

    // 用户评论id
    private Long user_comment_id;

    //回复内容
    private String content;

    public CommentOperateRequest() {
    }

    public CommentOperateRequest(Long msg_data_id, Integer index) {
        this.msg_data_id = msg_data_id;
        this.index = index;
    }

    public CommentOperateRequest(Long msg_data_id, Integer index, Long user_comment_id) {
        this.msg_data_id = msg_data_id;
        this.index = index;
        this.user_comment_id = user_comment_id;
    }

    public CommentOperateRequest(Long msg_data_id, Integer index, Long user_comment_id, String content) {
        this.msg_data_id = msg_data_id;
        this.index = index;
        this.user_comment_id = user_comment_id;
        this.content = content;
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

    public Long getUser_comment_id() {
        return user_comment_id;
    }

    public void setUser_comment_id(Long user_comment_id) {
        this.user_comment_id = user_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

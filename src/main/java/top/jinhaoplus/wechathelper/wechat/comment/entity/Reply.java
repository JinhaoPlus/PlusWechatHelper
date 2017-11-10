package top.jinhaoplus.wechathelper.wechat.comment.entity;

public class Reply {

    //作者回复内容
    private String content;

    //作者回复时间
    private Long create_time;

    public Reply() {
    }

    public Reply(String content, Long create_time) {
        this.content = content;
        this.create_time = create_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
}

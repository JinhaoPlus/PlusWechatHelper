package top.jinhaoplus.wechathelper.wechat.comment.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.comment.entity.Comment;

import java.util.List;

public class CommentListResponse extends APIResponse{

    // 总数
    private Integer total;

    // 评论列表
    private List<Comment> comment;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}

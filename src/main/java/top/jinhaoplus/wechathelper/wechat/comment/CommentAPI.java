package top.jinhaoplus.wechathelper.wechat.comment;


import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.comment.request.CommentListRequest;
import top.jinhaoplus.wechathelper.wechat.comment.request.CommentOperateRequest;
import top.jinhaoplus.wechathelper.wechat.comment.response.CommentListResponse;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

import java.io.IOException;

public class CommentAPI extends ServiceAPI {

    /**
     * 打开已群发文章评论
     *
     * @param accessToken
     * @param msgDataId   群发返回的msg_data_id
     * @param index       多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @return
     * @throws IOException
     */
    public static APIResponse openComment(String accessToken, Long msgDataId, Integer index) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.opencomment"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 关闭已群发文章评论
     *
     * @param accessToken
     * @param msgDataId   群发返回的msg_data_id
     * @param index       多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @return
     * @throws IOException
     */
    public static APIResponse closeComment(String accessToken, Long msgDataId, Integer index) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.closecomment"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }


    /**
     * 查看指定文章的评论列表
     *
     * @param accessToken
     * @param msgDataId   群发返回的msg_data_id
     * @param index       多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param type        评论类型
     * @return
     * @throws IOException
     */
    public static CommentListResponse listComments(String accessToken, Long msgDataId, Integer index, CommentListRequest.CommentType type) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.commentlist"), new String[]{accessToken});
        Integer begin = 0;
        Integer count = 50;
        CommentListRequest request = new CommentListRequest(msgDataId, index, begin, count, type);
        CommentListResponse response = invokeAPI(url, ApiMethod.POST, CommentListResponse.class, JsonUtil.bean2str(request));
        return response;
    }


    /**
     * 将评论标记精选
     *
     * @param accessToken
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return
     * @throws IOException
     */
    public static APIResponse markelectComment(String accessToken, Long msgDataId, Integer index, Long userCommentId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.markelect"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index, userCommentId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 将评论取消精选
     *
     * @param accessToken
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return
     * @throws IOException
     */
    public static APIResponse unmarkelectComment(String accessToken, Long msgDataId, Integer index, Long userCommentId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.unmarkelect"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index, userCommentId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 删除评论
     *
     * @param accessToken
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return
     * @throws IOException
     */
    public static APIResponse deleteComment(String accessToken, Long msgDataId, Integer index, Long userCommentId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.deletecomment"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index, userCommentId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 回复评论
     *
     * @param accessToken
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @param replyContent  回复内容
     * @return
     * @throws IOException
     */
    public static APIResponse replyComment(String accessToken, Long msgDataId, Integer index, Long userCommentId, String replyContent) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.replycomment"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index, userCommentId, replyContent);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 删除回复
     *
     * @param accessToken
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时,用来指定第几篇图文,从0开始,不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return
     * @throws IOException
     */
    public static APIResponse deleteCommentReply(String accessToken, Long msgDataId, Integer index, Long userCommentId, String replyContent) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.comment.deletereply"), new String[]{accessToken});
        CommentOperateRequest request = new CommentOperateRequest(msgDataId, index, userCommentId, replyContent);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }
}

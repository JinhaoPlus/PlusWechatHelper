package top.jinhaoplus.wechathelper.wechat.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;
import top.jinhaoplus.wechathelper.wechat.user.request.*;
import top.jinhaoplus.wechathelper.wechat.user.response.*;

import java.util.List;

public class UserAPI extends ServiceAPI {

    /**
     * 设置用户备注名
     *
     * @param accessToken accessToken
     * @param openId      user在公众号的openId
     * @param remark      设置或更新的备注名
     * @return
     */
    public static APIResponse updateUserRemark(String accessToken, String openId, String remark) {
        RemarkRequest request = new RemarkRequest(openId, remark);
        String url = formatUrl(wechatProperties.getProperty("url.user.remark"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }

    /**
     * 获取关注本公众号的所有用户
     *
     * @param accessToken accessToken
     * @return
     */
    public static UsersResponse getUsers(String accessToken) {
        String url = formatUrl(wechatProperties.getProperty("url.user.users"), new String[]{accessToken, ""});
        UsersResponse collectedUsersResponse = new UsersResponse();
        while (true) {
            UsersResponse usersResponse = invokeAPI(url, ApiMethod.GET, UsersResponse.class, null);
            collectedUsersResponse.setTotal(usersResponse.getTotal());
            collectedUsersResponse.getData().getOpenid().addAll(usersResponse.getData().getOpenid());
            collectedUsersResponse.setAquired(usersResponse.getAquired());
            if (StringUtils.isBlank(usersResponse.getNext_openid())) {
                break;
            }
            url = formatUrl(wechatProperties.getProperty("url.user.users"), new String[]{accessToken, usersResponse.getNext_openid()});
        }
        return collectedUsersResponse;
    }


    /**
     * 获取用户基本信息接口:获取User实体
     *
     * @param accessToken accessToken
     * @param openId      user在公众号的openId
     * @return
     */
    public static User getUser(String accessToken, String openId) {
        User user = new User();
        String url = formatUrl(wechatProperties.getProperty("url.user.userinfo"), new String[]{accessToken, openId});
        UserResponse userResponse = invokeAPI(url, ApiMethod.GET, UserResponse.class, null);
        BeanUtils.copyProperties(userResponse, user);
        return user;
    }


    /**
     * 批量获取用户基本信息
     *
     * @param accessToken accessToken
     * @param openIds     需要获取信息的用户的openId列表
     * @param language    国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，设null则默认为zh-CN
     * @return
     */
    public static List<User> getBatchUsers(String accessToken, List<String> openIds, UserLanguage language) {
        BatchUsersRequest request = new BatchUsersRequest(openIds, language);
        String url = formatUrl(wechatProperties.getProperty("url.user.usersinfo"), new String[]{accessToken});
        BatchUsersResponse response = invokeAPI(url, ApiMethod.POST, BatchUsersResponse.class, request);
        return response.getUser_info_list();
    }

    /**
     * 创建标签
     *
     * @param accessToken accessToken
     * @param tagName     标签名
     * @return
     */
    public static TagCreateResponse createTag(String accessToken, String tagName) {
        TagRequest request = new TagRequest(tagName);
        String url = formatUrl(wechatProperties.getProperty("url.user.createtag"), new String[]{accessToken});
        TagCreateResponse response = invokeAPI(url, ApiMethod.POST, TagCreateResponse.class, request);
        return response;
    }

    /**
     * 获取公众号已创建的标签
     *
     * @param accessToken accessToken
     * @return
     */
    public static TagsGetResponse getTags(String accessToken) {
        String url = formatUrl(wechatProperties.getProperty("url.user.gettags"), new String[]{accessToken});
        TagsGetResponse response = invokeAPI(url, ApiMethod.GET, TagsGetResponse.class, null);
        return response;
    }

    /**
     * 编辑标签
     *
     * @param accessToken accessToken
     * @param tagId       标签编号
     * @param tagName     标签名
     * @return
     */
    public static APIResponse updateTag(String accessToken, Integer tagId, String tagName) {
        TagRequest request = new TagRequest(tagId, tagName);
        String url = formatUrl(wechatProperties.getProperty("url.user.updatetag"), new String[]{accessToken});
        TagsGetResponse response = invokeAPI(url, ApiMethod.POST, TagsGetResponse.class, request);
        return response;
    }

    /**
     * 删除标签
     *
     * @param accessToken accessToken
     * @param tagId       标签编号
     * @return
     */
    public static APIResponse deleteTag(String accessToken, Integer tagId) {
        TagRequest request = new TagRequest(tagId);
        String url = formatUrl(wechatProperties.getProperty("url.user.deletetag"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }

    /**
     * 获取标签下粉丝列表
     *
     * @param accessToken accessToken
     * @param tagId       标签编号
     * @return
     */
    public static TagUsersResponse getTagUsers(String accessToken, Integer tagId) {
        TagRequest request = new TagRequest(tagId);
        String url = formatUrl(wechatProperties.getProperty("url.user.gettaguser"), new String[]{accessToken});
        TagUsersResponse response = invokeAPI(url, ApiMethod.POST, TagUsersResponse.class, request);
        return response;
    }


    /**
     * 批量为用户打标签
     *
     * @param accessToken accessToken
     * @param tagId       标签编号
     * @param openIdList  需要批量打标签的一批openId
     * @return
     */
    public static APIResponse addTag(String accessToken, Integer tagId, List<String> openIdList) {
        UserTagRequest request = new UserTagRequest(tagId, openIdList);
        String url = formatUrl(wechatProperties.getProperty("url.user.addtag"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }

    /**
     * 批量为用户取消标签
     *
     * @param accessToken accessToken
     * @param tagId       标签编号
     * @param openIdList  需要批量打标签的一批openId
     * @return
     */
    public static APIResponse unTag(String accessToken, Integer tagId, List<String> openIdList) {
        UserTagRequest request = new UserTagRequest(tagId, openIdList);
        String url = formatUrl(wechatProperties.getProperty("url.user.untag"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }


    /**
     * 获取用户身上的标签列表
     *
     * @param accessToken accessToken
     * @param openId      openId
     * @return
     */
    public static UserTaglistResponse getUserTaglist(String accessToken, String openId) {
        UserTaglistRequest request = new UserTaglistRequest(openId);
        String url = formatUrl(wechatProperties.getProperty("url.user.gettaglist"), new String[]{accessToken});
        UserTaglistResponse response = invokeAPI(url, ApiMethod.POST, UserTaglistResponse.class, request);
        return response;
    }

}



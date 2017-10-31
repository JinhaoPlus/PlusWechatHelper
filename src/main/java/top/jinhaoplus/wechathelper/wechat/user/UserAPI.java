package top.jinhaoplus.wechathelper.wechat.user;

import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;
import top.jinhaoplus.wechathelper.wechat.user.response.UserResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.UsersResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class UserAPI extends ServiceAPI {

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
}



package top.jinhaoplus.wechathelper.wechat.auth;

import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.auth.response.AuthTokenResponse;
import top.jinhaoplus.wechathelper.wechat.auth.response.UserInfoResponse;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;
import org.springframework.beans.BeanUtils;

public class AuthAPI extends ServiceAPI {

    /**
     * 获取包含openId在内的authtoken
     *
     * @param code 换取包含openId在内的authtoken的code
     * @return
     */
    public static AuthTokenResponse getAuthToken(String code) {
        String url = formatUrl(wechatProperties.getProperty("url.auth.authtoken"), new String[]{appId, appSecret, code});
        AuthTokenResponse authTokenResponse = invokeAPI(url, ApiMethod.GET, AuthTokenResponse.class, null);
        return authTokenResponse;
    }

    /**
     * 授权后获取用户信息
     * 用户管理类接口UserAPI中的获取用户基本信息接口，是在用户和公众号产生消息交互或关注后事件推送后，才能根据用户OpenID来获取用户基本信息。
     * 这个接口，包括其他微信接口，都是需要该用户（即openid）关注了公众号后，才能调用成功的。
     *
     * @param authToken 用户授权的accessToken，即WeChatServiceAPI#getAuthToken获取到的AuthTokenResponse中的authToken
     * @param openid    用户openid，即WeChatServiceAPI#getAuthToken获取到的AuthTokenResponse中的openid
     * @return
     */
    public static User getUserInfo(String authToken, String openid) {
        User user = new User();
        String url = formatUrl(wechatProperties.getProperty("url.auth.userinfo"), new String[]{authToken, openid});
        UserInfoResponse userInfoResponse = invokeAPI(url, ApiMethod.GET, UserInfoResponse.class, null);
        BeanUtils.copyProperties(userInfoResponse, user);
        return user;
    }
}



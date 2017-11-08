package top.jinhaoplus.wechathelper.wechat.basic;

import org.apache.commons.lang3.StringUtils;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.basic.response.AccessTokenResponse;
import top.jinhaoplus.wechathelper.wechat.basic.response.IPListResponse;
import top.jinhaoplus.wechathelper.wechat.exception.WechatAPIException;
import top.jinhaoplus.wechathelper.wechat.utils.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BasicAPI extends ServiceAPI {

    public static final String MESSAGE_VERIFY_ERROR = "notWechatMessage";

    /**
     * 校验请求消息是否来自微信服务器
     *
     * @return
     */
    public static Boolean verifyMessage(HttpServletRequest request) {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String token = wechatProperties.getProperty("service.apptoken");

        if (!StringUtils.isBlank(token) && !StringUtils.isBlank(timestamp) && !StringUtils.isBlank(nonce)) {
            String[] list = {token, timestamp, nonce};
            Arrays.sort(list);

            String bigStr = list[0] + list[1] + list[2];
            String shaStr = SecurityUtil.SHA1(bigStr);

            if (shaStr.equals(signature))
                return true;
            else
                return false;
        }
        return true;
    }

    /**
     * 重新获取最新的获取accessToken实体
     *
     * @return accessToken实体
     */
    private static AccessTokenResponse getRefreshAccessToken() {
        String url = formatUrl(wechatProperties.getProperty("url.basic.accesstoken"), new String[]{appId, appSecret});
        AccessTokenResponse accessTokenResponse = invokeAPI(url, ApiMethod.GET, AccessTokenResponse.class, null);
        return accessTokenResponse;
    }

    /**
     * 获取accessToken实体, 可能是之前获取的未过期的accessToken
     *
     * @return accessToken实体
     */
    public static AccessTokenResponse getAccessToken() {
        AccessTokenResponse accessTokenResponse = null;
        // 若之前未生成过accessToken则重新生成
        if (StringUtils.isBlank(runtimeProperties.getProperty("runtime.accesstoken_generate")) || StringUtils.isBlank(runtimeProperties.getProperty("runtime.accesstoken_expiresin"))) {
            accessTokenResponse = getRefreshAccessToken();
        } else {
            String accessToken = runtimeProperties.getProperty("runtime.accesstoken");
            Date generate = new Date(Long.valueOf(runtimeProperties.getProperty("runtime.accesstoken_generate")));
            Integer expiresIn = Integer.valueOf(runtimeProperties.getProperty("runtime.accesstoken_expiresin"));
            // 判断之前的accessToken是否过期, 若已过期则重新获取
            if (isExpired(generate, expiresIn)) {
                accessTokenResponse = getRefreshAccessToken();
            }
            // 未过期则使用之前的accessToken
            else
                return new AccessTokenResponse(accessToken, expiresIn);
        }

        runtimeProperties.setProperty("runtime.accesstoken", accessTokenResponse.getAccess_token());
        runtimeProperties.setProperty("runtime.accesstoken_generate", String.valueOf(System.currentTimeMillis()));
        runtimeProperties.setProperty("runtime.accesstoken_expiresin", String.valueOf(accessTokenResponse.getExpires_in()));
        return accessTokenResponse;

    }

    /**
     * 判断现在的accessToken是否已经过期
     *
     * @param then      上次生成accessToken的时间
     * @param expiresIn 过期时间(seconds)
     * @return
     */
    private static boolean isExpired(Date then, Integer expiresIn){
        Date now = new Date();
        Date expirePoint = new Date(then.getTime() + expiresIn * 1000);
        return now.after(expirePoint);
    }

    /**
     * 获取accessToken字符串, 可能是之前获取的未过期的accessToken
     *
     * @return accessToken字符串
     */
    public static String getAccessTokenStr() {
        return getAccessToken().getAccess_token();
    }

    /**
     * 获取微信服务器IP列表
     *
     * @return accessToken字符串
     */
    public static List<String> getWechatIPList() {
        String accessToken = getAccessTokenStr();
        String url = formatUrl(wechatProperties.getProperty("url.basic.iplist"), new String[]{accessToken});
        IPListResponse ipListResponse = invokeAPI(url, ApiMethod.GET, IPListResponse.class, null);
        if (ipListResponse != null)
            return ipListResponse.getIp_list();
        throw new WechatAPIException("微信服务器IP列表获取失败");
    }
}



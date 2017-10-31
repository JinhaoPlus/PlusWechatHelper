package top.jinhaoplus.wechathelper.wechat.basic;

import top.jinhaoplus.wechathelper.wechat.utils.SecurityUtil;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.basic.response.AccessTokenResponse;
import top.jinhaoplus.wechathelper.wechat.basic.response.IPListResponse;
import top.jinhaoplus.wechathelper.wechat.exception.WechatAPIException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
     * 获取accessToken实体
     *
     * @return accessToken实体
     */
    public static AccessTokenResponse getAccessToken() {
        String url = formatUrl(wechatProperties.getProperty("url.basic.accesstoken"), new String[]{appId, appSecret});
        AccessTokenResponse accessTokenResponse = invokeAPI(url, ApiMethod.GET, AccessTokenResponse.class, null);
        return accessTokenResponse;
    }

    /**
     * 获取accessToken字符串
     *
     * @return accessToken字符串
     */
    public static String getAccessTokenStr() {
        String url = formatUrl(wechatProperties.getProperty("url.basic.accesstoken"), new String[]{appId, appSecret});
        AccessTokenResponse accessTokenResponse = invokeAPI(url, ApiMethod.GET, AccessTokenResponse.class, null);
        if (accessTokenResponse != null)
            return accessTokenResponse.getAccess_token();
        throw new WechatAPIException("AccessToken获取失败");
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



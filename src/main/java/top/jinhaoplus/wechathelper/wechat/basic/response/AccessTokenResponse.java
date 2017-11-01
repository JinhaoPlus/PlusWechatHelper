package top.jinhaoplus.wechathelper.wechat.basic.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

/**
 * accessToken的获取结果
 */
public class AccessTokenResponse extends APIResponse {
    /**
     * accessToken
     */
    private String access_token;

    /**
     * 超时时间
     */
    private Integer expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
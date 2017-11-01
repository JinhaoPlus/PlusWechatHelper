package top.jinhaoplus.wechathelper.wechat.auth.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class AuthTokenResponse extends APIResponse {
    /**
     * authtoken
     */
    private String access_token;
    /**
     * 过期时间
     */
    private Integer expires_in;
    /**
     * 刷新token
     */
    private String refresh_token;
    /**
     * openId
     */
    private String openid;
    /**
     * 认证域
     */
    private String scope;

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

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}

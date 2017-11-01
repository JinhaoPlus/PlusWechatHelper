package top.jinhaoplus.wechathelper.wechat.basic.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

/**
 * 微信服务器IP地址的获取结果
 */
public class IPListResponse extends APIResponse {
    /**
     * accessToken
     */
    private List<String> ip_list;

    public List<String> getIp_list() {
        return ip_list;
    }

    public void setIp_list(List<String> ip_list) {
        this.ip_list = ip_list;
    }
}
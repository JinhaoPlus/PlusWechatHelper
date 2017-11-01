package top.jinhaoplus.wechathelper.wechat.general.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

/**
 * 二维码换取票据响应
 */
public class QRCodeTicketResponse extends APIResponse {
    /**
     * 二维码换取票据
     */
    private String ticket;
    /**
     * 超时时间
     */
    private Integer expire_seconds;
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

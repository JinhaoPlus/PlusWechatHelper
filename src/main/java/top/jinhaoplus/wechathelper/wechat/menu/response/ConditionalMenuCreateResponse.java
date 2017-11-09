package top.jinhaoplus.wechathelper.wechat.menu.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class ConditionalMenuCreateResponse extends APIResponse {
    private String menuid;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}

package top.jinhaoplus.wechathelper.wechat.user.request.blacklist;

import java.util.List;

public class BlackRequest {
    private List<String> openid_list;

    public BlackRequest(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }
}

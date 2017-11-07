package top.jinhaoplus.wechathelper.wechat.user.response.user;

import java.util.ArrayList;
import java.util.List;

public class OpenIds{
    private List<String> openid = new ArrayList<>();

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}

package top.jinhaoplus.wechathelper.wechat.menu.request;

public class ConditionalMenuDeleteRequest {
    private String menuid;

    public ConditionalMenuDeleteRequest(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}


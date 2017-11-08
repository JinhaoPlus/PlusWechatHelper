package top.jinhaoplus.wechathelper.wechat.menu.request;

import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;

import java.util.List;

public class MenuCreateRequest {

    private List<MenuButton> button;

    public MenuCreateRequest(List<MenuButton> button) {
        this.button = button;
    }

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }
}



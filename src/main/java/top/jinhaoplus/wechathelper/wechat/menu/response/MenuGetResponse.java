package top.jinhaoplus.wechathelper.wechat.menu.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;

import java.util.List;


public class MenuGetResponse extends APIResponse{

    private MenuInfo menu;

    public MenuInfo getMenu() {
        return menu;
    }

    public void setMenu(MenuInfo menu) {
        this.menu = menu;
    }


}

class MenuInfo {

    private List<MenuButton> button;

    public MenuInfo() {
    }

    public MenuInfo(List<MenuButton> button) {
        this.button = button;
    }

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }
}
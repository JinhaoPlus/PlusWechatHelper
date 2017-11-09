package top.jinhaoplus.wechathelper.wechat.menu.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MatchRule;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;

import java.util.List;


public class MenuGetResponse extends APIResponse {

    private MenuInfo menu;

    private List<ConditionalMenu> conditionalmenu;

    public MenuInfo getMenu() {
        return menu;
    }

    public void setMenu(MenuInfo menu) {
        this.menu = menu;
    }

    public List<ConditionalMenu> getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(List<ConditionalMenu> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }
}

class MenuInfo {

    private List<MenuButton> button;

    private Long menuid;

    public MenuInfo() {
    }

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}

class ConditionalMenu {

    private List<MenuButton> button;

    private MatchRule matchrule;

    private Long menuid;

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }

    public MatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(MatchRule matchrule) {
        this.matchrule = matchrule;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}


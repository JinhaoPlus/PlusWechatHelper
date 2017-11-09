package top.jinhaoplus.wechathelper.wechat.menu.request;

import top.jinhaoplus.wechathelper.wechat.menu.entity.MatchRule;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;

import java.util.List;

public class ConditionalMenuCreateRequest {
    private List<MenuButton> button;

    private MatchRule matchrule;

    public ConditionalMenuCreateRequest() {
    }

    public ConditionalMenuCreateRequest(List<MenuButton> button, MatchRule matchrule) {
        this.button = button;
        this.matchrule = matchrule;
    }

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
}


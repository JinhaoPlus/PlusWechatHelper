package top.jinhaoplus.wechathelper.wechat.menu.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuButton {

    public enum MenuButtonType {
        click("click"),
        view("view"),
        scancode_push("scancode_push"),
        scancode_waitmsg("scancode_waitmsg"),
        pic_sysphoto("pic_sysphoto"),
        pic_photo_or_album("pic_photo_or_album"),
        pic_weixin("pic_weixin"),
        location_select("location_select"),
        media_id("media_id"),
        view_limited("view_limited"),
        miniprogram("miniprogram");

        private String typeValue;

        MenuButtonType(String typeValue) {
            this.typeValue = typeValue;
        }

        public String toString() {
            return String.valueOf(this.typeValue);
        }
    }

    private String name;
    private MenuButtonType type;
    private String key;
    private String url;
    private String media_id;

    // 当MenuButtonType为小程序时需要的字段
    private String appid;
    private String pagepath;

    private List<MenuButton> sub_button = new ArrayList<MenuButton>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuButtonType getType() {
        return type;
    }

    public void setType(MenuButtonType type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public List<MenuButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<MenuButton> sub_button) {
        this.sub_button = sub_button;
    }

    public MenuButton() {
    }

    public MenuButton(String name) {
        this.name = name;
    }

    public MenuButton(String name, MenuButtonType type) {
        this.name = name;
        this.type = type;
    }

    public MenuButton(String name, MenuButtonType type, String key) {
        this.name = name;
        this.type = type;
        this.key = key;
    }


    public MenuButton(String name, String media_id) {
        this.name = name;
        this.type = MenuButtonType.media_id;
        this.media_id = media_id;
    }


    public MenuButton(String name, MenuButtonType type, String key, String url) {
        this.name = name;
        this.type = type;
        this.key = key;
        this.url = url;
    }
}

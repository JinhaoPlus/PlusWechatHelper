package top.jinhaoplus.wechathelper.wechat.menu;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MatchRule;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;
import top.jinhaoplus.wechathelper.wechat.menu.request.ConditionalMenuCreateRequest;
import top.jinhaoplus.wechathelper.wechat.menu.request.MenuCreateRequest;
import top.jinhaoplus.wechathelper.wechat.menu.response.MenuGetResponse;

import java.util.ArrayList;
import java.util.List;

public class MenuAPITest {

    @Test
    public void getCustomizedMenu() throws Exception {
        MenuGetResponse response = MenuAPI.getCustomizedMenu(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void createCustomizedMenu() throws Exception {
        List<MenuButton> menuButtons = new ArrayList<MenuButton>() {{

            MenuButton button1 = new MenuButton("扫一扫");
            button1.setSub_button(new ArrayList<MenuButton>() {{
                add(new MenuButton("扫码带提示", MenuButton.MenuButtonType.scancode_waitmsg, "rselfmenu_0_0"));
                add(new MenuButton("扫码带提示", MenuButton.MenuButtonType.scancode_push, "rselfmenu_0_1"));
            }});
            add(button1);

            MenuButton button2 = new MenuButton("发送位置", MenuButton.MenuButtonType.location_select, "rselfmenu_2_0");
            add(button2);

//            MenuButton button2 = new MenuButton("图片", "TfyMrCu3iSoUpqscSAt-3c7wcVvSN3u73cXbKP83bc8");
//            add(button2);

//            MenuButton button2 = new MenuButton("图文", "TfyMrCu3iSoUpqscSAt-3R6voD65VvmaOC3waBLFbn8");
//            add(button2);

            MenuButton button3 = new MenuButton("发图");
            button3.setSub_button(new ArrayList<MenuButton>() {{
                add(new MenuButton("拍照OR相册发图", MenuButton.MenuButtonType.pic_photo_or_album, "rselfmenu_1_0"));
                add(new MenuButton("系统拍照发图", MenuButton.MenuButtonType.pic_sysphoto, "rselfmenu_1_1"));
                add(new MenuButton("微信相册发图", MenuButton.MenuButtonType.pic_weixin, "rselfmenu_1_2"));
            }});
            add(button3);
        }};
        MenuCreateRequest request = new MenuCreateRequest(menuButtons);
        MenuAPI.createCustomizedMenu(BasicAPI.getAccessTokenStr(), request);
    }

    @Test
    public void deleteCustomizedMenu() throws Exception {
        MenuAPI.deleteCustomizedMenu(BasicAPI.getAccessTokenStr());
    }

    @Test
    public void addConditionalMenu() throws Exception {
        List<MenuButton> menuButtons = new ArrayList<MenuButton>() {{

            MenuButton button1 = new MenuButton("扫一扫");
            button1.setSub_button(new ArrayList<MenuButton>() {{
                add(new MenuButton("扫码带提示", MenuButton.MenuButtonType.scancode_waitmsg, "rselfmenu_0_0"));
                add(new MenuButton("扫码带提示", MenuButton.MenuButtonType.scancode_push, "rselfmenu_0_1"));
            }});
            add(button1);

            MenuButton button2 = new MenuButton("图文", "TfyMrCu3iSoUpqscSAt-3R6voD65VvmaOC3waBLFbn8");
            add(button2);

            MenuButton button3 = new MenuButton("发图");
            button3.setSub_button(new ArrayList<MenuButton>() {{
                add(new MenuButton("拍照OR相册发图", MenuButton.MenuButtonType.pic_photo_or_album, "rselfmenu_1_0"));
                add(new MenuButton("系统拍照发图", MenuButton.MenuButtonType.pic_sysphoto, "rselfmenu_1_1"));
                add(new MenuButton("微信相册发图", MenuButton.MenuButtonType.pic_weixin, "rselfmenu_1_2"));
            }});
            add(button3);
        }};

        MatchRule rule = new MatchRule();
        rule.setClient_platform_type("1");
        rule.setSex("1");
        rule.setCountry("中国");
        rule.setProvince("北京");
        rule.setCity("海淀");
        ConditionalMenuCreateRequest request = new ConditionalMenuCreateRequest(menuButtons, rule);
        MenuAPI.addConditionalMenu(BasicAPI.getAccessTokenStr(), request);
    }

    @Test
    public void delConditionalMenu() throws Exception {
        MenuAPI.delConditionalMenu(BasicAPI.getAccessTokenStr(), "436573037");
    }

    @Test
    public void tryWatchMenu() throws Exception {
        MenuAPI.tryWatchMenu(BasicAPI.getAccessTokenStr(), "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
    }
}
package top.jinhaoplus.wechathelper.wechat.menu;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.menu.entity.MenuButton;
import top.jinhaoplus.wechathelper.wechat.menu.request.MenuCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class MenuAPITest {

    @Test
    public void getCustomizedMenu() throws Exception {
        MenuAPI.getCustomizedMenu(BasicAPI.getAccessTokenStr());
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

//            MenuButton button2 = new MenuButton("发送位置", MenuButton.MenuButtonType.location_select, "rselfmenu_2_0");
//            add(button2);

            MenuButton button2 = new MenuButton("图片", "TfyMrCu3iSoUpqscSAt-3c7wcVvSN3u73cXbKP83bc8");
            add(button2);

            MenuButton button3 = new MenuButton("发图");
            button3.setSub_button(new ArrayList<MenuButton>() {{
                add(new MenuButton("系统拍照发图", MenuButton.MenuButtonType.pic_photo_or_album, "rselfmenu_1_0"));
                add(new MenuButton("拍照或者相册发图", MenuButton.MenuButtonType.scancode_push, "rselfmenu_1_1"));
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

}
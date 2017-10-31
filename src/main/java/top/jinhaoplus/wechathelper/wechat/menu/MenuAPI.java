package top.jinhaoplus.wechathelper.wechat.menu;

import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.menu.entity.DockMenuButtons;
import top.jinhaoplus.wechathelper.wechat.menu.response.CustomizedMenuResponse;

import java.io.IOException;

public class MenuAPI extends ServiceAPI{
    /**
     * 创建自定义菜单
     *
     * @param accessToken     accessToken
     * @param dockMenuButtons 组织好的完整菜单按钮
     * @return
     * @throws IOException
     */
    public static CustomizedMenuResponse createCustomizedMenu(String accessToken, DockMenuButtons dockMenuButtons) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.createmenu"), new String[]{accessToken});
        CustomizedMenuResponse customizedMenuResponse = invokeAPI(url, ApiMethod.POST, CustomizedMenuResponse.class, JsonUtil.bean2str(dockMenuButtons));
        return customizedMenuResponse;
    }
}

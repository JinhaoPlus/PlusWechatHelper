package top.jinhaoplus.wechathelper.wechat.menu;

import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.menu.request.MenuCreateRequest;
import top.jinhaoplus.wechathelper.wechat.menu.response.MenuGetResponse;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

import java.io.IOException;

public class MenuAPI extends ServiceAPI {

    /**
     * 创建自定义菜单
     *
     * @param accessToken       accessToken
     * @param menuCreateRequest 组织好的完整菜单按钮的请求
     * @return
     * @throws IOException
     */
    public static APIResponse createCustomizedMenu(String accessToken, MenuCreateRequest menuCreateRequest) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.createmenu"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(menuCreateRequest));
        return response;
    }


    /**
     * 自定义菜单查询接口
     *
     * @param accessToken accessToken
     * @return
     * @throws IOException
     */
    public static MenuGetResponse getCustomizedMenu(String accessToken) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.getmenu"), new String[]{accessToken});
        MenuGetResponse response = invokeAPI(url, ApiMethod.GET, MenuGetResponse.class, null);
        return response;
    }

    /**
     * 自定义菜单删除接口
     *
     * @param accessToken accessToken
     * @return
     * @throws IOException
     */
    public static APIResponse deleteCustomizedMenu(String accessToken) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.deletemenu"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.GET, APIResponse.class, null);
        return response;
    }
}

package top.jinhaoplus.wechathelper.wechat.menu;

import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.menu.request.ConditionalMenuCreateRequest;
import top.jinhaoplus.wechathelper.wechat.menu.request.ConditionalMenuDeleteRequest;
import top.jinhaoplus.wechathelper.wechat.menu.request.MenuCreateRequest;
import top.jinhaoplus.wechathelper.wechat.menu.request.MenuTryWatchRequest;
import top.jinhaoplus.wechathelper.wechat.menu.response.ConditionalMenuCreateResponse;
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

    /**
     * 创建个性化菜单
     *
     * @param accessToken accessToken
     * @param request     组织好的个性化菜单按钮的请求
     * @return 创建好的个性化菜单的menuid
     * @throws IOException
     */
    public static String addConditionalMenu(String accessToken, ConditionalMenuCreateRequest request) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.addconditionalmenu"), new String[]{accessToken});
        ConditionalMenuCreateResponse response = invokeAPI(url, ApiMethod.POST, ConditionalMenuCreateResponse.class, JsonUtil.bean2str(request));
        return response.getMenuid();
    }


    /**
     * 删除个性化菜单
     *
     * @param accessToken accessToken
     * @param menuId      要删除的个性化菜单menuId
     * @throws IOException
     */
    public static APIResponse delConditionalMenu(String accessToken, String menuId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.delconditionalmenu"), new String[]{accessToken});
        ConditionalMenuDeleteRequest request = new ConditionalMenuDeleteRequest(menuId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 测试个性化菜单匹配结果
     *
     * @param accessToken accessToken
     * @param openId      要预览菜单的用户的openId
     * @return
     * @throws IOException
     */
    public static MenuGetResponse tryWatchMenu(String accessToken, String openId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.menu.trymatchmenu"), new String[]{accessToken});
        MenuTryWatchRequest request = new MenuTryWatchRequest(openId);
        MenuGetResponse response = invokeAPI(url, ApiMethod.POST, MenuGetResponse.class, request);
        return response;
    }

}

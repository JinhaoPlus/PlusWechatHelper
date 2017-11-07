package top.jinhaoplus.wechathelper.wechat.user.response.user;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;

import java.util.List;

/**
 * User的获取结果
 */
public class BatchUsersResponse extends APIResponse {
    private List<User> user_info_list;

    public List<User> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<User> user_info_list) {
        this.user_info_list = user_info_list;
    }
}
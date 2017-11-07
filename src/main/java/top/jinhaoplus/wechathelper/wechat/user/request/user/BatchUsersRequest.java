package top.jinhaoplus.wechathelper.wechat.user.request.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchUsersRequest {
    private List<Map<String, String>> user_list = new ArrayList<>();

    public BatchUsersRequest(List<String> openIds, UserLanguage language) {
        openIds.forEach(openId -> {
            Map<String, String> userRequest = new HashMap<>();
            userRequest.put("openid", openId);
            if (language == null)
                userRequest.put("lang", "zh-CN");
            else
                userRequest.put("lang", language.getLang());
            this.user_list.add(userRequest);
        });
    }

    public List<Map<String, String>> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<Map<String, String>> user_list) {
        this.user_list = user_list;
    }
}

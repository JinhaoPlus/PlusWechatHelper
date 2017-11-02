package top.jinhaoplus.wechathelper.wechat.user;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;
import top.jinhaoplus.wechathelper.wechat.user.response.TagCreateResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.TagUsersResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.TagsGetResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.UserTaglistResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAPITest {

    @Test
    public void getUsers() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
        User user = UserAPI.getUser(BasicAPI.getAccessTokenStr(), "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        System.out.println(user);
    }

    @Test
    public void createTag() throws Exception {
        TagCreateResponse response = UserAPI.createTag(BasicAPI.getAccessTokenStr(), "dev");
        System.out.println(response);
    }

    @Test
    public void getTags() throws Exception {
        TagsGetResponse response = UserAPI.getTags(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void updateTag() throws Exception {
        APIResponse response = UserAPI.updateTag(BasicAPI.getAccessTokenStr(), 101, "开发组");
        System.out.println(response);
    }

    @Test
    public void deleteTag() throws Exception {
        APIResponse response = UserAPI.deleteTag(BasicAPI.getAccessTokenStr(), 101);
        System.out.println(response);
    }

    @Test
    public void getTagUsers() throws Exception {
        TagUsersResponse response = UserAPI.getTagUsers(BasicAPI.getAccessTokenStr(), 102);
        System.out.println(response);
    }

    @Test
    public void addTag() throws Exception {
        List<String> openIdList = new ArrayList<>();
        openIdList.add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        openIdList.add("oAW2Lwo6W8UPA8XpvkqoG4ED2PJU");
        APIResponse response = UserAPI.addTag(BasicAPI.getAccessTokenStr(), 102, openIdList);
        System.out.println(response);
    }

    @Test
    public void unTag() throws Exception {
        List<String> openIdList = new ArrayList<>();
        openIdList.add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        openIdList.add("oAW2Lwo6W8UPA8XpvkqoG4ED2PJU");
        APIResponse response = UserAPI.unTag(BasicAPI.getAccessTokenStr(), 102, openIdList);
        System.out.println(response);
    }

    @Test
    public void getUserTaglist() throws Exception {
        UserTaglistResponse response = UserAPI.getUserTaglist(BasicAPI.getAccessTokenStr(), "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        System.out.println(response);
    }
}
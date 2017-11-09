package top.jinhaoplus.wechathelper.wechat.user;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.user.entity.User;
import top.jinhaoplus.wechathelper.wechat.user.response.tag.TagCreateResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.tag.TagUsersResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.tag.TagsGetResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.tag.UserTaglistResponse;
import top.jinhaoplus.wechathelper.wechat.user.response.user.UsersResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAPITest {

    @Test
    public void updateUserRemark() throws Exception {
        UserAPI.updateUserRemark(BasicAPI.getAccessTokenStr(),"oAW2LwoBlpy5B21ENtqn_q5zvIQA","DEV");
    }

    @Test
    public void getUsers() throws Exception {
        UsersResponse response = UserAPI.getUsers(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void getUser() throws Exception {
        User user = UserAPI.getUser(BasicAPI.getAccessTokenStr(), "oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        System.out.println(user);
    }

    @Test
    public void getBatchUsers() throws Exception {
        UserAPI.getBatchUsers(BasicAPI.getAccessTokenStr(), new ArrayList<String>() {{
            add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
            add("oAW2Lwo6W8UPA8XpvkqoG4ED2PJU");
            add("oAW2LwuROOjVpKJLGZlVEaq0h60c");
            add("oAW2LwlBdSvgD1TwF747c_PJRCDw");
        }}, null);
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

    @Test
    public void getBlackListUsers() throws Exception {
        UsersResponse response = UserAPI.getBlackListUsers(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void addToBlackList() throws Exception {
        UserAPI.addToBlackList(BasicAPI.getAccessTokenStr(),new ArrayList<String>(){{
            add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        }});
    }

    @Test
    public void unBlackList() throws Exception {
        UserAPI.unBlackList(BasicAPI.getAccessTokenStr(),new ArrayList<String>(){{
            add("oAW2LwoBlpy5B21ENtqn_q5zvIQA");
        }});
    }
}
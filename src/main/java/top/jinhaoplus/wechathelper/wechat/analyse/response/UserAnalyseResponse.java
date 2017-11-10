package top.jinhaoplus.wechathelper.wechat.analyse.response;

import top.jinhaoplus.wechathelper.wechat.analyse.entity.InterfaceAnalyseResult;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class UserAnalyseResponse extends APIResponse{
    private List<InterfaceAnalyseResult> list;

    public List<InterfaceAnalyseResult> getList() {
        return list;
    }

    public void setList(List<InterfaceAnalyseResult> list) {
        this.list = list;
    }
}

package top.jinhaoplus.wechathelper.wechat.analyse.response;

import top.jinhaoplus.wechathelper.wechat.analyse.entity.UserAnalyseDailyResult;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class UpsteamMsgAnalyseResponse extends APIResponse{
    private List<UserAnalyseDailyResult> list;

    public List<UserAnalyseDailyResult> getList() {
        return list;
    }

    public void setList(List<UserAnalyseDailyResult> list) {
        this.list = list;
    }
}

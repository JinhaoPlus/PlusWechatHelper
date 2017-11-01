package top.jinhaoplus.wechathelper.wechat.message.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.message.models.template.Template;

import java.util.List;

public class TemplateListResponse extends APIResponse {
    List<Template> template_list;

    public List<Template> getTemplate_list() {
        return template_list;
    }

    public void setTemplate_list(List<Template> template_list) {
        this.template_list = template_list;
    }
}

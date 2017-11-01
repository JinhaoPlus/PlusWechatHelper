package top.jinhaoplus.wechathelper.wechat.message.models.template;

public class TemplateDeleteRequest {
    private String template_id;

    public TemplateDeleteRequest(String template_id) {
        this.template_id = template_id;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
}

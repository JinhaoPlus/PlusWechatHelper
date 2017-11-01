package top.jinhaoplus.wechathelper.wechat.message.models.template;

public class TemplateDataItem {

    //模板内容
    private String value;

    //模板内容字体颜色，不填默认为黑色
    private String color;

    public TemplateDataItem(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.models.masssend;

public class Filter {
    private boolean is_to_all;
    private Integer tag_id;

    public boolean getIs_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }
}

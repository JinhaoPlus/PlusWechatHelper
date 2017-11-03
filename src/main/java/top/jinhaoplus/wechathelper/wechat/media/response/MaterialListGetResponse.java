package top.jinhaoplus.wechathelper.wechat.media.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

import java.util.List;

public class MaterialListGetResponse extends APIResponse{

    private Integer total_count;
    private Integer item_count;
    private List<MateriallistItem> item;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }

    public List<MateriallistItem> getItem() {
        return item;
    }

    public void setItem(List<MateriallistItem> item) {
        this.item = item;
    }
}


class MateriallistItem{
    private String media_id;
    private String name;
    private String url;
    private Long update_time;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}
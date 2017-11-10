package top.jinhaoplus.wechathelper.wechat.analyse.entity;

public class InterfaceAnalyseResult {

    // 数据的日期
    private String ref_date;

    // 数据的小时,包括从000到2300,分别代表的是[000,100)到[2300,2400),即每日的第1小时和最后1小时
    private Integer ref_hour;

    // 通过服务器配置地址获得消息后,被动回复用户消息的次数
    private Long callback_count;

    // 上述动作的失败次数
    private Long fail_count;

    // 总耗时,除以callback_count即为平均耗时
    private Long total_time_cost;

    // 最大耗时
    private Long max_time_cost;

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public Integer getRef_hour() {
        return ref_hour;
    }

    public void setRef_hour(Integer ref_hour) {
        this.ref_hour = ref_hour;
    }

    public Long getCallback_count() {
        return callback_count;
    }

    public void setCallback_count(Long callback_count) {
        this.callback_count = callback_count;
    }

    public Long getFail_count() {
        return fail_count;
    }

    public void setFail_count(Long fail_count) {
        this.fail_count = fail_count;
    }

    public Long getTotal_time_cost() {
        return total_time_cost;
    }

    public void setTotal_time_cost(Long total_time_cost) {
        this.total_time_cost = total_time_cost;
    }

    public Long getMax_time_cost() {
        return max_time_cost;
    }

    public void setMax_time_cost(Long max_time_cost) {
        this.max_time_cost = max_time_cost;
    }
}

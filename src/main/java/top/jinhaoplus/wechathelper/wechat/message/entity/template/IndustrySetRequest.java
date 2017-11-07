package top.jinhaoplus.wechathelper.wechat.message.entity.template;

public class IndustrySetRequest {
    private String industry_id1;
    private String industry_id2;

    public String getIndustry_id1() {
        return industry_id1;
    }

    public void setIndustry_id1(String industry_id1) {
        this.industry_id1 = industry_id1;
    }

    public String getIndustry_id2() {
        return industry_id2;
    }

    public void setIndustry_id2(String industry_id2) {
        this.industry_id2 = industry_id2;
    }

    public IndustrySetRequest(String industry_id1, String industry_id2) {
        this.industry_id1 = industry_id1;
        this.industry_id2 = industry_id2;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.response;


import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class IndustryGetResponse extends APIResponse {
    private ClassifiedIndustry primary_industry;
    private ClassifiedIndustry secondary_industry;

    public ClassifiedIndustry getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(ClassifiedIndustry primary_industry) {
        this.primary_industry = primary_industry;
    }

    public ClassifiedIndustry getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(ClassifiedIndustry secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}

class ClassifiedIndustry{

    private String first_class;
    private String second_class;

    public String getFirst_class() {
        return first_class;
    }

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getSecond_class() {
        return second_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }
}

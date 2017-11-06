package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.event.massSendJobFinishEvent;

import javax.xml.bind.annotation.XmlElement;

public class CopyrightCheckResultItem{

    @XmlElement(name = "ArticleIdx")
    private Integer articleIdx;
    @XmlElement(name = "UserDeclareState")
    private Integer userDeclareState;
    @XmlElement(name = "AuditState")
    private Integer auditState;
    @XmlElement(name = "OriginalArticleUrl")
    private String originalArticleUrl;
    @XmlElement(name = "OriginalArticleType")
    private Integer originalArticleType;
    @XmlElement(name = "CanReprint")
    private Integer canReprint;
    @XmlElement(name = "NeedReplaceContent")
    private Integer needReplaceContent;
    @XmlElement(name = "NeedShowReprintSource")
    private Integer needShowReprintSource;

    public Integer getArticleIdx() {
        return articleIdx;
    }

    public void setArticleIdx(Integer articleIdx) {
        this.articleIdx = articleIdx;
    }

    public Integer getUserDeclareState() {
        return userDeclareState;
    }

    public void setUserDeclareState(Integer userDeclareState) {
        this.userDeclareState = userDeclareState;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getOriginalArticleUrl() {
        return originalArticleUrl;
    }

    public void setOriginalArticleUrl(String originalArticleUrl) {
        this.originalArticleUrl = originalArticleUrl;
    }

    public Integer getOriginalArticleType() {
        return originalArticleType;
    }

    public void setOriginalArticleType(Integer originalArticleType) {
        this.originalArticleType = originalArticleType;
    }

    public Integer getCanReprint() {
        return canReprint;
    }

    public void setCanReprint(Integer canReprint) {
        this.canReprint = canReprint;
    }

    public Integer getNeedReplaceContent() {
        return needReplaceContent;
    }

    public void setNeedReplaceContent(Integer needReplaceContent) {
        this.needReplaceContent = needReplaceContent;
    }

    public Integer getNeedShowReprintSource() {
        return needShowReprintSource;
    }

    public void setNeedShowReprintSource(Integer needShowReprintSource) {
        this.needShowReprintSource = needShowReprintSource;
    }
}

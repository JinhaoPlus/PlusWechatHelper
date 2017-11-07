package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.massSendJobFinishEvent;

import javax.xml.bind.annotation.XmlElement;

public class CopyrightCheckResultItem {

    private Integer articleIdx;

    private Integer userDeclareState;

    private Integer auditState;

    private String originalArticleUrl;

    private Integer originalArticleType;

    private Integer canReprint;

    private Integer needReplaceContent;

    private Integer needShowReprintSource;

    @XmlElement(name = "ArticleIdx")
    public Integer getArticleIdx() {
        return articleIdx;
    }

    public void setArticleIdx(Integer articleIdx) {
        this.articleIdx = articleIdx;
    }

    @XmlElement(name = "UserDeclareState")
    public Integer getUserDeclareState() {
        return userDeclareState;
    }

    public void setUserDeclareState(Integer userDeclareState) {
        this.userDeclareState = userDeclareState;
    }

    @XmlElement(name = "AuditState")
    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    @XmlElement(name = "OriginalArticleUrl")
    public String getOriginalArticleUrl() {
        return originalArticleUrl;
    }

    public void setOriginalArticleUrl(String originalArticleUrl) {
        this.originalArticleUrl = originalArticleUrl;
    }

    @XmlElement(name = "OriginalArticleType")
    public Integer getOriginalArticleType() {
        return originalArticleType;
    }

    public void setOriginalArticleType(Integer originalArticleType) {
        this.originalArticleType = originalArticleType;
    }

    @XmlElement(name = "CanReprint")
    public Integer getCanReprint() {
        return canReprint;
    }

    public void setCanReprint(Integer canReprint) {
        this.canReprint = canReprint;
    }

    @XmlElement(name = "NeedReplaceContent")
    public Integer getNeedReplaceContent() {
        return needReplaceContent;
    }

    public void setNeedReplaceContent(Integer needReplaceContent) {
        this.needReplaceContent = needReplaceContent;
    }

    @XmlElement(name = "NeedShowReprintSource")
    public Integer getNeedShowReprintSource() {
        return needShowReprintSource;
    }

    public void setNeedShowReprintSource(Integer needShowReprintSource) {
        this.needShowReprintSource = needShowReprintSource;
    }
}

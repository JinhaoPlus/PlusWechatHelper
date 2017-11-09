package top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.jobevent;


import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveMassSendJobFinishEventMessage extends ReceiveEventMessage {

    @XmlElement(name = "MsgID")
    private Long msgId;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "TotalCount")
    private Long totalCount;

    @XmlElement(name = "FilterCount")
    private Long filterCount;

    @XmlElement(name = "SentCount")
    private Long sentCount;

    @XmlElement(name = "ErrorCount")
    private Long errorCount;

    @XmlElement(name = "CopyrightCheckResult")
    private CopyrightCheckResult copyrightCheckResult;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Long filterCount) {
        this.filterCount = filterCount;
    }

    public Long getSentCount() {
        return sentCount;
    }

    public void setSentCount(Long sentCount) {
        this.sentCount = sentCount;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public CopyrightCheckResult getCopyrightCheckResult() {
        return copyrightCheckResult;
    }

    public void setCopyrightCheckResult(CopyrightCheckResult copyrightCheckResult) {
        this.copyrightCheckResult = copyrightCheckResult;
    }
}

class CopyrightCheckResult {

    private Long count;

    private List<CopyrightCheckResultItem> resultList;

    private Long checkState;

    @XmlElement(name = "Count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @XmlElementWrapper(name = "ResultList")
    @XmlElement(name="item")
    public List<CopyrightCheckResultItem> getResultList() {
        return resultList;
    }

    public void setResultList(List<CopyrightCheckResultItem> resultList) {
        this.resultList = resultList;
    }

    @XmlElement(name = "CheckState")
    public Long getCheckState() {
        return checkState;
    }

    public void setCheckState(Long checkState) {
        this.checkState = checkState;
    }
}


class CopyrightCheckResultItem {

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


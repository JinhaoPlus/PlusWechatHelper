package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.event.massSendJobFinishEvent;


import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveEventMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ReceiveMassSendJobFinishEventMessage extends ReceiveEventMessage {

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


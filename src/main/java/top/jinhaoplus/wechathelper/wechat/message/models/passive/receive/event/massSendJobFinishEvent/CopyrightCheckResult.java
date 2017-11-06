package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.event.massSendJobFinishEvent;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CopyrightCheckResult{

    @XmlElement(name = "Count")
    private Long count;

    @XmlElement(name = "ResultList")
    private List<CopyrightCheckResultItem> resultList;

    @XmlElement(name = "CheckState")
    private Long checkState;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<CopyrightCheckResultItem> getResultList() {
        return resultList;
    }

    public void setResultList(List<CopyrightCheckResultItem> resultList) {
        this.resultList = resultList;
    }

    public Long getCheckState() {
        return checkState;
    }

    public void setCheckState(Long checkState) {
        this.checkState = checkState;
    }
}

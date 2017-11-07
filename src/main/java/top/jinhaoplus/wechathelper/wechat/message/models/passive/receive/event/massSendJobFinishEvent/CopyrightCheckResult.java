package top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.event.massSendJobFinishEvent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class CopyrightCheckResult {

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

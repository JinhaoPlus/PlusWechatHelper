package top.jinhaoplus.wechathelper.wechat.general.entity;

public class QRCodeTicketRequest {
    private Integer expire_seconds;
    private QRCodeActionName action_name;
    private QRCodeActionInfo action_info;

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public QRCodeActionName getAction_name() {
        return action_name;
    }

    public void setAction_name(QRCodeActionName action_name) {
        this.action_name = action_name;
    }

    public QRCodeActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(QRCodeActionInfo action_info) {
        this.action_info = action_info;
    }

    public enum QRCodeActionName{
        //为临时的整型参数值
        QR_SCENE("QR_SCENE"),
        //为临时的字符串参数值
        QR_STR_SCENE("QR_STR_SCENE"),
        //为永久的整型参数值
        QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
        //为永久的字符串参数值
        QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

        private String actionName;

        QRCodeActionName(String actionName) {
            this.actionName = actionName;
        }

        @Override
        public String toString() {
            return actionName;
        }
    }
}

package top.jinhaoplus.wechathelper.wechat.message.request.massspeed;

public class MassSpeedRequest {
    private Integer speed;

    public MassSpeedRequest(MassSpeed speed) {
        this.speed = speed.getSpeed();
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}

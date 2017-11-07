package top.jinhaoplus.wechathelper.wechat.message.request.massspeed;

public enum MassSpeed {
    /**
     * MASS_SPEED0	80w/分钟
     * MASS_SPEED1	60w/分钟
     * MASS_SPEED2	45w/分钟
     * MASS_SPEED3	30w/分钟
     * MASS_SPEED4	10w/分钟
     */
    MASS_SPEED0(0),
    MASS_SPEED1(1),
    MASS_SPEED2(2),
    MASS_SPEED3(3),
    MASS_SPEED4(4);

    private Integer speed;

    MassSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }
}

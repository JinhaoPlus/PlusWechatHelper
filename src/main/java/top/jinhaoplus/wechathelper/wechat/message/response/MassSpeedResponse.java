package top.jinhaoplus.wechathelper.wechat.message.response;

import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;

public class MassSpeedResponse extends APIResponse {

    /**
     * errorcode
     * 45083	设置的 speed 参数不在0到4的范围内
     * 45084	没有设置 speed 参数
     */

    private Integer speed;
    private Integer realspeed;

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getRealspeed() {
        return realspeed;
    }

    public void setRealspeed(Integer realspeed) {
        this.realspeed = realspeed;
    }
}

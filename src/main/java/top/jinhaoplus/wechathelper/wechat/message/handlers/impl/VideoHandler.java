package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveVideoReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class VideoHandler extends ControlHandler<ReceiveVideoMessage> {

    @Autowired
    private InternalReceiveVideoReplyer receiveVideoReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.video;
        super.replyer = receiveVideoReplyer;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveVoiceMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveVoiceReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class VoiceHandler extends ControlHandler<ReceiveVoiceMessage> {

    @Autowired
    private InternalReceiveVoiceReplyer receiveVoiceReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.voice;
        super.replyer = receiveVoiceReplyer;
    }
}

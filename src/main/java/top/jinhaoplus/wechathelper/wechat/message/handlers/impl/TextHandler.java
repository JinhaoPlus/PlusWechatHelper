package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveTextReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class TextHandler extends ControlHandler<ReceiveTextMessage> {

    @Autowired
    private InternalReceiveTextReplyer receiveTextReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.text;
        super.replyer = receiveTextReplyer;
    }
}

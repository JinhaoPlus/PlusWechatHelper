package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveShortVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveShortVideoReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class ShortVideoHandler extends ControlHandler<ReceiveShortVideoMessage> {

    @Autowired
    private InternalReceiveShortVideoReplyer receiveShortVideoReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.shortvideo;
        super.replyer = receiveShortVideoReplyer;
    }
}

package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.MessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.ReceiveLocationMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveLocationReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class LocationHandler extends ControlHandler<ReceiveLocationMessage> {

    @Autowired
    private InternalReceiveLocationReplyer receiveLocationReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = MessageType.location;
        super.replyer = receiveLocationReplyer;
    }
}

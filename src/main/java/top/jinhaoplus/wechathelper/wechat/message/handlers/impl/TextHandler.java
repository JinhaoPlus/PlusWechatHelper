package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.MessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.ReceiveTextMessage;
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
        super.handleMsgType = MessageType.text;
        super.replyer = receiveTextReplyer;
    }
}

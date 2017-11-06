package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;

import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalEventReplyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EventHandler extends ControlHandler<ReceiveEventMessage> {

    private final static Logger logger = LoggerFactory.getLogger(EventHandler.class);

    @Autowired
    private InternalEventReplyer eventReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.event;
        super.replyer = eventReplyer;
    }
}

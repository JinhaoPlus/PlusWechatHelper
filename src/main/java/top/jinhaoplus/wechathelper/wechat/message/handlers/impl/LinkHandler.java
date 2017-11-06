package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;


import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveLinkMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveLinkReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class LinkHandler extends ControlHandler<ReceiveLinkMessage> {

    @Autowired
    private InternalReceiveLinkReplyer receiveLinkReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = PassiveMessageType.link;
        super.replyer = receiveLinkReplyer;
    }
}

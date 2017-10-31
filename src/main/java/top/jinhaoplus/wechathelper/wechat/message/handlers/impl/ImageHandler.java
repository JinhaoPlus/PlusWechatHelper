package top.jinhaoplus.wechathelper.wechat.message.handlers.impl;


import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.MessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.ReceiveImageMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveImageReplyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ImageHandler extends ControlHandler<ReceiveImageMessage> {

    @Autowired
    private InternalReceiveImageReplyer receiveImageReplyer;

    @PostConstruct
    public void init() {
        super.handleMsgType = MessageType.image;
        super.replyer = receiveImageReplyer;
    }
}

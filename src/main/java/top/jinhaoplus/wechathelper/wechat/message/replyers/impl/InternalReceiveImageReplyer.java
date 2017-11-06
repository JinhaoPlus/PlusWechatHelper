package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveImageMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveImageReplyer extends SimpleReplyer<ReceiveImageMessage> {

    @Override
    public SendMessage reply(ReceiveImageMessage receiveImageMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveImageMessage, defaultSendMessage);
        return doReply(receiveImageMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveImageMessage receiveMessage, SendMessage sendMessage);


}

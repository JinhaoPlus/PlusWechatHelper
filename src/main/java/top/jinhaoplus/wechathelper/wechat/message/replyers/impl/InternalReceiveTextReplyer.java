package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveTextReplyer extends SimpleReplyer<ReceiveTextMessage> {

    @Override
    public SendMessage reply(ReceiveTextMessage receiveTextMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveTextMessage, defaultSendMessage);
        return doReply(receiveTextMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveTextMessage receiveMessage, SendMessage sendMessage);


}

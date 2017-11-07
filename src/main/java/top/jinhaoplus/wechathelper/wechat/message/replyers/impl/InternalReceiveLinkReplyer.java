package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveLinkMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveLinkReplyer extends SimpleReplyer<ReceiveLinkMessage> {

    @Override
    public SendMessage reply(ReceiveLinkMessage receiveLinkMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveLinkMessage, defaultSendMessage);
        return doReply(receiveLinkMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveLinkMessage receiveMessage, SendMessage sendMessage);


}

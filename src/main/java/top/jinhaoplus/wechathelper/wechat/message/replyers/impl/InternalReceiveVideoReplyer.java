package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveVideoReplyer extends SimpleReplyer<ReceiveVideoMessage> {

    @Override
    public SendMessage reply(ReceiveVideoMessage receiveVideoMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveVideoMessage, defaultSendMessage);
        return doReply(receiveVideoMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveVideoMessage receiveMessage, SendMessage sendMessage);


}

package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveLocationMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveLocationReplyer extends SimpleReplyer<ReceiveLocationMessage> {

    @Override
    public SendMessage reply(ReceiveLocationMessage receiveLocationMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveLocationMessage, defaultSendMessage);
        return doReply(receiveLocationMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveLocationMessage receiveMessage, SendMessage sendMessage);


}

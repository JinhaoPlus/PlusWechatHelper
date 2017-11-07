package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveVoiceMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveVoiceReplyer extends SimpleReplyer<ReceiveVoiceMessage> {

    @Override
    public SendMessage reply(ReceiveVoiceMessage receiveVoiceMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveVoiceMessage, defaultSendMessage);
        return doReply(receiveVoiceMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveVoiceMessage receiveMessage, SendMessage sendMessage);


}

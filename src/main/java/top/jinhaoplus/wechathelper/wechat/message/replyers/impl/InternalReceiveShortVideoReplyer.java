package top.jinhaoplus.wechathelper.wechat.message.replyers.impl;

import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.ReceiveShortVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.SimpleReplyer;

public abstract class InternalReceiveShortVideoReplyer extends SimpleReplyer<ReceiveShortVideoMessage> {

    @Override
    public SendMessage reply(ReceiveShortVideoMessage receiveShortVideoMessage, SendMessage defaultSendMessage) {
        defaultSendMessage = super.reply(receiveShortVideoMessage, defaultSendMessage);
        return doReply(receiveShortVideoMessage, defaultSendMessage);
    }

    public abstract SendMessage doReply(ReceiveShortVideoMessage receiveMessage, SendMessage sendMessage);


}

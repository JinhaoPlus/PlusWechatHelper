package top.jinhaoplus.wechathelper.wechat.message.replyers;


import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;

/**
 * 微信消息回复器接口
 */
public interface Replyer<T extends ReceiveMessage> {
    public SendMessage reply(T receiveMessage, SendMessage sendMessage);
}

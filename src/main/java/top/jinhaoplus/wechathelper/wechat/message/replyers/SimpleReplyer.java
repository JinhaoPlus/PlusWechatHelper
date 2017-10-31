package top.jinhaoplus.wechathelper.wechat.message.replyers;


import top.jinhaoplus.wechathelper.wechat.message.models.receive.ReceiveMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;

/**
 * 微信消息基础回复器
 */
public class SimpleReplyer<T extends ReceiveMessage> implements Replyer<T> {

    @Override
    public SendMessage reply(T receiveMessage, SendMessage defaultSendMessage) {
        String sendFromUserName = receiveMessage.getToUserName();
        String sendToUserName = receiveMessage.getFromUserName();
        defaultSendMessage.setCreateTime(System.currentTimeMillis());
        defaultSendMessage.setFromUserName(sendFromUserName);
        defaultSendMessage.setToUserName(sendToUserName);
        return defaultSendMessage;
    }

    public <S extends SendMessage> S convertSendMessage(SendMessage defaultSendMessage, Class<S> clazz) throws IllegalAccessException, InstantiationException {
        S specificSendMessage = clazz.newInstance();
        specificSendMessage.setToUserName(defaultSendMessage.getToUserName());
        specificSendMessage.setFromUserName(defaultSendMessage.getFromUserName());
        specificSendMessage.setCreateTime(defaultSendMessage.getCreateTime());
        return specificSendMessage;
    }
}

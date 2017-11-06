package top.jinhaoplus.wechathelper.wechat.message.handlers;


import org.apache.commons.lang3.StringUtils;
import top.jinhaoplus.wechathelper.wechat.exception.WechatAPIException;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.PassiveMessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.ReceiveMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.Replyer;
import top.jinhaoplus.wechathelper.wechat.utils.JaxbXmlUtil;

/**
 * 输入微信消息后的处理器接口
 */
public class ControlHandler<T extends ReceiveMessage> {

    protected Replyer<T> replyer;

    protected PassiveMessageType handleMsgType;

    /**
     * 检查输入消息的类型是否正确
     *
     * @param message
     * @throws Exception
     */
    private void checkMessageType(ReceiveMessage message) throws Exception {
        if (!handleMsgType.equals(message.getMsgType()))
            throw new WechatAPIException("输入消息类型不匹配");
    }

    /**
     * 根据输入数据型消息回复消息
     *
     * @param message
     * @return
     */
    private SendMessage reply(T message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage = replyer.reply(message, sendMessage);
        return sendMessage;
    }


    /**
     * 将回复消息字符串化
     *
     * @param sendMessage
     * @return
     */
    private String stringfySendMessage(SendMessage sendMessage) {
        return JaxbXmlUtil.beanToXml(sendMessage);
    }

    /**
     * 接收一个消息并返回一个被动消息
     *
     * @param message 输入消息
     * @return 输出消息
     */
    public String handle(T message) throws Exception {
        checkMessageType(message);
        SendMessage sendMessage = reply(message);
        return stringfySendMessage(sendMessage);
    }

    /**
     * 接收一个消息及其原始消息字符串并返回一个被动消息:用于处理接收事件
     *
     * @param messageStr 输入消息原是字符串
     * @param message    输入消息
     * @return 输出消息
     */
    public String handleEvent(String messageStr, T message) throws Exception {
        checkMessageType(message);
        Class<? extends ReceiveEventMessage> eventClass = ReceiveEventMessage.getEventClass(messageStr, (ReceiveEventMessage) message);
        message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveEventMessage.class, eventClass);
        SendMessage sendMessage = reply(message);
        if(!StringUtils.isBlank(sendMessage.getMsgType())){
            return stringfySendMessage(sendMessage);
        }
        return null;
    }
}

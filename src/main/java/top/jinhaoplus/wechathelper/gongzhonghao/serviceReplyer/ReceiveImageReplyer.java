package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveImageMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveImageReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveImageReplyer extends InternalReceiveImageReplyer {

    @Override
    public SendMessage doReply(ReceiveImageMessage receiveImageMessage, SendMessage defaultSendMessage) {
        try {
            SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
            sendTextMessage.setContent("HELLO");
            return sendTextMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultSendMessage;
    }
}

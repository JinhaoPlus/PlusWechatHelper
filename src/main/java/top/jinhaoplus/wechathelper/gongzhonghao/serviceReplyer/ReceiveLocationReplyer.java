package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveLocationMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveLocationReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveLocationReplyer extends InternalReceiveLocationReplyer {

    @Override
    public SendMessage doReply(ReceiveLocationMessage receiveLocationMessage, SendMessage defaultSendMessage) {
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

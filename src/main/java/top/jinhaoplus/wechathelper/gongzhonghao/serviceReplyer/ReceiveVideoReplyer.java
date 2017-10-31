package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.ReceiveVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveVideoReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveVideoReplyer extends InternalReceiveVideoReplyer {

    @Override
    public SendMessage doReply(ReceiveVideoMessage receiveVideoMessage, SendMessage defaultSendMessage) {
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

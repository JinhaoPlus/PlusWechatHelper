package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveShortVideoMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveShortVideoReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveShortVideoReplyer extends InternalReceiveShortVideoReplyer {

    @Override
    public SendMessage doReply(ReceiveShortVideoMessage receiveVideoMessage, SendMessage defaultSendMessage) {
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

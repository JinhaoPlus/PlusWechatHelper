package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.passive.receive.data.ReceiveVoiceMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveVoiceReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveVoiceReplyer extends InternalReceiveVoiceReplyer {

    @Override
    public SendMessage doReply(ReceiveVoiceMessage receiveVoiceMessage, SendMessage defaultSendMessage) {
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

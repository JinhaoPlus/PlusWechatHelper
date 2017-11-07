package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.data.ReceiveLinkMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalReceiveLinkReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveLinkReplyer extends InternalReceiveLinkReplyer {

    @Override
    public SendMessage doReply(ReceiveLinkMessage receiveLinkMessage, SendMessage defaultSendMessage) {
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

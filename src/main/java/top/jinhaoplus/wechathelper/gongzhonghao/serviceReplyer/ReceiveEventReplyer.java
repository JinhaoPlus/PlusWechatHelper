package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import org.springframework.stereotype.Component;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.ReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveLocationReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveQRCodeReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.commonevent.ReceiveSubUnsubReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.jobevent.ReceiveTemplateJobFinishEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.receive.event.jobevent.ReceiveMassSendJobFinishEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.entity.passive.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalEventReplyer;


@Component
public class ReceiveEventReplyer extends InternalEventReplyer {

    @Override
    public SendMessage doReply(ReceiveEventMessage receiveEventMessage, SendMessage defaultSendMessage) {
        try {
            if (receiveEventMessage instanceof ReceiveSubUnsubReceiveEventMessage) {
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("SUBUNSUB");
                return sendTextMessage;
            } else if (receiveEventMessage instanceof ReceiveQRCodeReceiveEventMessage) {
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("SCAN");
                return sendTextMessage;
            } else if (receiveEventMessage instanceof ReceiveTemplateJobFinishEventMessage) {
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("模版发掉了");
                return sendTextMessage;
            } else if (receiveEventMessage instanceof ReceiveMassSendJobFinishEventMessage) {
                System.out.println("群发发掉了");
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("群发发掉了");
                return sendTextMessage;
            } else if (receiveEventMessage instanceof ReceiveLocationReceiveEventMessage) {
                return defaultSendMessage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultSendMessage;
    }
}

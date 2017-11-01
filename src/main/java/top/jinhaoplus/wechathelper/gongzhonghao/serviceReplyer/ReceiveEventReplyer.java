package top.jinhaoplus.wechathelper.gongzhonghao.serviceReplyer;

import top.jinhaoplus.wechathelper.wechat.message.models.receive.ReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.event.ReceiveLocationReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.event.ReceiveQRCodeReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.event.ReceiveSubUnsubReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.event.ReceiveTemplateJobFinishEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.SendMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.send.data.text.SendTextMessage;
import top.jinhaoplus.wechathelper.wechat.message.replyers.impl.InternalEventReplyer;
import org.springframework.stereotype.Component;


@Component
public class ReceiveEventReplyer extends InternalEventReplyer {

    @Override
    public SendMessage doReply(ReceiveEventMessage receiveEventMessage, SendMessage defaultSendMessage) {
        try {
            if(receiveEventMessage instanceof ReceiveSubUnsubReceiveEventMessage){
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("SUBUNSUB");
                return sendTextMessage;
            }else if(receiveEventMessage instanceof ReceiveQRCodeReceiveEventMessage){
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("SCAN");
                return sendTextMessage;
            }else if(receiveEventMessage instanceof ReceiveTemplateJobFinishEventMessage){
                SendTextMessage sendTextMessage = convertSendMessage(defaultSendMessage, SendTextMessage.class);
                sendTextMessage.setContent("模版发掉了");
                return sendTextMessage;
            }else if(receiveEventMessage instanceof ReceiveLocationReceiveEventMessage){
                return defaultSendMessage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultSendMessage;
    }
}

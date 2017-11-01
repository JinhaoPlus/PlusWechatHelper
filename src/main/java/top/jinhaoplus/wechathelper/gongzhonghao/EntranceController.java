package top.jinhaoplus.wechathelper.gongzhonghao;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.message.handlers.ControlHandler;
import top.jinhaoplus.wechathelper.wechat.message.models.MessageType;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.ReceiveEventMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.ReceiveMessage;
import top.jinhaoplus.wechathelper.wechat.message.models.receive.data.*;
import top.jinhaoplus.wechathelper.wechat.utils.JaxbXmlUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;


/**
 * 公众号请求入口
 */
@RestController
public class EntranceController {

    private final static Logger logger = LoggerFactory.getLogger(EntranceController.class);

    private static final String QUIET_RESULT = "success";

    @Resource
    private ControlHandler textHandler;
    @Resource
    private ControlHandler imageHandler;
    @Resource
    private ControlHandler voiceHandler;
    @Resource
    private ControlHandler videoHandler;
    @Resource
    private ControlHandler shortVideoHandler;
    @Resource
    private ControlHandler locationHandler;
    @Resource
    private ControlHandler linkHandler;
    @Resource
    private ControlHandler eventHandler;


    /**
     * 直接使用GET方式请求用于校验请求来源于微信服务端
     *
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String sayHello(HttpServletRequest request) {
        if (BasicAPI.verifyMessage(request))
            return request.getParameter("echostr");
        return BasicAPI.MESSAGE_VERIFY_ERROR;
    }


    /**
     * 使用POST方式请求，携带XML数据信息，表示请求用于进行后台处理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String handlePassiveMessage(HttpServletRequest request) {
        if (!BasicAPI.verifyMessage(request))
            return BasicAPI.MESSAGE_VERIFY_ERROR;
        StringBuffer messageBuffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                messageBuffer.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String messageStr = messageBuffer.toString();
        logger.info(messageBuffer.toString());
        if (StringUtils.isBlank(messageStr))
            return QUIET_RESULT;

        ReceiveMessage message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class);
        if (message == null) {
            return QUIET_RESULT;
        }

        String msgType = message.getMsgType();

        String responseStr = QUIET_RESULT;
        try {
            if (MessageType.text.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveTextMessage.class);
                responseStr = textHandler.handle(message);
            } else if (MessageType.image.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveImageMessage.class);
                responseStr = imageHandler.handle(message);
            } else if (MessageType.voice.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveVoiceMessage.class);
                responseStr = voiceHandler.handle(message);
            } else if (MessageType.video.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveVideoMessage.class);
                responseStr = videoHandler.handle(message);
            } else if (MessageType.shortvideo.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveShortVideoMessage.class);
                responseStr = shortVideoHandler.handle(message);
            } else if (MessageType.location.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveLocationMessage.class);
                responseStr = locationHandler.handle(message);
            } else if (MessageType.link.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveLinkMessage.class);
                responseStr = linkHandler.handle(message);
            } else if (MessageType.event.equals(msgType)) {
                message = JaxbXmlUtil.xmlToBean(messageStr, ReceiveMessage.class, ReceiveEventMessage.class);
                responseStr = eventHandler.handleEvent(messageStr, message);
            }
            if (!StringUtils.isBlank(responseStr))
                return responseStr;
            else
                return QUIET_RESULT;
        } catch (Exception e) {
            e.printStackTrace();
            return QUIET_RESULT;
        }
    }
}

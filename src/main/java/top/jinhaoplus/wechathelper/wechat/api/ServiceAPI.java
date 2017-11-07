package top.jinhaoplus.wechathelper.wechat.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;
import top.jinhaoplus.wechathelper.wechat.utils.SysConfig;

import java.util.Properties;


/**
 * 微信接口内部调用
 */
public class ServiceAPI {
    private static Logger logger = Logger.getLogger(top.jinhaoplus.wechathelper.wechat.api.ServiceAPI.class);
    private static String loggerHeader = "[微信接口调用日志]";

    private static RestTemplate client = WeChatRestClient.getInstance();

    protected final static Properties wechatProperties = SysConfig.getProperties("wechat.properties");
    protected final static String appId = wechatProperties.getProperty("service.appid");
    protected final static String appSecret = wechatProperties.getProperty("service.appsecret");

    /**
     * API内部调用方法：content-type默认使用application/json;charset=UTF-8
     *
     * @param apiUrl       API接口url
     * @param apiMethod    API调用方法
     * @param responseType 返回类型
     * @param entity       传入实体
     * @param <T>
     * @return
     */
    protected static synchronized <T extends APIResponse> T invokeAPI(String apiUrl, ApiMethod apiMethod, Class<T> responseType, Object entity) {
        // 默认的content-type为application/json;charset=UTF-8
        return invokeAPI(apiUrl, apiMethod, responseType, entity, MediaType.APPLICATION_JSON_UTF8);
    }

    /**
     * 灵活的API内部调用方法，可自行指定content-type
     *
     * @param apiUrl       API接口url
     * @param apiMethod    API调用方法
     * @param responseType 返回类型
     * @param entity       传入实体
     * @param mediaType    实体类型
     * @param <T>
     * @return
     */
    protected static synchronized <T extends APIResponse> T invokeAPI(String apiUrl, ApiMethod apiMethod, Class<T> responseType, Object entity, MediaType mediaType) {
        logger.debug(loggerHeader + "开始调用微信接口");
        logger.debug(loggerHeader + apiMethod.toString() + "  " + apiUrl);
        APIResponse response = new APIResponse();
        String plainResponse;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        if (apiMethod != null && !StringUtils.isBlank(apiUrl)) {
            try {
                if (ApiMethod.GET.equals(apiMethod)) {
                    plainResponse = client.getForEntity(apiUrl, String.class).getBody();
                    response = JsonUtil.str2bean(plainResponse, responseType);
                } else if (ApiMethod.POST.equals(apiMethod)) {
                    logger.debug(loggerHeader + "微信接口传入的参数是\n" + JsonUtil.bean2str(entity));
                    // HttpEntity即为需要发送的消息实体
                    HttpEntity<Object> requestEntity = new HttpEntity<>(entity, headers);
                    plainResponse = client.postForEntity(apiUrl, requestEntity, String.class).getBody();
                    logger.debug(loggerHeader + "微信接口返回结果的结果是\n" + plainResponse);
                    response = JsonUtil.str2bean(plainResponse, responseType);
                }
                logger.debug(loggerHeader + "接口调用成功");
                response.setAquired(true);
                return (T) response;
            } catch (Exception e) {
                logger.error(loggerHeader + "接口调用失败, 异常栈如下");
                e.printStackTrace();
            }
        }
        return null;
    }

    protected static String formatUrl(String rawUrl, String[] parameters) {
        String formatUrl = rawUrl;
        for (String parameter :
                parameters) {
            formatUrl = formatUrl.replaceFirst("\\{}", parameter);
        }
        if (formatUrl.contains("\\{}"))
            logger.error(loggerHeader + "不合法的拼接接口地址");
        return formatUrl;
    }
}

package top.jinhaoplus.wechathelper.wechat.api;

import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;
import top.jinhaoplus.wechathelper.wechat.utils.SysConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

public class ServiceAPI {
    private static Logger logger = Logger.getLogger(top.jinhaoplus.wechathelper.wechat.api.ServiceAPI.class);
    private static String loggerHeader = "[微信接口调用日志]";

    private static RestTemplate client = WeChatRestClient.getInstance();

    protected final static Properties wechatProperties = SysConfig.getProperties("wechat.properties");
    protected final static String appId = wechatProperties.getProperty("service.appid");
    protected final static String appSecret = wechatProperties.getProperty("service.appsecret");

    protected static synchronized <T extends APIResponse> T invokeAPI(String apiUrl, ApiMethod apiMethod, Class<T> responseType, Object entity) {
        APIResponse response = new APIResponse();
        String plainResponse;
        if (apiMethod != null && !StringUtils.isBlank(apiUrl)) {
            try {
                if (ApiMethod.GET.equals(apiMethod)) {
                    plainResponse = client.getForEntity(apiUrl, String.class).getBody();
                    response = JsonUtil.str2bean(plainResponse, responseType);
                } else if (ApiMethod.POST.equals(apiMethod)) {
                    plainResponse = client.postForEntity(apiUrl, entity, String.class).getBody();
                    response = JsonUtil.str2bean(plainResponse, responseType);
                }
                logger.info(loggerHeader + "接口调用成功");
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

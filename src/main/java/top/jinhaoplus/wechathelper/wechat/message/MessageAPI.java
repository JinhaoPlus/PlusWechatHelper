package top.jinhaoplus.wechathelper.wechat.message;


import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.ErrorResponse;
import top.jinhaoplus.wechathelper.wechat.message.models.template.Industry;
import top.jinhaoplus.wechathelper.wechat.message.models.template.IndustrySetRequest;
import top.jinhaoplus.wechathelper.wechat.message.models.template.TemplateDeleteRequest;
import top.jinhaoplus.wechathelper.wechat.message.models.template.TemplateSendRequest;
import top.jinhaoplus.wechathelper.wechat.message.response.IndustryGetResponse;
import top.jinhaoplus.wechathelper.wechat.message.response.TemplateListResponse;
import top.jinhaoplus.wechathelper.wechat.message.response.TemplateMsgSendResponse;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

import java.io.IOException;

public class MessageAPI extends ServiceAPI {
    /**
     * 设置行业
     *
     * @param accessToken
     * @param primaryIndustry
     * @param secondaryIndustry
     * @return
     * @throws IOException
     */
    public static ErrorResponse setIndustry(String accessToken, Industry primaryIndustry, Industry secondaryIndustry) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.setindustry"), new String[]{accessToken});
        IndustrySetRequest request = new IndustrySetRequest(primaryIndustry.getIndustryCode(), secondaryIndustry.getIndustryCode());
        ErrorResponse response = invokeAPI(url, ApiMethod.POST, ErrorResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 获取行业
     *
     * @param accessToken
     * @return
     * @throws IOException
     */
    public static IndustryGetResponse getIndustry(String accessToken) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.getindustry"), new String[]{accessToken});
        IndustryGetResponse response = invokeAPI(url, ApiMethod.GET, IndustryGetResponse.class, null);
        return response;
    }

    /**
     * 获取公众号下面所有的消息模版列表
     *
     * @param accessToken
     * @return
     */
    public static TemplateListResponse getTemplateList(String accessToken) {
        String url = formatUrl(wechatProperties.getProperty("url.message.getTemplateList"), new String[]{accessToken});
        TemplateListResponse response = invokeAPI(url, ApiMethod.GET, TemplateListResponse.class, null);
        return response;
    }

    /**
     * 删除消息模版
     *
     * @param accessToken
     * @param templateId
     * @return
     * @throws IOException
     */
    public static ErrorResponse deleteTemplate(String accessToken, String templateId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.deleteTemplate"), new String[]{accessToken});
        TemplateDeleteRequest request = new TemplateDeleteRequest(templateId);
        ErrorResponse response = invokeAPI(url, ApiMethod.POST, ErrorResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 发送模版消息
     *
     * @param accessToken
     * @param request
     * @return
     * @throws IOException
     */
    public static TemplateMsgSendResponse sendTemplateMessage(String accessToken, TemplateSendRequest request) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.sendTemplateMessage"), new String[]{accessToken});
        TemplateMsgSendResponse response = invokeAPI(url, ApiMethod.POST, TemplateMsgSendResponse.class, JsonUtil.bean2str(request));
        return response;
    }
}

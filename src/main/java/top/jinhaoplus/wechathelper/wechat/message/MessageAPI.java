package top.jinhaoplus.wechathelper.wechat.message;


import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.message.entity.masssend.*;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.Industry;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.IndustrySetRequest;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.TemplateDeleteRequest;
import top.jinhaoplus.wechathelper.wechat.message.entity.template.TemplateSendRequest;
import top.jinhaoplus.wechathelper.wechat.message.request.massdelete.MassDeleteRequest;
import top.jinhaoplus.wechathelper.wechat.message.request.masspreview.*;
import top.jinhaoplus.wechathelper.wechat.message.request.masssend.*;
import top.jinhaoplus.wechathelper.wechat.message.request.massspeed.MassSpeed;
import top.jinhaoplus.wechathelper.wechat.message.request.massspeed.MassSpeedRequest;
import top.jinhaoplus.wechathelper.wechat.message.request.massstatus.MassStatusRequest;
import top.jinhaoplus.wechathelper.wechat.message.response.*;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

import java.io.IOException;
import java.util.List;

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
    public static APIResponse setIndustry(String accessToken, Industry primaryIndustry, Industry secondaryIndustry) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.setindustry"), new String[]{accessToken});
        IndustrySetRequest request = new IndustrySetRequest(primaryIndustry.getIndustryCode(), secondaryIndustry.getIndustryCode());
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
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
        String url = formatUrl(wechatProperties.getProperty("url.message.gettemplateList"), new String[]{accessToken});
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
    public static APIResponse deleteTemplate(String accessToken, String templateId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.deletetemplate"), new String[]{accessToken});
        TemplateDeleteRequest request = new TemplateDeleteRequest(templateId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
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
        String url = formatUrl(wechatProperties.getProperty("url.message.sendtemplatemessage"), new String[]{accessToken});
        TemplateMsgSendResponse response = invokeAPI(url, ApiMethod.POST, TemplateMsgSendResponse.class, JsonUtil.bean2str(request));
        return response;
    }


    /**
     * 根据标签进行群发
     *
     * @param accessToken
     * @param messageType 群发消息的类型
     *                    [注意]微信测试公众号在发送非文本的群发消息时会收到no permission for this msgtype的错误，尚不清楚此群发类型的限制
     * @param massContent 群发消息的内容：
     *                    若群发文本则直接在此传入文本内容
     *                    若群发图片、语音、视频、图文消息则传入它们的media_id
     *                    若群发卡券则传入卡券编号card_id
     * @param massSendTag 群发消息的目标用户标签：传空表示不区分标签全部发送
     * @return
     * @throws IOException
     */
    public static MassSendResponse massSendByTag(String accessToken, MassSendMessageType messageType, String massContent, Integer massSendTag) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.masssendall"), new String[]{accessToken});

        MassSendRequest request = convertMassSendRequest(messageType, massContent);

        Filter filter = new Filter();
        if (massSendTag == null)
            filter.setIs_to_all(true);
        else {
            filter.setIs_to_all(false);
            filter.setTag_id(massSendTag);
        }
        request.setFilter(filter);

        MassSendResponse response = invokeAPI(url, ApiMethod.POST, MassSendResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    /**
     * 根据OpenID列表进行群发
     *
     * @param accessToken
     * @param messageType 群发消息的类型
     *                    [注意]微信测试公众号在发送非文本的群发消息时会收到no permission for this msgtype的错误，尚不清楚此群发类型的限制
     * @param massContent 群发消息的内容：
     *                    若群发文本则直接在此传入文本内容
     *                    若群发图片、语音、视频、图文消息则传入它们的media_id
     *                    若群发卡券则传入卡券编号card_id
     * @param openIds     群发消息的目标用户的openid列表
     * @return
     * @throws IOException
     */
    public static MassSendResponse massSendByOpenIds(String accessToken, MassSendMessageType messageType, String massContent, List<String> openIds) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.masssend"), new String[]{accessToken});
        MassSendRequest request = convertMassSendRequest(messageType, massContent);

        request.setTouser(openIds);

        MassSendResponse response = invokeAPI(url, ApiMethod.POST, MassSendResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    private static MassSendRequest convertMassSendRequest(MassSendMessageType messageType, String massContent) {
        MassSendRequest request = new MassSendRequest();
        if (MassSendMessageType.text == messageType) {
            TextMassSendContent sendContent = new TextMassSendContent(massContent);
            request = new TextMassSendRequest(sendContent);
        } else if (MassSendMessageType.image == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new ImageMassSendRequest(sendContent);
        } else if (MassSendMessageType.voice == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new VoiceMassSendRequest(sendContent);
        } else if (MassSendMessageType.mpvideo == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new MpVideoMassSendRequest(sendContent);
        } else if (MassSendMessageType.mpnews == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new MpNewsMassSendRequest(sendContent);
        } else if (MassSendMessageType.wxcard == messageType) {
            WxcardMassSendContent sendContent = new WxcardMassSendContent(massContent);
            request = new WxcardMassSendRequest(sendContent);
        }
        return request;
    }


    /**
     * 群发消息预览
     *
     * @param accessToken
     * @param messageType 群发消息的类型
     * @param massContent 群发消息的内容：
     *                    若群发文本则直接在此传入文本内容
     *                    若群发图片、语音、视频、图文消息则传入它们的media_id
     *                    若群发卡券则传入卡券编号card_id
     * @param openId      群发消息的目标用户的openid
     * @return
     * @throws IOException
     */
    public static MassSendResponse previewMassSend(String accessToken, MassSendMessageType messageType, String massContent, String openId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.masspreview"), new String[]{accessToken});
        MassPreviewRequest request = convertMassPreviewRequest(messageType, massContent);

        request.setTouser(openId);

        MassSendResponse response = invokeAPI(url, ApiMethod.POST, MassSendResponse.class, JsonUtil.bean2str(request));
        return response;
    }

    private static MassPreviewRequest convertMassPreviewRequest(MassSendMessageType messageType, String massContent) {
        MassPreviewRequest request = new MassPreviewRequest();
        if (MassSendMessageType.text == messageType) {
            TextMassSendContent sendContent = new TextMassSendContent(massContent);
            request = new TextMassPreviewRequest(sendContent);
        } else if (MassSendMessageType.image == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new ImageMassPreviewRequest(sendContent);
        } else if (MassSendMessageType.voice == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new VoiceMassPreviewRequest(sendContent);
        } else if (MassSendMessageType.mpvideo == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new MpVideoMassPreviewRequest(sendContent);
        } else if (MassSendMessageType.mpnews == messageType) {
            MediaMassSendContent sendContent = new MediaMassSendContent(massContent);
            request = new MpNewsMassPreviewRequest(sendContent);
        } else if (MassSendMessageType.wxcard == messageType) {
            WxcardMassSendContent sendContent = new WxcardMassSendContent(massContent);
            request = new WxcardMassPreviewRequest(sendContent);
        }
        return request;
    }


    /**
     * 删除群发消息
     * [注意]删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除
     *
     * @param accessToken
     * @param messageId    消息编号
     * @param articleIndex 若为图文消息，设置要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     * @return
     * @throws IOException
     */
    public static APIResponse deleteMassSend(String accessToken, Long messageId, Integer articleIndex) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.massdelete"), new String[]{accessToken});
        MassDeleteRequest request = new MassDeleteRequest(messageId, articleIndex);

        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, JsonUtil.bean2str(request));
        return response;
    }


    /**
     * 查询群发消息发送状态
     *
     * @param accessToken
     * @param messageId   消息编号
     * @return
     * @throws IOException
     */
    public static MassStatusResponse getMassSendStatus(String accessToken, Long messageId) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.messstatus"), new String[]{accessToken});
        MassStatusRequest request = new MassStatusRequest(messageId);

        MassStatusResponse response = invokeAPI(url, ApiMethod.POST, MassStatusResponse.class, JsonUtil.bean2str(request));
        return response;
    }


    /**
     * 控制群发速度
     *
     * @param accessToken
     * @param massSpeed   群发速度
     *                    0	80w/分钟
     *                    1	60w/分钟
     *                    2	45w/分钟
     *                    3	30w/分钟
     *                    4	10w/分钟
     * @return
     * @throws IOException
     */
    public static MassSpeedResponse setMassSendSpeed(String accessToken, MassSpeed massSpeed) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.message.massspeed"), new String[]{accessToken});
        MassSpeedRequest request = new MassSpeedRequest(massSpeed);

        MassSpeedResponse response = invokeAPI(url, ApiMethod.POST, MassSpeedResponse.class, JsonUtil.bean2str(request));
        return response;
    }
}

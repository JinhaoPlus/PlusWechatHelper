package top.jinhaoplus.wechathelper.wechat.media;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.exception.WechatAPIException;
import top.jinhaoplus.wechathelper.wechat.media.entity.Mediatype;
import top.jinhaoplus.wechathelper.wechat.media.request.*;
import top.jinhaoplus.wechathelper.wechat.media.response.*;

import java.io.File;

public class MediaAPI extends ServiceAPI {

    /**
     * 添加新临时素材: 在获取素材列表接口中无法获取到这一类临时素材
     *
     * @param accessToken
     * @param sourcefilePath 临时素材在本地文件系统里的路径
     * @param type           素材类型
     * @return
     */
    public static MediaAddResponse addTempMedia(String accessToken, String sourcefilePath, Mediatype type) {
        String url = formatUrl(wechatProperties.getProperty("url.media.addtempmedia"), new String[]{accessToken, type.toString()});
        File file = new File(sourcefilePath);
        if (file.exists()) {
            LinkedMultiValueMap<String, Object> paraMap = new LinkedMultiValueMap<>();
            paraMap.add("media", new FileSystemResource(file));
            MediaAddResponse response = invokeAPI(url, ApiMethod.POST, MediaAddResponse.class, paraMap, MediaType.MULTIPART_FORM_DATA);
            return response;
        }
        throw new WechatAPIException("素材文件在本地文件系统不存在");
    }

    /**
     * 二次上传视频临时素材：获取群发视频消息所需的视频media_id
     *
     * @param accessToken
     * @param mediaId     通过addTempMedia接口上传临时视频素材获得的mediaId
     * @return
     */
    public static MassSendVideoUploadResponse uploadMesssendVideo(String accessToken, String mediaId, String title, String description) {
        String url = formatUrl(wechatProperties.getProperty("url.media.uploadvideo"), new String[]{accessToken});
        MassSendVideoUpdateRequest request = new MassSendVideoUpdateRequest(mediaId, title, description);
        MassSendVideoUploadResponse response = invokeAPI(url, ApiMethod.POST, MassSendVideoUploadResponse.class, request);
        return response;
    }

    /**
     * 获取临时素材
     *
     * @param accessToken
     * @param mediaId     临时素材ID
     * @return
     */
    public static String getTempMedia(String accessToken, String mediaId) {
        return formatUrl(wechatProperties.getProperty("url.media.gettempmedia"), new String[]{accessToken, mediaId});
    }


    /**
     * 上传临时图文消息素材：在获取图文消息素材列表接口中无法获取到这一类临时图文消息素材
     * 图文素材中的封面图片缩略图需使用addTempMedia接口上传临时缩略图，若使用addMaterial上传的永久素材会报错
     *
     * @param accessToken
     * @param request     组装好的图文消息素材
     * @return
     */
    public static NewsUploadResponse uploadNews(String accessToken, NewsAddRequest request) {
        String url = formatUrl(wechatProperties.getProperty("url.media.uploadnews"), new String[]{accessToken});
        NewsUploadResponse response = invokeAPI(url, ApiMethod.POST, NewsUploadResponse.class, request);
        return response;
    }

    /**
     * 上传图文消息内的临时图片获取URL
     *
     * @param accessToken
     * @param sourcefilePath 上传图文消息内的图片在本地文件系统里的路径
     * @return
     */
    public static UploadImgResponse uploadNewsImg(String accessToken, String sourcefilePath) {
        String url = formatUrl(wechatProperties.getProperty("url.media.uploadimg"), new String[]{accessToken});
        File file = new File(sourcefilePath);
        if (file.exists()) {
            LinkedMultiValueMap<String, Object> paraMap = new LinkedMultiValueMap<>();
            paraMap.add("media", new FileSystemResource(file));
            UploadImgResponse response = invokeAPI(url, ApiMethod.POST, UploadImgResponse.class, paraMap, MediaType.MULTIPART_FORM_DATA);
            return response;
        }
        throw new WechatAPIException("素材文件在本地文件系统不存在");
    }

    /**
     * 添加新永久素材
     *
     * @param accessToken
     * @param sourcefilePath  永久素材在本地文件系统里的路径
     * @param type            素材类型
     * @param videoAddRequest 素材类型若为video需传入此参数
     * @return
     */
    public static MaterialAddResponse addMaterial(String accessToken, String sourcefilePath, Mediatype type, VideoAddRequest videoAddRequest) {
        String url = formatUrl(wechatProperties.getProperty("url.media.addmaterial"), new String[]{accessToken, type.toString()});
        File file = new File(sourcefilePath);
        if (file.exists()) {
            LinkedMultiValueMap<String, Object> paraMap = new LinkedMultiValueMap<>();
            paraMap.add("media", new FileSystemResource(file));
            if (Mediatype.video.equals(type)) {
                paraMap.add("description", videoAddRequest);
            }
            MaterialAddResponse response = invokeAPI(url, ApiMethod.POST, MaterialAddResponse.class, paraMap, MediaType.MULTIPART_FORM_DATA);
            return response;
        }
        throw new WechatAPIException("素材文件在本地文件系统不存在");
    }

    /**
     * 新增永久图文消息素材
     *
     * @param accessToken
     * @param request     组装好的图文消息素材
     * @return
     */
    public static NewsAddResponse addNews(String accessToken, NewsAddRequest request) {
        String url = formatUrl(wechatProperties.getProperty("url.media.addnews"), new String[]{accessToken});
        NewsAddResponse response = invokeAPI(url, ApiMethod.POST, NewsAddResponse.class, request);
        return response;
    }

    /**
     * 修改永久图文消息素材
     *
     * @param accessToken
     * @param request     组装好的图文消息修改素材
     * @return
     */
    public static APIResponse updateNews(String accessToken, NewsUpdateRequest request) {
        String url = formatUrl(wechatProperties.getProperty("url.media.updatenews"), new String[]{accessToken});
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }

    /**
     * 获取永久素材:视频素材
     *
     * @param accessToken
     * @param mediaId
     * @return
     */
    public static VideoGetResponse getBasicMaterial(String accessToken, String mediaId) {
        String url = formatUrl(wechatProperties.getProperty("url.media.getmaterial"), new String[]{accessToken});
        MaterialGetRequest request = new MaterialGetRequest(mediaId);
        VideoGetResponse response = invokeAPI(url, ApiMethod.POST, VideoGetResponse.class, request);
        return response;
    }

    /**
     * 获取永久素材:图文消息素材
     *
     * @param accessToken
     * @param mediaId
     * @return
     */
    public static NewsGetResponse getNews(String accessToken, String mediaId) {
        String url = formatUrl(wechatProperties.getProperty("url.media.getmaterial"), new String[]{accessToken});
        MaterialGetRequest request = new MaterialGetRequest(mediaId);
        NewsGetResponse response = invokeAPI(url, ApiMethod.POST, NewsGetResponse.class, request);
        return response;
    }

    /**
     * 删除永久素材
     *
     * @param accessToken
     * @return
     */
    public static APIResponse deleteMaterial(String accessToken, String mediaId) {
        String url = formatUrl(wechatProperties.getProperty("url.media.deletematerial"), new String[]{accessToken});
        MaterialGetRequest request = new MaterialGetRequest(mediaId);
        APIResponse response = invokeAPI(url, ApiMethod.POST, APIResponse.class, request);
        return response;
    }

    /**
     * 获取素材列表:除图文消息素材外的图片、语音、视频素材
     *
     * @param accessToken
     * @param type
     * @return
     */
    public static MaterialListGetResponse getMaterialList(String accessToken, Mediatype type) {
        String url = formatUrl(wechatProperties.getProperty("url.media.materiallist"), new String[]{accessToken});
        Integer offset = 0;
        Integer count = 20;
        MaterialListRequest request = new MaterialListRequest(type.toString(), offset, count);
        MaterialListGetResponse response = invokeAPI(url, ApiMethod.POST, MaterialListGetResponse.class, request);
        return response;
    }

    /**
     * 获取图文消息素材列表
     *
     * @param accessToken
     * @return
     */
    public static NewsListGetResponse getNewsList(String accessToken) {
        String url = formatUrl(wechatProperties.getProperty("url.media.materiallist"), new String[]{accessToken});
        Integer offset = 0;
        Integer count = 20;
        MaterialListRequest request = new MaterialListRequest(Mediatype.news.toString(), offset, count);
        NewsListGetResponse response = invokeAPI(url, ApiMethod.POST, NewsListGetResponse.class, request);
        return response;
    }

    /**
     * 获取素材总数
     *
     * @param accessToken
     * @return
     */
    public static MaterialCountResponse getMaterialCount(String accessToken) {
        String url = formatUrl(wechatProperties.getProperty("url.media.materialcount"), new String[]{accessToken});
        MaterialCountResponse response = invokeAPI(url, ApiMethod.GET, MaterialCountResponse.class, null);
        return response;
    }


}

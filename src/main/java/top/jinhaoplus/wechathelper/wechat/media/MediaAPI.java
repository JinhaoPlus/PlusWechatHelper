package top.jinhaoplus.wechathelper.wechat.media;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.exception.WechatAPIException;
import top.jinhaoplus.wechathelper.wechat.media.response.MediaAddResponse;

import java.io.File;

public class MediaAPI extends ServiceAPI {

    public static MediaAddResponse addTempMedia(String accessToken, String sourcefilePath, String type) {
        String url = formatUrl(wechatProperties.getProperty("url.media.addtempmedia"), new String[]{accessToken, type});
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
     * 获取临时素材
     *
     * @param accessToken
     * @param mediaId     临时素材ID
     * @return
     */
    public static String getTempMedia(String accessToken, String mediaId) {
        return formatUrl(wechatProperties.getProperty("url.media.gettempmedia"), new String[]{accessToken, mediaId});
    }

    public static void main(String[] args) {
        MediaAPI.addTempMedia("bOe_o9X2VavFnPDt-SzhTl-vzlFhzHTvQQIV77G--zNU_ua1Hfn5s6HUAYNAUaM0vo5eL78MSu0haS54gS5FGr7Skb2zinks4Wj8xWi25kIOQCeAFAGIU", "/Users/jinhaoplus/Desktop/abc.png", "image");

    }
}

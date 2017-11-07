package top.jinhaoplus.wechathelper.wechat.general;

import org.apache.commons.lang3.StringUtils;
import top.jinhaoplus.wechathelper.wechat.api.ApiMethod;
import top.jinhaoplus.wechathelper.wechat.api.ServiceAPI;
import top.jinhaoplus.wechathelper.wechat.general.entity.QRCodeActionInfo;
import top.jinhaoplus.wechathelper.wechat.general.request.QRCodeTicketRequest;
import top.jinhaoplus.wechathelper.wechat.general.request.ShortURLRequest;
import top.jinhaoplus.wechathelper.wechat.general.response.QRCodeTicketResponse;
import top.jinhaoplus.wechathelper.wechat.general.response.ShortURLResponse;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

import java.io.IOException;
import java.util.HashMap;

public class GeneralAPI extends ServiceAPI {

    /**
     * 获取二维码换取票据
     *
     * @param accessToken
     * @return
     */
    public static String getQRCode(String accessToken, QRCodeTicketRequest qrCodeTicketRequest) throws Exception {
        if (qrCodeTicketRequest.getExpire_seconds() == null) qrCodeTicketRequest.setExpire_seconds(2592000);
        if (qrCodeTicketRequest.getAction_name() == null)
            qrCodeTicketRequest.setAction_name(QRCodeTicketRequest.QRCodeActionName.QR_LIMIT_STR_SCENE);
        if (qrCodeTicketRequest.getAction_info() == null)
            qrCodeTicketRequest.setAction_info(
                    new QRCodeActionInfo(
                            new HashMap<String, Object>() {{
                                put("scene_str", "test");
                            }}
                    )
            );
        String url = formatUrl(wechatProperties.getProperty("url.general.qrcodeticket"), new String[]{accessToken});
        QRCodeTicketResponse qrCodeTicketResponse = invokeAPI(url, ApiMethod.POST, QRCodeTicketResponse.class, JsonUtil.bean2str(qrCodeTicketRequest));
        if (!StringUtils.isBlank(qrCodeTicketResponse.getTicket()))
            return formatUrl(wechatProperties.getProperty("url.general.qrcode"), new String[]{qrCodeTicketResponse.getTicket()});
        return null;
    }


    /**
     * 将长URL转换为短链接
     *
     * @param accessToken
     * @param longUrl
     * @return
     */
    public static String getShortUrl(String accessToken, String longUrl) throws IOException {
        String url = formatUrl(wechatProperties.getProperty("url.general.shorturl"), new String[]{accessToken});
        ShortURLRequest request = new ShortURLRequest(longUrl);
        ShortURLResponse response = invokeAPI(url, ApiMethod.POST, ShortURLResponse.class, JsonUtil.bean2str(request));
        return response.getShort_url();
    }
}

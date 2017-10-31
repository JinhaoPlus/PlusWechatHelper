package top.jinhaoplus.wechathelper.wechat.api;

import top.jinhaoplus.wechathelper.wechat.rest.RestTemplateFactory;
import org.springframework.web.client.RestTemplate;

public class WeChatRestClient {

    private WeChatRestClient(){}

    public static RestTemplate getInstance(){
        return RestTemplateFactory.restTemplate(new String[]{"application/json;charset=gbk"});
    }
}

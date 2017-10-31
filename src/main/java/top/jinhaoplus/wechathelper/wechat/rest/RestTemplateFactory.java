package top.jinhaoplus.wechathelper.wechat.rest;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 获取restTemplate操作模板
 */

public class RestTemplateFactory {
    private RestTemplateFactory(){}

    public static RestTemplate restTemplate(String[] headers){
        RestTemplate restTemplate = new RestTemplate();
        //设置StringHttpMessageConverter的字符编码为UTF-8
        StringHttpMessageConverter converter = (StringHttpMessageConverter) restTemplate.getMessageConverters().get(1);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        //设置 Accept 头为application/json
        ClientHttpRequestInterceptor acceptHeaderJson = new AcceptHeaderHttpRequestInterceptor(headers);
        restTemplate.setInterceptors(Collections.singletonList(acceptHeaderJson));

        return restTemplate;
    }

}

/**
 * 设置acceptHeader,如:application/json
 */
class AcceptHeaderHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private final String[] headerValue;

    AcceptHeaderHttpRequestInterceptor(String[] headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
        requestWrapper.getHeaders().setAccept(Arrays.stream(headerValue)
            .map(MediaType::valueOf)
            .collect(Collectors.toList()));

        return execution.execute(requestWrapper, body);
    }

}

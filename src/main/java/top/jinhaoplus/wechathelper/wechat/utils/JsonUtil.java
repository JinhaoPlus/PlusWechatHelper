package top.jinhaoplus.wechathelper.wechat.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by jinhaoplus on 2017/4/27.
 */

/**
 * fastxml.jackson的Json工具类
 */
public class JsonUtil {
    private JsonUtil(){}

    /**
     * json串转bean
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T str2bean(String jsonStr, Class<T> clazz) throws IOException {
        ObjectMapper oMapper = new ObjectMapper();
        T bean = oMapper.readValue(jsonStr, clazz);
        return bean;
    }

    /**
     * bean转json串
     * @param bean
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> String bean2str(T bean) throws IOException {
        ObjectMapper oMapper = new ObjectMapper();

        oMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider) throws IOException, JsonProcessingException {
                paramJsonGenerator.writeString("");
            }
        });

        String jsonStr = oMapper.writeValueAsString(bean);
        return jsonStr;
    }

    /**
     * 将json格式的字符串 放到map中
     * @param jsonStr
     * @return
     */
    public static Map<String, String> parseToMap(String jsonStr){
        JSONObject jsonObj = JSON.parseObject(jsonStr);
        Set<String> jsonKeySet = jsonObj.keySet();
        Map<String, String> resultMap = new HashMap<>();
        Iterator<String> it = jsonKeySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            resultMap.put(key, jsonObj.getString(key));
        }
        return resultMap;
    }

    /**
     * 创建ObjectMapper
     * @return
     */
    public static ObjectMapper getMapper() {
        ObjectMapper oMapper = new ObjectMapper();
        oMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//确定是否遇到未知属性(不映射到属性的属性,并且没有"任何设置者"或处理程序可以处理它)
        oMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);//可以启用允许JSON空字符串值("")绑定到POJO的功能
        return oMapper;
    }



}

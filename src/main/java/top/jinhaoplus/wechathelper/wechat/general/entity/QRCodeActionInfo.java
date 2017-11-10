package top.jinhaoplus.wechathelper.wechat.general.entity;

import top.jinhaoplus.wechathelper.wechat.api.exception.WechatAPIException;

import java.util.Map;

/**
 * 二维码携带参数信息
 */
public class QRCodeActionInfo {
    // 这里的scene map须以scene_id或scene_str为key且只能有一个元素
    private Map<String, Object> scene;

    public Map<String, Object> getScene() {
        return scene;
    }

    public QRCodeActionInfo(Map<String, Object> scene) throws Exception {
        if (scene == null || scene.size() != 1)
            throw new WechatAPIException("[0]二维码携带参数信息构造失败");
        if (!scene.keySet().contains("scene_id") && !scene.keySet().contains("scene_str"))
            throw new WechatAPIException("[1]二维码携带参数信息构造失败");
        this.scene = scene;
    }
}

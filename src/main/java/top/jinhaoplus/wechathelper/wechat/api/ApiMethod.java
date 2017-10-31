package top.jinhaoplus.wechathelper.wechat.api;

public enum ApiMethod {
    GET("GET"), POST("POST");

    private String method;

    ApiMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return method;
    }
}

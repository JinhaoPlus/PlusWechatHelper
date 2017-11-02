package top.jinhaoplus.wechathelper.wechat.media.entity;

public enum Mediatype {
    image("image"),
    voice("voice"),
    video("video"),
    thumb("thumb"),
    news("news");

    private String type;

    Mediatype(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public boolean equals(String type) {
        if (this.type.equals(type))
            return true;
        return false;
    }
}

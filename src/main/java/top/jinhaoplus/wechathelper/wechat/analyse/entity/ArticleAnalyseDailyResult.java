package top.jinhaoplus.wechathelper.wechat.analyse.entity;

public class ArticleAnalyseDailyResult {

    // 数据的日期
    private String ref_date;

    // 图文消息的msgid
    // [注意]这里的msgid实际上是由msgid(图文消息id,这也就是群发接口调用后返回的msg_data_id)和index(消息次序索引)组成
    // 例如12003_3, 其中12003是msgid,即一次群发的消息的id； 3为index,假设该次群发的图文消息共5个文章(因为可能为多图文),3表示5个中的第3个
    private String msgid;

    // 图文消息的标题
    private String title;

    // 图文页(点击群发图文卡片进入的页面)的阅读人数
    private Long int_page_read_user;

    // 图文页的阅读次数
    private Long int_page_read_count;

    // 原文页(点击图文页"阅读原文"进入的页面)的阅读人数,无原文页时此处数据为0
    private Long ori_page_read_user;

    // 原文页的阅读次数
    private Long ori_page_read_count;

    // 分享的人数
    private Long share_user;

    // 分享的次数
    private Long share_count;

    // 收藏的人数
    private Long add_to_fav_user;

    // 收藏的次数
    private Long add_to_fav_count;

    public String getRef_date() {
        return ref_date;
    }

    public void setRef_date(String ref_date) {
        this.ref_date = ref_date;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getInt_page_read_user() {
        return int_page_read_user;
    }

    public void setInt_page_read_user(Long int_page_read_user) {
        this.int_page_read_user = int_page_read_user;
    }

    public Long getInt_page_read_count() {
        return int_page_read_count;
    }

    public void setInt_page_read_count(Long int_page_read_count) {
        this.int_page_read_count = int_page_read_count;
    }

    public Long getOri_page_read_user() {
        return ori_page_read_user;
    }

    public void setOri_page_read_user(Long ori_page_read_user) {
        this.ori_page_read_user = ori_page_read_user;
    }

    public Long getOri_page_read_count() {
        return ori_page_read_count;
    }

    public void setOri_page_read_count(Long ori_page_read_count) {
        this.ori_page_read_count = ori_page_read_count;
    }

    public Long getShare_user() {
        return share_user;
    }

    public void setShare_user(Long share_user) {
        this.share_user = share_user;
    }

    public Long getShare_count() {
        return share_count;
    }

    public void setShare_count(Long share_count) {
        this.share_count = share_count;
    }

    public Long getAdd_to_fav_user() {
        return add_to_fav_user;
    }

    public void setAdd_to_fav_user(Long add_to_fav_user) {
        this.add_to_fav_user = add_to_fav_user;
    }

    public Long getAdd_to_fav_count() {
        return add_to_fav_count;
    }

    public void setAdd_to_fav_count(Long add_to_fav_count) {
        this.add_to_fav_count = add_to_fav_count;
    }
}

package top.jinhaoplus.wechathelper.wechat.media;

import org.junit.Test;
import top.jinhaoplus.wechathelper.wechat.api.response.APIResponse;
import top.jinhaoplus.wechathelper.wechat.basic.BasicAPI;
import top.jinhaoplus.wechathelper.wechat.media.entity.Article;
import top.jinhaoplus.wechathelper.wechat.media.entity.Mediatype;
import top.jinhaoplus.wechathelper.wechat.media.request.NewsAddRequest;
import top.jinhaoplus.wechathelper.wechat.media.request.NewsUpdateRequest;
import top.jinhaoplus.wechathelper.wechat.media.response.*;
import top.jinhaoplus.wechathelper.wechat.utils.JsonUtil;

public class MediaAPITest {

    @Test
    public void addTempMedia() throws Exception {
        MediaAddResponse response = MediaAPI.addTempMedia(BasicAPI.getAccessTokenStr(), "/Users/jinhaoplus/Desktop/ttt.png", Mediatype.thumb);
        System.out.println(response.getMedia_id());
    }

    @Test
    public void getTempMedia() throws Exception {
        MediaAddResponse response = MediaAPI.addTempMedia(BasicAPI.getAccessTokenStr(), "/Users/jinhaoplus/Desktop/abc.png", Mediatype.image);
        System.out.println(response.getMedia_id());
        String url = MediaAPI.getTempMedia(BasicAPI.getAccessTokenStr(), response.getMedia_id());
        System.out.println(url);
    }

    @Test
    public void uploadNews() throws Exception {
        NewsAddRequest request = new NewsAddRequest();
        Article article1 = new Article();
        article1.setTitle("测试标题1");
        article1.setAuthor("测试作者1");
        article1.setContent("测试内容1");
        article1.setContent_source_url("http://www.baidu.com");
        article1.setDigest("测试摘要1");
        article1.setShow_cover_pic(1);
        article1.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3VZfZRamwWgm-vqtMwZVdHM");
        Article article2 = new Article();
        article2.setTitle("测试标题2");
        article2.setAuthor("测试作者2");
        article2.setContent("测试内容2");
        article2.setContent_source_url("http://www.baidu.com");
        article2.setDigest("测试摘要2");
        article2.setShow_cover_pic(1);
        article2.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3VZfZRamwWgm-vqtMwZVdHM");
        Article article3 = new Article();
        article3.setTitle("测试标题3");
        article3.setAuthor("测试作者3");
        article3.setContent("测试内容3");
        article3.setContent_source_url("http://www.baidu.com");
        article3.setDigest("测试摘要3");
        article3.setShow_cover_pic(0);
        article3.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3VZfZRamwWgm-vqtMwZVdHM");
        request.getArticles().add(article1);
        request.getArticles().add(article2);
        request.getArticles().add(article3);
        NewsUploadResponse response = MediaAPI.uploadNews(BasicAPI.getAccessTokenStr(), request);
        System.out.println(JsonUtil.bean2str(request));
        System.out.println(response.getMedia_id());
    }

    @Test
    public void uploadNewsImg() throws Exception {
        UploadImgResponse response = MediaAPI.uploadNewsImg(BasicAPI.getAccessTokenStr(), "/Users/jinhaoplus/Desktop/abc.png");
        System.out.println(response.getUrl());
    }

    @Test
    public void addNews() throws Exception {
        NewsAddRequest request = new NewsAddRequest();
        Article article1 = new Article();
        article1.setTitle("测试标题1");
        article1.setAuthor("测试作者1");
        article1.setContent("测试内容1");
        article1.setContent_source_url("http://www.baidu.com");
        article1.setDigest("测试摘要1");
        article1.setShow_cover_pic(1);
        article1.setThumb_media_id("");
        Article article2 = new Article();
        article2.setTitle("测试标题2");
        article2.setAuthor("测试作者2");
        article2.setContent("测试内容2");
        article2.setContent_source_url("http://www.baidu.com");
        article2.setDigest("测试摘要2");
        article2.setShow_cover_pic(1);
        article2.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3XGCmmuanPsBs_qD1vEt1kk");
        Article article3 = new Article();
        article3.setTitle("测试标题3");
        article3.setAuthor("测试作者3");
        article3.setContent("测试内容3");
        article3.setContent_source_url("http://www.baidu.com");
        article3.setDigest("测试摘要3");
        article3.setShow_cover_pic(0);
        article3.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3XGCmmuanPsBs_qD1vEt1kk");
        request.getArticles().add(article1);
        request.getArticles().add(article2);
        request.getArticles().add(article3);
        NewsAddResponse response = MediaAPI.addNews(BasicAPI.getAccessTokenStr(), request);
        System.out.println(response.getMedia_id());
    }

    @Test
    public void getNewsList() throws Exception {
        NewsListGetResponse response = MediaAPI.getNewsList(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void getMaterialList() throws Exception {
        MaterialListGetResponse response = MediaAPI.getMaterialList(BasicAPI.getAccessTokenStr(), Mediatype.image);
        System.out.println(response);
    }

    @Test
    public void getNews() throws Exception {
        NewsGetResponse response = MediaAPI.getNews(BasicAPI.getAccessTokenStr(), "TfyMrCu3iSoUpqscSAt-3R6voD65VvmaOC3waBLFbn8");
        System.out.println(response);
    }

    @Test
    public void updateNews() throws Exception {
        NewsUpdateRequest request = new NewsUpdateRequest();
        request.setMedia_id("TfyMrCu3iSoUpqscSAt-3Xb-EmFL_UJDC4-Vwc9-RCk");
        request.setIndex(0);
        Article article1 = new Article();
        article1.setTitle("测试标题U");
        article1.setAuthor("测试作者U");
        article1.setContent("测试内容U");
        article1.setContent_source_url("http://www.baidu.com");
        article1.setDigest("测试摘要U");
        article1.setShow_cover_pic(1);
        article1.setThumb_media_id("TfyMrCu3iSoUpqscSAt-3XGCmmuanPsBs_qD1vEt1kk");
        request.setArticles(article1);
        MediaAPI.updateNews(BasicAPI.getAccessTokenStr(), request);
    }

    @Test
    public void addMaterial() throws Exception {
        MaterialAddResponse response = MediaAPI.addMaterial(BasicAPI.getAccessTokenStr(), "/Users/jinhaoplus/Desktop/abc.png", Mediatype.thumb, null);
        System.out.println(response.getMedia_id());
        System.out.println(response.getUrl());
    }

    @Test
    public void getMaterialCount() throws Exception {
        MaterialCountResponse response = MediaAPI.getMaterialCount(BasicAPI.getAccessTokenStr());
        System.out.println(response);
    }

    @Test
    public void deleteMaterial() throws Exception {
        APIResponse response = MediaAPI.deleteMaterial(BasicAPI.getAccessTokenStr(), "TfyMrCu3iSoUpqscSAt-3RSQy_BTq0vys27zqhuylko");
        System.out.println(response);
    }
}
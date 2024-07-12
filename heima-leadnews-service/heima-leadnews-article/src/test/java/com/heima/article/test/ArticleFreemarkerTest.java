/**
 * z作者:无言
 * 版本:1.0
 * 2024-7-9 16:52
 */


package com.heima.article.test;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.article.ArticleApplication;
import com.heima.article.mapper.ApArticleContentMapper;
import com.heima.article.service.ApArticleService;
import com.heima.file.service.FileStorageService;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.article.pojos.ApArticleContent;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = ArticleApplication.class)
@RunWith(SpringRunner.class)
public class ArticleFreemarkerTest {
    @Autowired
    private ApArticleContentMapper apArticleContentMapper;
    @Autowired
    private Configuration configuration;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private ApArticleService apArticleService;

//该类实现的是将文章内容生成html文件以后再上传到minio上，并且将minio上对应的地址加载到article表中
/*    @Test
    public void createStaticUrlTest() throws IOException, TemplateException {
//        已知文章的id
//        1、获取文章内容
        ApArticleContent apArticleContent = apArticleContentMapper.selectOne(Wrappers.<ApArticleContent>lambdaQuery().eq(ApArticleContent::getArticleId, 1302862387124125698L));
        if (apArticleContent != null && StringUtils.isBlank(apArticleContent.getContent())) {
            //        2、文章内容通过freemarker生成html文件
            Template template = configuration.getTemplate("article.ftl");
//            数据模型
            HashMap<String, Object> content = new HashMap<>();
            content.put("content", JSONArray.parseArray(apArticleContent.getContent()));
            StringWriter out = new StringWriter();
            template.process(content,out);
//        3、把html文件上传到minio中
            InputStream in = new ByteArrayInputStream(out.toString().getBytes());
            String path = fileStorageService.uploadHtmlFile("",apArticleContent.getArticleId()+".html",in);


//        修改ap_article表，保存static-url字段
            apArticleService.update(Wrappers.<ApArticle>lambdaUpdate().eq(ApArticle::getId,apArticleContent.getArticleId()).
                    set(ApArticle::getStaticUrl,path));
        }


    }*/
}

/**
 * z作者:无言
 * 版本:1.0
 * 2024-7-9 15:07
 */


package com.heima.minio.test;

import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {
    @Autowired
    private FileStorageService fileStorageService;
//    把list.html文件上传到minio中，并且可以在浏览器中访问

    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Emain\\resources\\templates\\monitor\\job\\add.html");
        String path = fileStorageService.uploadHtmlFile("", "list.html", fileInputStream);
        System.out.println(path);
    }
















    /**
     * 把list.html文件上传到minio中，并且可以在浏览器中访问
     * @param args
     */
public static void main(String[] args) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        //先拿到文件
        FileInputStream fileInputStream = new FileInputStream("e:\\plugins\\js\\index.js");
        //1.获取minio的链接信息 创建一个minio的客户端
        MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://192.168.58.125:9000").build();

        //2.上传
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .object("plugins/js/index.js") //文件名称
                .contentType("text/js") //文件类型
                .bucket("leadnews")//桶名称 与minio中创建的桶名称一致
                .stream(fileInputStream, fileInputStream.available(), -1).build();
        minioClient.putObject(putObjectArgs);

        //访问路径
        System.out.println("http://192.168.58.125:9000/leadnews/list.html");
    }

}

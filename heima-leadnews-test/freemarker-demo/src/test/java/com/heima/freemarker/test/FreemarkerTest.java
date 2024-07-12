/**
 * z作者:无言
 * 版本:1.0
 * 2024-7-9 13:52
 */


package com.heima.freemarker.test;

import com.heima.freemarker.entity.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@SpringBootTest(classes = FreemarkerTest.class)
@RunWith(SpringRunner.class)
public class FreemarkerTest {
    @Autowired
    private Configuration configuration;

    @Test
    public void test() throws IOException, TemplateException {
        Template template = configuration.getTemplate("02-list.ftl");

        /**
         *合成方法
         *
         * 两个参数
         * 第一个参数：模型数据
         * 第二个参数：输出流
         */
        template.process(getDates(),new FileWriter(new File("d:/test.html")));

    }

    private Map getDates() {

        Map<Spring,Object> map = new HashMap<>();

        //------------------------------------
        Student stu1 = new Student();
        stu1.setName("小强");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());

        //小红对象模型数据
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);

        //将两个对象模型数据存放到List集合中
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        //向model中存放List集合数据



        return map;
    }
}

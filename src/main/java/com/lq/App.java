package com.lq;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan("com")
@MapperScan("com.mapper")
public class App 
{

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() {
        System.out.println("开始配置数据分页插件");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        //配置mysql数据库的方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;

    }
    public static void main( String[] args )
    {


        SpringApplication.run(App.class,args);
    }
}

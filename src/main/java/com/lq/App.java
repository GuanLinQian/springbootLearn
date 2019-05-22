package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan("com")
public class App 
{
    public static void main( String[] args )
    {


        SpringApplication.run(App.class,args);
    }
}

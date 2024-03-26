package com.circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication
@EnableScheduling
public class CircleApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CircleApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  创业圈启动成功 ");
    }
}

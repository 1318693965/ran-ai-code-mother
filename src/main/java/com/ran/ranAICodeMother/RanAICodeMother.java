package com.ran.ranAICodeMother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiaozhi
 * @date 2025/7/28
 */
@SpringBootApplication
@MapperScan("com.ran.ranAICodeMother.mapper")
@EnableScheduling
@EnableAsync
public class RanAICodeMother {
    public static void main(String[] args)
    {
        SpringApplication.run(RanAICodeMother.class, args);
    }
}
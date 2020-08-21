package com.dreamchaser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//当有多个数据源时就得这样设置
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.dreamchaser.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

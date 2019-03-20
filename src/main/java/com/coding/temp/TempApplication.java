package com.coding.temp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangyongwei
 */
@SpringBootApplication
@MapperScan("com.coding.temp.dao")
/**
 * 事务配置
 * @author Evan
 */
@EnableTransactionManagement
public class TempApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempApplication.class, args);
    }

}

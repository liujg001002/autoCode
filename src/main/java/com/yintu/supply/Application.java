package com.yintu.supply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

// SpringBoot默认会自动配置数据库，如果业务不需要，就要手动禁用数据库自动配置
@SpringBootApplication
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableAsync
@PropertySource("classpath:application.yml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

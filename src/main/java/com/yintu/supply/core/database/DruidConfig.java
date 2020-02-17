package com.yintu.supply.core.database;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "com.yintu.supply.dao", sqlSessionFactoryRef = "sessionFactory")
public class DruidConfig {
	
    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSource primaryDataSource(){
        return new DruidDataSource();
    }
    
	@Bean(name = "secondDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db2")
	public DataSource secondDataSource() {
		return new DruidDataSource();
	}
	
	@Bean(name = "dataSource")
    public DataSource dataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource, @Qualifier("secondDataSource") DataSource secondDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource);
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(DBTypeEnum.DB_ONE, primaryDataSource);
        dsMap.put(DBTypeEnum.DB_TWO, secondDataSource);
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

	@Bean(name = "sessionFactory")
	public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*/*.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
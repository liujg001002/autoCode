package com.yintu.supply.core.configurer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.yintu.supply.core.constant.ProjectConstant;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * Mybatis翻页插件配置和XML文件配置等
 * 
 * @author kwah 2018年10月12日
 */
@Configuration
public class MybatisConfigurer {

	/**
	 * <p>
	 * <code>@Configuration</code>表示该文件是一个配置文件<br>
	 * <code>@Bean</code>表示该方法是一个传统xml配置文件中的<code><Bean id=\"\"></code><code></Bean></code><br>
	 * 其中factory.setTypeAliasesPackage("com.supply.demo.model")表示项目中model的存储路径；<br>
	 * factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));表示mapper.xml存储路径；<br>
	 * mapperScannerConfigurer.setBasePackage("com.yintu.dtll.dao");表示dao层的存储路径
	 * </p>
	 *
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		// 表示项目中model的存储路径
		factory.setTypeAliasesPackage(ProjectConstant.MODEL_PACKAGE);
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 表示mapper.xml存储路径；
		factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return factory.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		// 表示dao层的存储路径
		mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE);
		return mapperScannerConfigurer;
	}
}

package com.lishuangqi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = GpdbDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "gpdbSqlSessionFactory")
public class GpdbDataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(GpdbDataSourceConfig.class);
    // 精确到 gpdb 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.lishuangqi.gpdb.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/gpdb/*.xml";

    @Value("${gpdb.datasource.url}")
    private String url;

    @Value("${gpdb.datasource.username}")
    private String user;

    @Value("${gpdb.datasource.password}")
    private String password;

    @Value("${gpdb.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "gpdbDataSource")
    @Primary
    public DataSource gpdbDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "gpdbTransactionManager")
    @Primary
    public DataSourceTransactionManager gpdbTransactionManager() {
        return new DataSourceTransactionManager(gpdbDataSource());
    }

    @Bean(name = "gpdbSqlSessionFactory")
    @Primary
    public SqlSessionFactory gpdbSqlSessionFactory(@Qualifier("gpdbDataSource") DataSource gpdbDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(gpdbDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
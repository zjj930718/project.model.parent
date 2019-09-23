package com.info.component;

import com.alibaba.druid.pool.DruidDataSource;
import com.info.constant.DataSourceType;
import com.info.entity.DataSourceInfo;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Properties;

public class JdbcTemplatePool {

    private static Properties validLoginInfo(DataSourceInfo dataSourceInfo){
        Properties properties = new Properties();
        if (dataSourceInfo == null){
            throw new IllegalArgumentException("dataSourceInfo不能为空");
        }
        if(dataSourceInfo.getSourceType() == null){
            throw new IllegalArgumentException("数据库类型不能为空");
        }

        String driveClass = DataSourceType.MYSQL.getClassName();
        if (dataSourceInfo.getSourceType().equalsIgnoreCase(DataSourceType.ORACLE.name())){
            driveClass = DataSourceType.ORACLE.getClassName();
        }else if(dataSourceInfo.getSourceType().equalsIgnoreCase(DataSourceType.POSTGRESQL.name())){
            driveClass = DataSourceType.POSTGRESQL.getClassName();
        }
        properties.setProperty("driverClass",driveClass);
        if(dataSourceInfo.getSourceIp() == null
                || dataSourceInfo.getSourcePort() == null
                || dataSourceInfo.getSourceSchema() == null){
            throw new IllegalArgumentException("属性url不能为空");
        }
        String url = "jdbc:mysql://"+dataSourceInfo.getSourceIp()+":"+dataSourceInfo.getSourcePort()+"/"+dataSourceInfo.getSourceSchema()+"?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
        if (dataSourceInfo.getSourceType().equalsIgnoreCase(DataSourceType.ORACLE.name())){
            url = "jdbc:oracle:thin:@"+dataSourceInfo.getSourceIp()+":"+dataSourceInfo.getSourcePort()+":"+dataSourceInfo.getSourceSchema();
        }else if(dataSourceInfo.getSourceType().equalsIgnoreCase(DataSourceType.POSTGRESQL.name())){
            url = "jdbc:postgresql://"+dataSourceInfo.getSourceIp()+":"+dataSourceInfo.getSourcePort()+"/"+dataSourceInfo.getSourceSchema();
        }
        properties.setProperty("url",url);
        if(dataSourceInfo.getSourceUser() == null){
            throw new IllegalArgumentException("属性username不能为空");
        }
        properties.setProperty("username",dataSourceInfo.getSourceUser());
        if(dataSourceInfo.getSourcePassword() == null){
            throw new IllegalArgumentException("属性password不能为空");
        }
        properties.setProperty("password",dataSourceInfo.getSourcePassword());
        properties.setProperty("initialSize","8");
        properties.setProperty("maxActive","100");
        properties.setProperty("minIdle","5");
        return properties;
    }


    public static NamedParameterJdbcTemplate createJdbcTemplate(DruidDataSource t){
        return new NamedParameterJdbcTemplate(t);
    }

    public static DruidDataSource createDataSource(DataSourceInfo dataSourceInfo){
        Properties p = validLoginInfo(dataSourceInfo);
        DruidDataSource ds =new DruidDataSource();
        ds.setDriverClassName(p.getProperty("driverClass"));
        ds.setUrl(p.getProperty("url"));
        ds.setUsername(p.getProperty("username"));
        ds.setPassword(p.getProperty("password"));
        ds.configFromPropety(p);
        return ds;
    }
}

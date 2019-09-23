package com.info.constant;

/**
 * Created by linzhipeng on 2018/3/8.
 */
public enum DataSourceType {
    MYSQL("com.mysql.jdbc.Driver"),ORACLE("oracle.jdbc.driver.OracleDriver"),POSTGRESQL("org.postgresql.Driver");

    private String className;

    DataSourceType(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}

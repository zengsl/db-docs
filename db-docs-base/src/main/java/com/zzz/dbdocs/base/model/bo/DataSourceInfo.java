package com.zzz.dbdocs.base.model.bo;

import com.zzz.dbdocs.base.enums.DbType;
import lombok.Data;

import javax.sql.DataSource;
/**
 * 数据源信息
 * @author zengsl
 */
@Data
public class DataSourceInfo {

    /**
     * {@link DbType#getValue()}
     */
    private String dbType;

    /**
     * Fully qualified name of the DataSource implementation to use. By default, a
     * connection pool implementation is auto-detected from the classpath.
     */
    private Class<? extends DataSource> type;

    /**
     * Fully qualified name of the JDBC driver. Auto-detected based on the URL by default.
     */
    private String driverClassName;

    /**
     * JDBC URL of the database.
     */
    private String url;

    /**
     * Login username of the database.
     */
    private String username;

    /**
     * Login password of the database.
     */
    private String password;
}

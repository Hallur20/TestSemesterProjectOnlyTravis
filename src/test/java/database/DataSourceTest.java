/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author hallur
 */
public class DataSourceTest {
    
    private MysqlDataSource dataSource = new MysqlDataSource();

    public DataSourceTest() {
        try {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("LESdbTest?allowPublicKeyRetrieval=true&useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("123");
            dataSource.setUseSSL(false);
            dataSource.setAllowMultiQueries(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}

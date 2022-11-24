package org.example.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;
    static {
        //加载工具类时，读配置文件，赋值dataSource连接池对象
        //类路径里的文件读取不能使用new File 使用类加载器
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //借助properties集合
        Properties prop = new Properties();
        try {
            prop.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }
    //获取连接池里的某个连接
    public static Connection getCon() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables.getMessage());
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection con) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

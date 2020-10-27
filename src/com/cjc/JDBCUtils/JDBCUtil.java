package com.cjc.JDBCUtils;

import com.cjc.JavaBean.Categories;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtil {

private JDBCUtil(){}

    //获取连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://192.168.226.240:1433;DatabaseName=northwind", "sa", "123456a@");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭资源
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //查询
    public  static ArrayList<Categories> Retrieve() throws SQLException {
        ArrayList<Categories> arrayList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        try {
            resultSet = statement.executeQuery("select CategoryID,CategoryName,Description from categories");
            while (resultSet.next()){
                arrayList.add(new Categories(
                        resultSet.getString("CategoryID"),
                        resultSet.getString("CategoryName"),
                        resultSet.getString("Description")));
            }
            return arrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet);
            JDBCUtil.close(statement);
            JDBCUtil.close(connection);
        }
        return null;
    }

    //删除
    public static void Delete (String Id) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from categories where CategoryID = ?");
        ps.setString(1,Id);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    //增加
    public static void Create(String categoryName,String description) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into categories (CategoryName,Description) values(?,?)");
        ps.setString(1,categoryName);
        ps.setString(2,description);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    //修改
    public static void Update(String categoryName,String description,String CategoryID) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("update Categories set CategoryName = ?,Description = ? where CategoryID = ?");
        ps.setString(1, categoryName);
        ps.setString(2, description);
        ps.setString(3, CategoryID);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
}

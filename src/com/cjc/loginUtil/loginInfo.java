package com.cjc.loginUtil;

import java.sql.*;

public class loginInfo {
    private String driverName;
    private String dbURl;
    private String userName;
    private String password;

    public loginInfo() {
    }

    public loginInfo(String driverName, String dbURl, String userName, String password) {
        this.driverName = driverName;
        this.dbURl = dbURl;
        this.userName = userName;
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDbURl() {
        return dbURl;
    }

    public void setDbURl(String dbURl) {
        this.dbURl = dbURl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //获取连接
    public Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName(driverName);
            return DriverManager.getConnection(dbURl,userName,password);
    }

    //验证用户名密码是否正确
    public boolean message(String userName,String password) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from t_user where uName = ? and uPwd = ?");
        ps.setString(1,userName);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}

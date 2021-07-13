package com.iflybank.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    //第一步：设置驱动为静态常量
    public static final String DRIVER="com.mysql.jdbc.Driver";

    public static void main(String[] args) throws SQLException {
        //第二步：注册驱动类，用到Class.forName，原理是通过类名，把类装在到虚拟机中。Class中的C要大写
        try{
            System.out.println(Class.forName(DRIVER));
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        //第三步，建立连接
        //Connection conn = DriverManager.getConnection("jdbc:mysql://172.30.8.129:3306/datacollector", "iflytek", "eY30nXPr0iSX");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://172.31.200.107:9306/test", "atpcore", "1qaz@WSX");
        /*
        /*
         * 注意：* 1.这里Connection和DriverManager都需要导包，不要到mysql包，最好导SQL包，以后方便兼容；
         * 2.会抛出异常：throws SQLException，此时为了演示，先抛出；
         * 3.getConnection的参数未来会被配置到配置文件中，将来不会像我上面那样写的，尤其是第一个参数（url）;
         * 4.第一参数中的t_employee，是具体数据库的名字，不是表名。          * 5.创建连接时需要用户名和密码；
         */

        //第四步：创建statementd对象和执行语句
        Statement stm = conn.createStatement();// 需导包：import java.sql.Statement

        //第五步：执行，返回结果集对象
        //ResultSet rs = stm.executeQuery("select id,`name` from t_collect_farmer limit 2");
        ResultSet rs = stm.executeQuery("select * from userinfo");
        /*
         * 注意：         * 1.ResultSet需要导包：import java.sql.ResultSet;
         * 2.executeQuery()方法的参数是String sql;
         */

        //第六步：处理
        while(rs.next()){
            System.out.println(rs.getInt("id")+"\t");
            System.out.println(rs.getString("name")+"\t");
            /*
             * 注意： * 1.它是一列一列取的。比如id在第一列，name在第二列，取的时候可以把id和name换成1,2
             * 但是，最好别这样做，防止数据库列数有变动，就糟糕了；
             *  2.getInt、getString......取的时候，数据类型要对上；
             * 3.id、name、age....大小写无所谓
             */
        }

        //第7步：释放资源
        try{
            rs.close();
            stm.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}

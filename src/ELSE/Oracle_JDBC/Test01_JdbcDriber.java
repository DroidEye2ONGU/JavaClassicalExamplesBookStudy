package ELSE.Oracle_JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test01_JdbcDriber {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";//固定格式@IP:端口:服务名
    private static final String user = "briup";
    private static final String password = "briup";


    public static void insertValueInStatment() throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();

        try {
            String sql = "INSERT INTO student VALUES(002,'老张',90)";
           /* boolean isOK = statement.execute(sql);
            String printStatement = isOK ? "插入成功" : "插入失败";
            System.out.println(printStatement);*/

            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }

            try {
                conn.close();
            } catch (Exception e) {
            }

        }

    }

    public static void insertValueInPS() throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO student VALUES(001,'老王',100)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public static void insertDateTime(int id) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE student SET ADDTIME=? where ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        java.util.Date utilDate=new java.util.Date();//进行类型转换，由util类型的date转化为sql类型的

        ps.setDate(1, new java.sql.Date(utilDate.getTime()));
        ps.setInt(2, id);

        System.out.println(ps.executeUpdate());

        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        //Class.forName(DBDRIVER);
        //Connection connection = DriverManager.getConnection(url, user, password);

       /* insertValueInStatment();
        insertValueInPS();*/
       insertDateTime(1);
    }
}

package JDBC;

import java.sql.*;

public class preP {
    static Connection con;
    static ResultSet res;
    static PreparedStatement sql;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Main"
            ,"root","root");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String args[]){
        preP p=new preP();
        con=p.getConnection();
        try {
            sql=con.prepareStatement("select * from student where id=?");
            sql.setInt(1,1);
            res=sql.executeQuery();
            while(res.next()){
                System.out.println(res.getString("name"));
            }
        //    sql.executeUpdate("delete from student where birthday > '2010-01-01'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

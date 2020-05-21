package JDBC;
import java.sql.*;
public class test {
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/Main","root","root");
            System.out.println("数据库连接成功");
            Statement sql=con.createStatement();
//          ResultSet res=sql.executeQuery("select * from student where name='dwad'");
//            sql.execute("create table student(\n" +
//                    "id int primary key ,\n" +
//                    "name varchar(10) not null ,\n" +
//                    "sex varchar(2) default '男',\n" +
//                    "birthday date)");
            int temp=0;
            long begin=System.currentTimeMillis();
            for (int i = 0; i <1; i++) {
                StringBuffer b=new StringBuffer();
                b.append("insert into student2 values");
                for (int j = 0; j < 1000000; j++) {    //com.mysql.cj.jdbc.exceptions.PacketTooBigException
                    b.append(" ("+temp+",'temp','m','1990-01-01'),");
                    temp++;
                }
                b.append(" ("+temp+",'temp','m','1990-01-01')");
                temp++;
                String str=b.toString();
                sql.executeUpdate(str);
           }
//            while(res.next()){
//                System.out.println(res.getString("name"));
//            }
            long end=System.currentTimeMillis();
            System.out.println("添加"+temp+"条数据");
            System.out.println(end-begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
    public static void main(String args[]){
        test t =new test();
        Connection c=t.getConnection();
        System.out.println(c);
    }
}

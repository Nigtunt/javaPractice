package Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: YHQ
 * @Date: 2019/12/24 12:43
 */
@JDBCConfig(ip = "127.0.0.1", database = "testweb",encoding = "utf-8"
        ,loginName = "root",password = "root")
public class DBUtil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String loginname = config.loginName();
        String password = config.password();
        String encoding = config.encoding();
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        System.out.println(url);
        return null;
    }

    public static void main(String args[]) throws Exception{
        Connection con = getConnection();
        System.out.println(con);
    }
}

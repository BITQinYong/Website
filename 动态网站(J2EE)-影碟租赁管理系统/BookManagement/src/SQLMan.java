

import java.sql.Connection;
import java.sql.DriverManager;

public final class SQLMan {
    private static final String DB_url = "jdbc:mysql://10.62.52.55:3306/BookManagement?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_username = "qy";
    private static final String DB_password = "123456";
    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(
                        DB_url,
                        DB_username,
                        DB_password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}

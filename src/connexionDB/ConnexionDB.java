package connexionDB;

import com.mysql.jdbc.Connection;
import constant.Constant;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

    public static Connection getMysqlConnexion(){
        Connection connection = null;
        try {
            String url = "jdbc:mysql://" + Constant.HOST + ":" + Constant.PORT + "/" + Constant.DB_NAME;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, Constant.USER_NAME, Constant.PASS_WORD);
        }  catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println(classNotFoundException.getMessage());
        }
        return  connection;
    }
}

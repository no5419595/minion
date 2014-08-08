import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection{
    String userName;
    String password;

    String serverName;
    String portNumber;

    String dbms;
    String dbName;

    public static void main(String[] argv) throws SQLException{

        DBconnection d= new DBconnection("grace.kim", "xey-pim3","1.1.7.175","3306","mysql","Viper2");
        Connection c= d.getConnection();

        String sqlText = "use Viper2;";
        String date="2014-07-07";

        Statement sql = c.createStatement();
        try {
            sql.execute(sqlText);
            String resultString = null;

            //query users created on 2014-07-07
            sqlText = "select emailAddress from users where createDate='?';";
            sqlText = sqlText.replace("?", date);

            ResultSet rs = sql.executeQuery(sqlText);

            while (rs.next()) {
                resultString = rs.getString("emailAddress");
                System.out.println(resultString);
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            if (sql != null) { sql.close(); }
        }
        System.out.println("===================================================");

        //query advertisers
        int advUserTypeId = 2;
        sqlText = "select userID, emailAddress from users where userType =?;";

        //try with resources
        try (PreparedStatement ps= c.prepareStatement(sqlText.replace("?",Integer.toString(advUserTypeId)))) {
            ResultSet rs=  ps.executeQuery();
            int userId= 0;
            String userEmailAddress=null;
            while(rs.next()){
                userId = rs.getInt("userID");
                userEmailAddress = rs.getString("emailAddress");

                System.out.println(userId + " : " + userEmailAddress);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public DBconnection(String userName, String password, String serverName, String portNumber, String dbms, String dbName) {
        this.userName=userName;
        this.password= password;
        this.serverName= serverName;
        this.portNumber= portNumber;
        this.dbms= dbms;
        this.dbName=dbName;
    }

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        //register driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
            "jdbc:" + this.dbms + "://" +
            this.serverName +
            ":" + this.portNumber + "/",
            connectionProps);
        }
         System.out.println("Connected to database");
         return conn;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordpress;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;



public class Wordpress extends User {
    
    static final String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL_DB = "jdbc:mysql://localhost:3306/wordpress?useSSL=false";
    private PreparedStatement preparedStatement = null;
    static Connection myConn=null;
    private Statement statement = null;

    //connecting to the local DB
    /*
    static Connection ConnectDB() {
        try {
            Class.forName(DRIVER);
           Connection Conn = DriverManager.getConnection(URL_DB,"root","student");
            myConn=Conn;
            return Conn;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
    */
    public Connection ConnectDB() {
            try{Class.forName(DRIVER);
            myConn = (Connection) DriverManager.getConnection(URL_DB,"root","student"); 
            this.statement = myConn.createStatement();
            newTable("CREATE TABLE IF NOT EXISTS user (iduser int primary key auto_increment, "
                    + "last_name varchar(50) not null, "
                    + "first_name varchar(50) not null, "
                    + "username varchar(50) not null, "
                    + "password varchar(50) not null, "
                    + "email varchar(50) not null)");
            newTable("CREATE TABLE IF NOT EXISTS publish (id_publish int primary key auto_increment, "
                    + "id_user int not null, "
                    + "publish_name varchar(50) not null, "
                    + "publish_text longtext not null, "
                    + "publish_date datetime not null, "
                    + "views int)");
            newTable("CREATE TABLE IF NOT EXISTS draft (id_draft int primary key auto_increment, "
                    + "id_user int not null, "
                    + "draft_name varchar(50) not null, "
                    + "draft_text longtext not null, "
                    + "saved_date datetime not null)");
            return myConn;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
    }
    
     public void newTable (String script) throws SQLException{
            int resultSet = statement.executeUpdate(script);        
    }
    
    //method for creating a new user and updating the user DB
    public static void newUser(String last_name, String first_name, String username, String password, String email) throws SQLException {
       
        try {
            String query = " insert into user (last_name, first_name, username, password, email)" + " values (? , ?, ?, ?, ?)";
            PreparedStatement preparedStmt = (PreparedStatement) myConn.prepareStatement(query);
            preparedStmt.setString(1, last_name);
            preparedStmt.setString(2, first_name);
            preparedStmt.setString(3, username);
            preparedStmt.setString(4, password);
            preparedStmt.setString(5, email);
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Searching a user in local DB.Return true if user found, false if not
    public static boolean searchUser(Connection conn,String user) {
        System.out.println(conn);
        try {
            Statement myStmt = conn.createStatement();
            //selecting all the users from user table by username attribute
            ResultSet myRs = myStmt.executeQuery("select username from user");
            while (myRs.next()) {
                if (myRs.getString("username").equals(user)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //public static insert
    public static void main(String[] args) throws SQLException {
        
    }

}

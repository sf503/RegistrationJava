package Gym_Sugaraa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Gym_Database {
    
    public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String dbname = "gym_sugaraa";
    public final static String DATABASE_URL = "jdbc:mysql://localhost/"+dbname+"?useUnicode = yes&characterEncoding=UTF-8"; 

    public static Connection connect(){
    
        Connection connection=null;
        try 
        {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,"root","123");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Амжилтгүй боллоо.");
        }
        
        return connection;
    }
    
    public static ResultSet runQuery(String query){
    
        Connection connection = connect();
        Statement statement;
        ResultSet result = null;
        
        try 
        {
            statement = connection.createStatement();
            if( query.toLowerCase().startsWith("update") ||
                query.toLowerCase().startsWith("insert") ||
                query.toLowerCase().startsWith("delete"))
            {    
                statement.executeUpdate(query);
            }
            else
            {
                result = statement.executeQuery(query);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Таны мэдээлэл алдаатай байна.");
        }
        return  result;
    }
}

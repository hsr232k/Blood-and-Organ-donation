package DB_operations;
/*  --This class is to establish connection between our Database and
      Java File--   
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connect {
    private static Connection connection;
    public static Connection getconnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sample1", "hsr","gorillaa");        
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("  "+ex);
        }
        return connection;
    }  
}

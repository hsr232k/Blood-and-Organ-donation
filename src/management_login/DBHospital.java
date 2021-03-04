package management_login;

/*  -- This class is to store the data after validation, provided by the
       management during their account creation --
*/

import DB_operations.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHospital
{   
    public static String tablecreate(String hospitalid,String userid,String password)
    {   
        try
        {
           Connection con=connect.getconnection();
           String query="insert into hospitaltable values(?,?,?)";
           PreparedStatement p=con.prepareStatement(query);
           p.setString(1,hospitalid);
           p.setString(2,userid);
           p.setString(3,password);
           int res=p.executeUpdate();
           con.setAutoCommit(true);
           con.close();
           return "SUCCESS";
        }
       catch(SQLException e)
       {
           System.out.println("--->"+e);
           return "UNSUCCESS";
       }
    }
}

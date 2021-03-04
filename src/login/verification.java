package login;

/*  -- This class is to verify the user's credentials provided during 
       their login --
*/

import DB_operations.connect;
import java.sql.*;


public class verification {
        public static String verify(String Uname,String pass)
        {
            if(Uname.isEmpty()||pass.isEmpty())  
            {
                return "PLEASE FILL EVERY FIELD";
            }
            int flag=0;
            String password="";
            try
            {
                Connection connection=connect.getconnection();
                String query="select * from blood_donar where user_id=?";
                PreparedStatement ps=connection.prepareStatement(query);
                ps.setString(1, Uname);

                ResultSet r=ps.executeQuery();
                while(r.next()){
                    flag=1;
                    password=r.getString("password");
            }
            connection.setAutoCommit(true);
            connection.close();

            if(flag ==1)
            {
                if(pass.equals(password))
                {
                    return "SUCCESS";
                }else{
                    return "PASSWORD DOESN'T MATCH";
                }
            }else 
            {
                return "ACCOUNT DOES NOT EXISTS";

            }


            }
            catch(Exception e)
            {
                System.out.print("--------->"+e);
                return"FAILED";
            }
    }
    
}

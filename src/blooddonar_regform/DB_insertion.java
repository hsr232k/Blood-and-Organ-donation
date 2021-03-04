package blooddonar_regform;
/*  -- This class is to insert the credentials into Database, which is provided 
       by the users during their account creation --
*/
import DB_operations.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DB_insertion {
    public static DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    public static Calendar cal=Calendar.getInstance();
    public String insertion(String name,String UId,String pass,int age,int weight,String gender,String bgroup,String district,String address,String phno,String altphno,String email,String pincode)
    {
        String current_date;
        current_date=dateFormat.format(cal.getTime());  
        long L_phno=Long.parseLong(phno),L_altphno=Long.parseLong(altphno);
        try
            {
            Connection connection=connect.getconnection();
            String query="insert into blood_donar values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, UId);
            ps.setString(3, pass);
            ps.setInt(4, age);
            ps.setInt(5, weight);
            ps.setString(6, gender);
            ps.setString(7, bgroup);
            ps.setString(8, district);
            ps.setString(9, address);
            ps.setLong(10, L_phno);
            ps.setLong(11, L_altphno);
            ps.setString(12, email);
            ps.setString(13,pincode);
            ps.setString(14, current_date);
            int result=ps.executeUpdate();
            connection.setAutoCommit(true);
            connection.close();           
            return "SUCCESSFULLY REGISTERED";
            }
            catch(SQLException e)
            {
                System.out.print("--------->"+e);
                return "USER ID OR PHONE NUMBER ALREADY EXISTS";
            }
    } 
}
    

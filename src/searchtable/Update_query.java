package searchtable;

/*  -- This class is to update the user's status in the Database --

*/

import DB_operations.connect;
import java.sql.*;


public class Update_query {
    String result_date;
    String get_contact;
    public void update(String result_date,String get_contact) throws SQLException{
        this.result_date=result_date;
        this.get_contact=get_contact;
        Connection c=connect.getconnection();
        String query="update blood_donar set date=? where phno=?" ;
        PreparedStatement ps=c.prepareStatement(query);
        ps.setString(1, result_date);
        ps.setString(2, get_contact);
        int rs=ps.executeUpdate();
        c.close();
    }
}

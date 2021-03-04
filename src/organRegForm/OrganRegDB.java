package organRegForm;

/*  -- This class is to store the organ donor's data into the Database --

*/

import DB_operations.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrganRegDB{
  
    public String insertValues(String dfname, String dlname, String gfname, String glname, String dphno, String daltphno, String gphno, String mailid, String address, String authorise, String gender, String bloodgrp, String date, String month, String year, boolean all, boolean heart, boolean liver, boolean eyes, boolean lungs, boolean kidneys,String cdate)throws Exception {
        try{
            
            Operations op=new Operations();
            Connection conn=connect.getconnection();
            String query="insert into organreg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, dfname);
            ps.setString(2, dlname);
            ps.setString(3, gender);
            ps.setString(4, date);
            ps.setString(5, month);
            ps.setString(6, year);
            ps.setString(7, bloodgrp);
            ps.setString(8, address);
            ps.setString(9, dphno);
            ps.setString(10, daltphno);
            ps.setString(11, mailid);
            ps.setString(12, gfname);
            ps.setString(13, glname);
            ps.setString(14, gphno);
            ps.setString(15, op.btos(heart));
            ps.setString(16, op.btos(lungs));
            ps.setString(17, op.btos(liver));
            ps.setString(18, op.btos(kidneys));
            ps.setString(19, op.btos(eyes));
            ps.setString(20, op.btos(all));
            ps.setString(21, authorise);
            ps.setString(22, cdate);
            int result=ps.executeUpdate();
            conn.setAutoCommit(true);
            conn.close();
        }
        catch(Exception e){
            System.out.println("Database Fail:"+e);
            return "THE DONOR PHONE NUMBER ALREADY EXISTS";
        }
        return "REGISTERED SUCCESSFULLY";
    
    }
}

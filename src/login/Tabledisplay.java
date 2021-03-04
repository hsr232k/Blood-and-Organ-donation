package login;

/*  -- This class is to display the data about the other blood donars
       to a blood donor --
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import DB_operations.connect;

public class Tabledisplay {
    JFrame frame=new JFrame();
    String get_pincode,get_grp,current_date;
    int count=0;
    public void  display_table(String get_pincode,String get_grp) throws SQLException{            
        this.get_pincode=get_pincode;
        this.get_grp=get_grp;
        String column[]={"NAME","BLOOD GROUP","EMAIL","CONTACT","ALTERNATE_CONTACT","ADDRESS"};
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(column);
        
            try{
                Connection connection=connect.getconnection();
                
                String query="select * from blood_donar";
                PreparedStatement ps=connection.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                 
  	        DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal=Calendar.getInstance();
                current_date=d.format(cal.getTime());
                while(rs.next()){  
                    String name=rs.getString("name");
                    String code=rs.getString("pincode");
                    String grp=rs.getString("bloodgroup");
                    String mail=rs.getString("email");
                    long contact=rs.getLong("phno");
                    long alternate_contact=rs.getLong("altphno");
                    String address=rs.getString("address");
	            String date=rs.getString("date");
                    
                    Date date_1=d.parse(current_date);
                    Date date_2=d.parse(date);

                    if((get_pincode.equalsIgnoreCase(code))&&(get_grp.equalsIgnoreCase(grp)) &&((date_1.compareTo(date_2)>=0))){
                        model.insertRow(model.getRowCount(), new Object[]{name,grp,mail,contact,alternate_contact,address});
                        count=1;
                    }          
                }
                if(count==0){
                    JOptionPane.showMessageDialog(frame,"NO DATA FOUND");
                    frame.setVisible(false);
                }
                else{
                    frame.setVisible(true);
                }
                 
                
                rs.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        JTable jt=new JTable();
        jt.setModel(model);
        jt.setBounds(1000,1000,1000,1000);
    
        JScrollPane sp=new JScrollPane(jt);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        frame.getContentPane().add(sp);
        frame.setSize(1366,768);     
    }
}
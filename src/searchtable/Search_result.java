package searchtable;

/*  -- This class displays the search result for management's request --

*/

import DB_operations.connect;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Search_result implements ActionListener{ 
    JFrame frame;
    String get_city1,get_grp1,current_date;
    JButton return_to_screen;
    int count=0;
    public void  display_table(String get_pincode,String get_grp) throws SQLException{          
        frame=new JFrame();  
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        
        return_to_screen=new JButton("OK");
        return_to_screen.setBounds(750,600,200, 50);
        return_to_screen.setForeground(Color.black);
        return_to_screen.setBackground(Color.red);
        return_to_screen.addActionListener(this);
        
        String column[]={"NAME","BLOOD GROUP","EMAIL","CONTACT","ALTERNATE_CONTACT","ADDRESS"};
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(column);
        
            try{
                 Connection c=connect.getconnection();
                
                String query="select * from blood_donar";
                PreparedStatement ps=c.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
            
               
                DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal=Calendar.getInstance();
                current_date=d.format(cal.getTime());
        
                while(rs.next()){ 
                    String name=rs.getString("name");
                    String pincode=rs.getString("pincode");
                    String grp=rs.getString("bloodgroup");
                    String mail=rs.getString("email");
                    long contact=rs.getLong("phno");
                    long alternate_contact=rs.getLong("altphno");
                    String address=rs.getString("address");
	            String date=rs.getString("date");
                    
                    Date date_1=d.parse(current_date);
                    Date date_2=d.parse(date);

                    if((get_pincode.equalsIgnoreCase(pincode))&&(get_grp.equalsIgnoreCase(grp)) &&((date_1.compareTo(date_2)>=0))){
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
                
                
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        JTable jt=new JTable();
        jt.setModel(model);
        jt.setBounds(1000,1000,1000,1000);
        
        JScrollPane sp=new JScrollPane(jt);
        sp.add(return_to_screen);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        
        
        frame.add(sp);
        frame.setSize(1366,768);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==return_to_screen){
            new Search_table1();
        }
    }
}

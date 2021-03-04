package searchtable;

/*  -- This class allows the management to update the status of an
       blood donar --
*/

import DB_operations.connect;
import bootathon.BOOTATHON;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import java.util.Calendar;
import management_login.DoctorWelcome;


public class Remove_data implements ActionListener{
    JFrame frame;
    JComboBox cb_type_of_donation;
    JLabel lb_type,lb_contact,lb_remove_list,lbl_home,lbl_back;
    JTextField tf_number;
    JButton b_remove;
    String get_contact,get_type,update,result_date;
    int count=0,count1=0;
    static DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
    public  Calendar cal=Calendar.getInstance(); 
    public Remove_data(){
        frame=new JFrame();
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(1366,768);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        frame.setTitle("DATA UPDATION");
        try{
            
        
            lb_remove_list=new JLabel("UPDATION FORM");
            lb_remove_list.setBounds(550,35,683,125);
            lb_remove_list.setForeground(Color.RED);
            lb_remove_list.setFont(new Font("Arial",Font.BOLD,30));
        
            String types[]={"--","Whole blood","Platelets","Plasma","Power Red Donation"};
            cb_type_of_donation=new JComboBox(types);
            cb_type_of_donation.setFont(new Font("Times New Roman",Font.PLAIN,18));
            cb_type_of_donation.setBounds(700,290,350,30);
        
            lb_type=new JLabel("TYPE OF DONATION");
            lb_type.setFont(new Font("Arial",Font.BOLD,18));
            lb_type.setBounds(400,250,445,120);
            lb_type.setForeground(Color.BLACK);            
        
            lb_contact=new JLabel("CONTACT");
            lb_contact.setFont(new Font("Arial",Font.BOLD,18));
            lb_contact.setBounds(400,180,445,120);
            lb_contact.setForeground(Color.BLACK); 
        
            tf_number=new JTextField();
            tf_number.setFont(new Font("Arial",Font.PLAIN,18));
            tf_number.setHorizontalAlignment(tf_number.CENTER);
            tf_number.setBounds(700,210,350,40);
        
            b_remove=new JButton("UPDATE");
            b_remove.setFont(new Font("Arial",Font.BOLD,18));
            b_remove.setBounds(750,450,150,40);
            b_remove.setForeground(Color.white);
            b_remove.setBackground(Color.RED);
            b_remove.addActionListener(this);
            
            
            frame.add(lb_remove_list);
            frame.add(cb_type_of_donation);
            frame.add(lb_type);
            frame.add(lb_contact);
            frame.add(tf_number);
            frame.add(b_remove);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
            lbl_home=new JLabel(img_home);
            lbl_home.setBounds(40,30,53,54);
            frame.add(lbl_home);
        
            ImageIcon img_back= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
            lbl_back=new JLabel(img_back);
            lbl_back.setBounds(1200,580,53,54);
            frame.add(lbl_back);
            
            lbl_home.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                BOOTATHON boot=new BOOTATHON();
                boot.welcome_page();
                frame.setVisible(false);        
            }
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            }
            @Override
            public void mousePressed(MouseEvent e) 
            {
            }
        });
        
        lbl_back.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new DoctorWelcome();
                frame.setVisible(false);
            }
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            }
            @Override
            public void mousePressed(MouseEvent e) 
            {
            }
        });
        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        try{
             Connection c=connect.getconnection();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Remove_data();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        get_contact=tf_number.getText();
        get_type=cb_type_of_donation.getSelectedItem().toString();
        if((get_contact.isEmpty())||(get_type.equals("--"))){
            JOptionPane.showMessageDialog(frame, "ENTER ALL THE FIELDS");
        }
        else if(!get_contact.matches("\\d{10}")){
            JOptionPane.showMessageDialog(frame, "INVALID CONTACT NUMBER");
        }
        else{
            try{
                if(get_type.equals("Whole blood")){
                    count=56;
                }
                else if(get_type.equals("Platelets")){
                    count=7;
                }
                else if(get_type.equals("Plasma")){
                    count=28;
                }
                else if(get_type.equals("Power Red Donation")){
                    count=112;
                }
                result_date=dateformat.calculate(count);
                System.out.println(result_date);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            try{
                Connection c=connect.getconnection();
                String query="select * from blood_donar";
                PreparedStatement ps=c.prepareStatement(query);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    String contact=rs.getString("phno");
                    if(get_contact.equals(contact)){
                        count1+=1;
                        JOptionPane.showMessageDialog(frame, "SUCCESSFULLY UPDATED");
                        Update_query up=new Update_query();
                        up.update(result_date,get_contact);
                    }
                }
                if(count1==0){
                    JOptionPane.showMessageDialog(frame,"CONTACT NUMBER NOT FOUND");
                }
                
                rs.close();
                c.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}

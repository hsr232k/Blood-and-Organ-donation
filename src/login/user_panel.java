package login; 

/*  -- This class display the user's profile after their login and
       it also allows them to search the other donors --
*/

import javax.swing.*;
import DB_operations.connect;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import bootathon.BOOTATHON;
public class user_panel {
    JFrame frame=new JFrame();
    JLabel lbl_pincode,lbl_home,lbl_back,lbl_name,lbl_UId,lbl_bgroup,lbl_district,lbl_phno,lbl_available;
    JLabel lbl_txtUID,lbl_txtbgroup,lbl_txtdistrict,lbl_txtphno,lbl_txtavailable;
    Font font_1=new Font("Arial",Font.BOLD,30);
    Font font_2=new Font("Arial",Font.BOLD,20);
    Font font_3=new Font("Arial",Font.PLAIN,20);
    JTextField txt_pincode;
    JComboBox cb_bloodgroups;
    JButton btn_search;
    String bloodgroups[]={"--",
        "A+", "O+", "B+", "AB+", "A-", "O-","B-","AB-"
    };
    public void Upanel(String Uid){
        Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setTitle("USER PANEL");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        String name="",userid="",bgroup="",district="",phno="",availabledate="";
        try
        {
            Connection connection=connect.getconnection();
            String query="select * from blood_donar where user_id=?";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1, Uid);
            ResultSet r=ps.executeQuery();
            while(r.next()){
                name=r.getString("name");
                userid=r.getString("user_id");
                bgroup=r.getString("bloodgroup");
                district=r.getString("district");
                phno=r.getString("phno");
                availabledate=r.getString("Date");
                
            }
            connection.setAutoCommit(true);
            connection.close();
        }
        catch(Exception e)
        {
            System.out.print("--------->"+e);
        }
        
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel(img_home);
        lbl_home.setBounds(300,30,100,100);
        frame.add(lbl_home);
        
        ImageIcon img_back= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel(img_back);
        lbl_back.setBounds(1050,600,100,100);
        frame.add(lbl_back);
        
        lbl_name=new JLabel(name);
        lbl_name.setFont(font_1);
        lbl_name.setForeground(Color.red);
        lbl_name.setBounds(450,50,500,50);
        lbl_name.setHorizontalAlignment(lbl_name.CENTER);
        frame.add(lbl_name);
        
        lbl_UId=new JLabel("ID");
        lbl_UId.setFont(font_2);
        lbl_UId.setBounds(500,100,200,40);
        frame.add(lbl_UId);
        
        lbl_txtUID=new JLabel(userid);
        lbl_txtUID.setFont(font_2);
        lbl_txtUID.setBackground(Color.LIGHT_GRAY);
        lbl_txtUID.setBounds(800,100,200,40);
        frame.add(lbl_txtUID);
        
        lbl_bgroup=new JLabel("Blood Group");
        lbl_bgroup.setFont(font_2);
        lbl_bgroup.setBounds(500,150,200,40);
        frame.add(lbl_bgroup);
        
        lbl_txtbgroup=new JLabel(bgroup);
        lbl_txtbgroup.setFont(font_2);
        lbl_txtbgroup.setBackground(Color.LIGHT_GRAY);
        lbl_txtbgroup.setBounds(800,150,200,40);
        frame.add(lbl_txtbgroup);
        
        lbl_district=new JLabel("District");
        lbl_district.setFont(font_2);
        lbl_district.setBounds(500,200,200,40);
        frame.add(lbl_district);
        
        lbl_txtdistrict=new JLabel(district);
        lbl_txtdistrict.setFont(font_2);
        lbl_txtdistrict.setBackground(Color.LIGHT_GRAY);
        lbl_txtdistrict.setBounds(800,200,200,40);
        frame.add(lbl_txtdistrict);
        
        lbl_phno=new JLabel("Phone Number");
        lbl_phno.setFont(font_2);
        lbl_phno.setBounds(500,250,200,40);
        frame.add(lbl_phno);
        
        lbl_txtphno=new JLabel(phno);
        lbl_txtphno.setFont(font_2);
        lbl_txtphno.setBackground(Color.LIGHT_GRAY);
        lbl_txtphno.setBounds(800,250,200,40);
        frame.add(lbl_txtphno);
        
        lbl_available=new JLabel("Available from");
        lbl_available.setFont(font_2);
        lbl_available.setBounds(500,300,200,40);
        frame.add(lbl_available);
        
        cb_bloodgroups=new JComboBox(bloodgroups);
        lbl_available.setFont(font_2);
        cb_bloodgroups.setBounds(800,450,200,40);
        frame.add(cb_bloodgroups);
        
        lbl_txtavailable=new JLabel(availabledate);
        lbl_txtavailable.setFont(font_2);
        lbl_txtavailable.setBackground(Color.LIGHT_GRAY);
        lbl_txtavailable.setBounds(800,300,200,40);
        frame.add(lbl_txtavailable);
        
        lbl_pincode=new JLabel("Pincode ");
        lbl_pincode.setFont(font_2);
        lbl_pincode.setBackground(Color.LIGHT_GRAY);
        lbl_pincode.setBounds(330,450,150,40);
        frame.add(lbl_pincode);
        
        txt_pincode=new JTextField();
        txt_pincode.setFont(font_3);
        txt_pincode.setBounds(500,450,200,40);
        frame.add(txt_pincode);
        
        btn_search=new JButton("Search");
        btn_search.setFont(font_2);
        btn_search.setBackground(Color.red);
        btn_search.setForeground(Color.WHITE);
        btn_search.setBounds(675,550,150,40);
        frame.add(btn_search);
        
        lbl_home.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                frame.setVisible(false);
                BOOTATHON boot=new BOOTATHON();
                boot.welcome_page();
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
                frame.setVisible(false);
                User_login log=new User_login();
                log.U_login();
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
        
        btn_search.addActionListener((ActionEvent e) -> {
            String bgroup1 = cb_bloodgroups.getSelectedItem().toString();
            String pincode = txt_pincode.getText();
            if(bgroup1.equals("--") || pincode.isEmpty()){
                JOptionPane.showMessageDialog(frame,"PLEASE FILL THE ABOVE FIELDS");
            }
            else{
                try {
                    Tabledisplay td=new Tabledisplay();
                    td.display_table(pincode, bgroup1);
                }catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        });
        
        frame.setVisible(true);  
        
    } 
}

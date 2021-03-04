package blooddonar_regform;
/*  -- This class is used to get credentials from users during
       their account creation --
*/
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import bootathon.BOOTATHON;
import login.User_login;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class bdonar_regform extends WindowAdapter
    {
    JLabel lbl_pincode,lbl_home,lbl_back,lbl_head,lbl_name,lbl_UId,lbl_password,lbl_retypepassword,lbl_age,lbl_weight,lbl_gender,lbl_bgroup,lbl_district,lbl_address,lbl_phno,lbl_altphno,lbl_email;
    JTextField txt_pincode,txt_name,txt_UId,txt_age,txt_weight,txt_phno,txt_altphno,txt_email;
    JTextArea txt_address;
    JPasswordField pf_password,pf_retypepassword;
    JFrame frame=new JFrame();
    JButton btn_register;
    JRadioButton rb_male,rb_female,rb_others;
    ButtonGroup bgrp_gender;
    JComboBox cb_bloodgroups,cb_district;
    String bloodgroups[]={"--",
        "A+", "O+", "B+", "AB+", "A-", "O-","B-","AB-"
    },district []={"--","Ariyalur","Chengalpattu","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul",
                        "Erode","Kallakurichi","Kanchipuram","Kanyakumari","Karur","Krishnagiri","Madurai","Nagapattinam",
                        "Namakkal","Nilgiris","Perambalur","Pudhukkottoi","Ramanadhapuram","Ranipet","Salem","Sivanagai","Thenkasi",
                        "Thanjavur","Theni","Tuticorin","Trichy","Tirunelveli","Tirupathur","Tiruppur","Tiruvallur","Tiruvannamalai",
                        "Tiruvarur","Vellore","Viluppuram","Virudhunagar"};
    Font font_1=new Font("Arial",Font.BOLD,18);
    Font font_2=new Font("Arial",Font.BOLD,25);
    Font font_3=new Font("Arial",Font.BOLD,17);
    Font font_4=new Font("Arial",Font.PLAIN,18); 
    public void donar_regform()
    {
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setTitle("REGISTRATION FORM");
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4, 4,4,4, Color.RED));
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel(img_home);
        lbl_home.setBounds(40,30,53,54);
        frame.add(lbl_home); 
        ImageIcon img_back= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel(img_back);
        lbl_back.setBounds(1200,600,53,54);
        frame.add(lbl_back);
        
        lbl_head=new JLabel("REGISTRATION FORM");
        lbl_head.setFont(font_2);
        lbl_head.setForeground(Color.red);
        lbl_head.setBounds(550,30,300,30);
        frame.add(lbl_head);
        
        lbl_name=new JLabel("Name *");
        lbl_name.setFont(font_1);
        lbl_name.setBounds(450,100,100,30);
        frame.add(lbl_name);
        
        txt_name=new JTextField();
        txt_name.setFont(font_4);
        txt_name.setBounds(750,100,200,25);
        frame.add(txt_name);
        
        lbl_UId=new JLabel("User Id *");
        lbl_UId.setFont(font_1);
        lbl_UId.setBounds(450,140,100,30);
        frame.add(lbl_UId);
        
        txt_UId=new JTextField();
        txt_UId.setFont(font_4);
        txt_UId.setBounds(750,140,200,25);
        frame.add(txt_UId);
        
        lbl_password=new JLabel("Password *");
        lbl_password.setFont(font_1);
        lbl_password.setBounds(450,180,200,30);
        frame.add(lbl_password);
        
        pf_password=new JPasswordField();
        pf_password.setFont(font_4);
        pf_password.setBounds(750,180,200,25);
        frame.add(pf_password);
        
        lbl_retypepassword=new JLabel("Retype-Password *");
        lbl_retypepassword.setFont(font_1);
        lbl_retypepassword.setBounds(450,220,200,30);
        frame.add(lbl_retypepassword);
        
        pf_retypepassword=new JPasswordField();
        pf_retypepassword.setFont(font_4);
        pf_retypepassword.setBounds(750,220,200,25);
        frame.add(pf_retypepassword);
        
        lbl_age=new JLabel("Age *");
        lbl_age.setFont(font_1);
        lbl_age.setBounds(450,260,50,30);
        frame.add(lbl_age);
        
        txt_age=new JTextField();
        txt_age.setFont(font_4);
        txt_age.setBounds(600,260,50,30);
        frame.add(txt_age);
        
        lbl_weight=new JLabel("Weight *");
        lbl_weight.setFont(font_1);
        lbl_weight.setBounds(750,260,100,30);
        frame.add(lbl_weight);
        
        txt_weight=new JTextField();
        txt_weight.setFont(font_4);
        txt_weight.setBounds(900,260,50,30);
        frame.add(txt_weight);
        
        lbl_gender=new JLabel("Gender *");
        lbl_gender.setFont(font_1);
        lbl_gender.setBounds(450,300,100,30);
        frame.add(lbl_gender);
        
        rb_male=new JRadioButton("Male");
        rb_male.setFont(font_4);
        rb_male.setBackground(Color.WHITE);
        rb_male.setBounds(750,300,70,30);
        frame.add(rb_male);
        
        rb_female=new JRadioButton("Female");
        rb_female.setFont(font_4);
        rb_female.setBackground(Color.WHITE);
        rb_female.setBounds(850,300,100,30);
        frame.add(rb_female);
        
        rb_others=new JRadioButton("Others");
        rb_others.setFont(font_4);
        rb_others.setBackground(Color.WHITE);
        rb_others.setBounds(950,300,700,30);
        frame.add(rb_others);
        
        bgrp_gender=new ButtonGroup();
        bgrp_gender.add(rb_male);
        bgrp_gender.add(rb_female);
        bgrp_gender.add(rb_others);
        
        lbl_bgroup=new JLabel("Blood Group  *");
        lbl_bgroup.setFont(font_1);
        lbl_bgroup.setBounds(450,340,200,30);
        frame.add(lbl_bgroup);
        
        cb_bloodgroups=new JComboBox(bloodgroups);
        cb_bloodgroups.setFont(font_4);
        cb_bloodgroups.setBounds(850,340,100,30);
        frame.add(cb_bloodgroups);
        
        lbl_district=new JLabel("District *");
        lbl_district.setFont(font_1);
        lbl_district.setBounds(450,380,100,30);
        frame.add(lbl_district);
        
        cb_district=new JComboBox(district);
        cb_district.setFont(font_4);
        cb_district.setBounds(750,380,200,30);
        frame.add(cb_district);
        
        lbl_address=new JLabel("Address *");
        lbl_address.setFont(font_1);
        lbl_address.setBounds(450,420,200,30);
        frame.add(lbl_address);
        
        txt_address=new JTextArea();
        txt_address.setFont(new Font("Arial",Font.PLAIN,12));
        txt_address.setBounds(750,420,250,55);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        txt_address.setBorder(border);
        frame.add(txt_address);
  
        lbl_phno=new JLabel("Phone number *");
        lbl_phno.setFont(font_1);
        lbl_phno.setBounds(450,480,200,30);
        frame.add(lbl_phno);
        
        txt_phno=new JTextField();
        txt_phno.setFont(font_4);
        txt_phno.setBounds(750,480,200,25);
        frame.add(txt_phno);
        
        lbl_altphno=new JLabel("Alternate Phone number");
        lbl_altphno.setFont(font_1);
        lbl_altphno.setBounds(450,520,250,30);
        frame.add(lbl_altphno);
        
        txt_altphno=new JTextField();
        txt_altphno.setFont(font_4);
        txt_altphno.setBounds(750,520,200,25);
        frame.add(txt_altphno);
        
        lbl_email=new JLabel("E-Mail *");
        lbl_email.setFont(font_1);
        lbl_email.setBounds(450,560,100,30);
        frame.add(lbl_email);
        
        txt_email=new JTextField();
        txt_email.setFont(font_4);
        txt_email.setBounds(750,560,200,25);
        frame.add(txt_email);
        
        lbl_pincode=new JLabel("Pin code *");
        lbl_pincode.setFont(font_1);
        lbl_pincode.setBounds(450,600,100,30);
        frame.add(lbl_pincode);
        
        txt_pincode=new JTextField();
        txt_pincode.setFont(font_4);
        txt_pincode.setBounds(750,600,200,25);
        frame.add(txt_pincode);
        
        btn_register=new JButton("Register");
        btn_register.setFont(font_1);
        btn_register.setForeground(Color.WHITE);
        btn_register.setBackground(Color.red);
        btn_register.setBounds(780,640,120,30);
        frame.add(btn_register);
        
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
        
        btn_register.addActionListener((ActionEvent e) -> {
            String name=txt_name.getText();
            String UId=txt_UId.getText();
            String pass=pf_password.getText();
            String Re_pass=pf_retypepassword.getText();
            String age=txt_age.getText();
            String weight=txt_weight.getText();
            String gender="";
            if(rb_male.isSelected())
            {
                gender="male";
            }
            else if(rb_female.isSelected())
            {
                gender="female";
            }
            else if(rb_others.isSelected())
            {
                gender="others";
            }
            String bgroup=cb_bloodgroups.getSelectedItem().toString();
            String district1 = cb_district.getSelectedItem().toString();
            String address=txt_address.getText();
            String phno=txt_phno.getText();
            String altphno=txt_altphno.getText();
            String email=txt_email.getText();
            String pincode=txt_pincode.getText();
            if(altphno.length()==0)
            {
                altphno="0000000000";
            }
            field_validation val=new field_validation();
            String result_validate = val.valid(name, UId, pass, Re_pass, age, weight, gender, bgroup, district1, address, phno, altphno, email, pincode);
            if(altphno.length()==0)
            {
                altphno="0000000000";
            }
            if (result_validate.equals("SUCCESSFULLY REGISTERED")) {
                int i_age=Integer.parseInt(age),i_weight=Integer.parseInt(weight);
                DB_insertion insert=new DB_insertion();
                String result_insertion = insert.insertion(name, UId, pass, i_age, i_weight, gender, bgroup, district1, address, phno, altphno, email, pincode);
                if(!result_insertion.equals("USER ID OR PHONE NUMBER ALREADY EXISTS"))
                {
                    JOptionPane.showMessageDialog(frame, result_validate);
                    frame.setVisible(false);
                    User_login ulog=new User_login();
                    ulog.U_login();

                    txt_name.setText("");
                    txt_UId.setText("");
                    pf_password.setText("");
                    pf_retypepassword.setText("");
                    txt_age.setText("");
                    txt_weight.setText("");
                    txt_address.setText("");
                    txt_phno.setText("");
                    txt_altphno.setText("");
                    txt_email.setText("");
                    txt_pincode.setText("");
                }else{
                    JOptionPane.showMessageDialog(frame, result_insertion);
                }
            } else {
                JOptionPane.showMessageDialog(frame, result_validate);
            }
        });
        frame.setVisible(true); 
    }
    public static void main(String args[])
    {
        bdonar_regform bdr=new bdonar_regform();
        bdr.donar_regform();
    }
  }
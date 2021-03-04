package organRegForm;

/*  -- This class is to get the data of an organ donor
       from the management --
*/

import management_login.DoctorWelcome;
import bootathon.BOOTATHON;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DonorRegForm extends JFrame{
    Container c,c1;
    JFrame frame;
    JTextArea ta_res;
    JLabel lbl_title,lbl_dphno,lbl_gphno,lbl_mailid,lbl_authorise,lbl_organs,lbl_gname;
    JLabel lbl_dname,lbl_address,lbl_age,lbl_dob,lbl_bloodgrp,lbl_gender,lbl_daltphno;
    JTextField tf_dfname,tf_dlname,tf_age,tf_dob,tf_dphno,tf_mailid,tf_gfname,tf_glname,tf_gphno,tf_daltphno;
    JTextArea ta_address;
    JRadioButton rb_male,rb_female,rb_others;
    JRadioButton rb_research,rb_transplant,rb_both_rt;
    ButtonGroup bgrp_gender,bgrp_authosise;
    JComboBox cb_date,cb_month,cb_year,cb_bloodgrp;
    JCheckBox chb_heart,chb_lungs,chb_liver,chb_kidneys,chb_eyes,chb_all;
    JButton btn_submit;
    
    
    private String dates[] 
        = { "--","1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    
    private String months[] 
        = { "---","Jan", "Feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sep", "Oct", "Nov", "Dec" };
    
    private String years[] 
        = { "----","1940","1941","1942",
            "1943","1944","1945","1946",
            "1947","1948","1949","1950",
            "1951","1952","1953","1954",
            "1955","1956","1957","1958",
            "1959","1960","1961","1962",
            "1963","1964","1965","1966",
            "1967","1968","1969","1970",
            "1971","1972","1973","1974",
            "1975","1976","1977","1978",
            "1979","1980","1981","1982",
            "1983","1984","1985","1986",
            "1987","1988","1989","1990",
            "1991","1992","1993","1994",
            "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" };
    
    private String bloodgrps[]
        ={ "---", "A+", "O+", "B+", "AB+", "A-", "O-","B-","AB-"};
    
    public DonorRegForm(){
        c=new Container();
        c1=new Container();
        frame=new JFrame();
        frame.setTitle("DONOR REGISTRATION FORM");
        Font font=new Font("Arial",Font.BOLD,16);
        Font font_1=new Font("Arial",Font.PLAIN,14);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        
        JLabel lbl_home;
        ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel("",img1,JLabel.CENTER);
        lbl_home.setBounds(80,0,53,54);
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
        c.add(lbl_home);
                
        JLabel lbl_back;
        ImageIcon img2= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel("",img2,JLabel.CENTER);
        lbl_back.setBounds(1200,580,53,54);
        lbl_back.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                frame.setVisible(false);
                new DoctorWelcome();
                
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
        c1.add(lbl_back);
        
        
        lbl_title=new JLabel("ORGAN DONOR REGISTRATION FORM");
        lbl_title.setFont(new Font("",Font.BOLD,30));
        lbl_title.setForeground(Color.red);
        lbl_title.setBounds(450,40,600,30);
        frame.add(lbl_title);
        //---------------container starts--------------------

        lbl_dname=new JLabel("Donor Name");
        lbl_dname.setBounds(300,100,100,30);
        lbl_dname.setFont(font);
        c.add(lbl_dname);
        
        tf_dfname=new JTextField("First Name");
        tf_dfname.setBackground(Color.WHITE);
        tf_dfname.setFont(font_1);
        tf_dfname.setBounds(310,130,110,30);
        c.add(tf_dfname);
        
        tf_dlname=new JTextField("Last Name");
        tf_dlname.setLocation(440,130);
        tf_dlname.setFont(font_1);
        tf_dlname.setBackground(Color.WHITE);
        tf_dlname.setSize(110,30);
        c.add(tf_dlname);
        
        lbl_gender=new JLabel("Gender");
        lbl_gender.setFont(font);
        lbl_gender.setBounds(300,180,100,30);
        c.add(lbl_gender);
        
        rb_male=new JRadioButton("Male");
        rb_male.setBounds(310,200,80,30);
        rb_male.setFont(font_1);
        rb_male.setBackground(Color.WHITE);
        c.add(rb_male);
        
        rb_female=new JRadioButton("Female");
        rb_female.setBounds(400,200,80,30);
        rb_female.setFont(font_1);
        rb_female.setBackground(Color.WHITE);
        c.add(rb_female);
        
        rb_others=new JRadioButton("Others");
        rb_others.setBounds(490,200,80,30);
        rb_others.setFont(font_1);
        rb_others.setBackground(Color.WHITE);
        c.add(rb_others);
        
        bgrp_gender=new ButtonGroup();
        bgrp_gender.add(rb_male);
        bgrp_gender.add(rb_female);
        bgrp_gender.add(rb_others);
        
        lbl_dob=new JLabel("Date Of Birth");
        lbl_dob.setFont(font);
        lbl_dob.setBounds(300,240,100,30);
        c.add(lbl_dob);
        
        cb_date = new JComboBox(dates); 
        cb_date.setBackground(Color.WHITE);
        cb_date.setFont(font_1); 
        cb_date.setBounds(310,270,50,20);
        c.add(cb_date);
        
        cb_month = new JComboBox(months); 
        cb_month.setFont(font_1); 
        cb_month.setBackground(Color.WHITE);
        cb_month.setBounds(390,270,50,20);
        c.add(cb_month);
        
        cb_year = new JComboBox(years); 
        cb_year.setFont(font_1); 
        cb_year.setBackground(Color.WHITE);
        cb_year.setBounds(470,270,80,20);
        c.add(cb_year);
        
        lbl_bloodgrp=new JLabel("Blood Group");
        lbl_bloodgrp.setFont(font);
        lbl_bloodgrp.setBounds(300,320,120,20);
        c.add(lbl_bloodgrp);
        
        cb_bloodgrp=new JComboBox(bloodgrps);
        cb_bloodgrp.setBounds(470,325,80,20);
        cb_bloodgrp.setBackground(Color.WHITE);
        cb_bloodgrp.setFont(font_1);
        c.add(cb_bloodgrp);
        
        
        lbl_address=new JLabel("Address");
        lbl_address.setFont(font);
        lbl_address.setBounds(300,360,80,20);
        c.add(lbl_address);
        
        ta_address=new JTextArea();
        ta_address.setBackground(Color.WHITE);
        ta_address.setBounds(310,380,240,60);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        ta_address.setBorder(border);
        c.add(ta_address);
        
        lbl_dphno=new JLabel("Phone No");
        lbl_dphno.setFont(font);
        lbl_dphno.setBounds(300,460,80,20);
        c.add(lbl_dphno);
        
        tf_dphno=new JTextField();
        tf_dphno.setBackground(Color.WHITE);
        tf_dphno.setBounds(450,460,100,20);
        c.add(tf_dphno);
        
        lbl_daltphno=new JLabel("Alternate Phone No");
        lbl_daltphno.setFont(new Font("Airal",Font.BOLD,15));
        lbl_daltphno.setBounds(300,495,150,20);
        c.add(lbl_daltphno);
        
        tf_daltphno=new JTextField();
        tf_daltphno.setBackground(Color.WHITE);
        tf_daltphno.setBounds(450,495,100,20);
        c.add(tf_daltphno);
        
        lbl_mailid=new JLabel("E-Mail Id");
        lbl_mailid.setFont(font);
        lbl_mailid.setBounds(300,530,80,20);
        c.add(lbl_mailid);
        
        tf_mailid=new JTextField();
        tf_mailid.setBackground(Color.WHITE);
        tf_mailid.setBounds(450,530,100,20);
        c.add(tf_mailid);
        
        c.setBounds(100,51,600,600);
        frame.add(c);
        //c.setBackground(Color.RED);
        //-----------------------------------------------------c components over ------------------------------------
        lbl_gname=new JLabel("Guardian Name");
        lbl_gname.setFont(font);
        lbl_gname.setBounds(800,160,120,20);
        c1.add(lbl_gname);
        
        tf_gfname=new JTextField("First Name");
        tf_gfname.setFont(font_1);
        tf_gfname.setBounds(800,180,110,30);
        tf_gfname.setBackground(Color.WHITE);
        c1.add(tf_gfname);
        
        tf_glname=new JTextField("Last Name");
        tf_glname.setFont(font_1);
        tf_glname.setBounds(950,180,110,30);
        tf_glname.setBackground(Color.WHITE);
        c1.add(tf_glname);
        
        lbl_gphno=new JLabel("Guardian Phone No");
        lbl_gphno.setFont(new Font("Airal",Font.BOLD,15));
        lbl_gphno.setBounds(800,230,150,20);
        c1.add(lbl_gphno);
        
        tf_gphno=new JTextField();
        tf_gphno.setFont(font_1);
        tf_gphno.setBackground(Color.WHITE);
        tf_gphno.setBounds(950,230,110,20);
        c1.add(tf_gphno);
        
        
        lbl_organs=new JLabel("Hereby,I donate");
        lbl_organs.setFont(font);
        lbl_organs.setBounds(800,260,150,20);
        c1.add(lbl_organs);
        
        chb_heart=new JCheckBox("Heart");
        chb_heart.setBounds(810,280,80,20);
        chb_heart.setBackground(Color.WHITE);
        chb_heart.setFont(font_1);
        c1.add(chb_heart);
        
        chb_lungs=new JCheckBox("Lungs");
        chb_lungs.setBounds(810,300,80,20);
        chb_lungs.setBackground(Color.WHITE);
        chb_lungs.setFont(font_1);
        c1.add(chb_lungs);
        
        chb_liver=new JCheckBox("Liver");
        chb_liver.setBounds(810,320,80,20);
        chb_liver.setBackground(Color.WHITE);
        chb_liver.setFont(font_1);
        c1.add(chb_liver);
        
        chb_kidneys=new JCheckBox("Kidneys");
        chb_kidneys.setBounds(810,340,80,20);
        chb_kidneys.setBackground(Color.WHITE);
        chb_kidneys.setFont(font_1);
        c1.add(chb_kidneys);
        
        chb_eyes=new JCheckBox("Eyes");
        chb_eyes.setBounds(810,360,80,20);
        chb_eyes.setBackground(Color.WHITE);
        chb_eyes.setFont(font_1);
        c1.add(chb_eyes);
        
        chb_all=new JCheckBox("All");
        chb_all.setBounds(810,380,80,20);
        chb_all.setBackground(Color.WHITE);
        chb_all.setFont(font_1);
        c1.add(chb_all);
        
        lbl_authorise=new JLabel("I authorize you to use my organs/tissues for");
        lbl_authorise.setBounds(800,410,400,20);
        lbl_authorise.setFont(font);
        c1.add(lbl_authorise);
        
        rb_research=new JRadioButton("Research");
        rb_research.setBounds(810,430,200,20);
        rb_research.setBackground(Color.WHITE);
        rb_research.setFont(font_1);
        c1.add(rb_research);
        
        rb_transplant=new JRadioButton("Transplant");
        rb_transplant.setBounds(810,450,200,20);
        rb_transplant.setBackground(Color.WHITE);
        rb_transplant.setFont(font_1);
        c1.add(rb_transplant);
        
        rb_both_rt=new JRadioButton("Research And Transplant");
        rb_both_rt.setBounds(810,470,200,20);
        rb_both_rt.setBackground(Color.WHITE);
        rb_both_rt.setFont(font_1);
        c1.add(rb_both_rt);
         
        bgrp_authosise=new ButtonGroup();
        bgrp_authosise.add(rb_research);
        bgrp_authosise.add(rb_transplant);
        bgrp_authosise.add(rb_both_rt);
        
        btn_submit=new JButton("Submit");
        btn_submit.setBounds(850,570,80,40);
        btn_submit.setBackground(Color.red);
        btn_submit.setFont(new Font("Arial",Font.BOLD,12));
        btn_submit.setForeground(Color.WHITE);
        btn_submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                    Operations op=new Operations();
                    String res="";
                    String dbres="";
                    String dfname,dlname,gfname,glname,dphno,daltphno,gphno,mailid,address;
                    //----------------------------------------dname
                    dfname=tf_dfname.getText();
                    dlname=tf_dlname.getText();
                   //-----------------------------------------gname
                    gfname=tf_gfname.getText();
                    glname=tf_glname.getText();
                    //----------------------------------------d phno
                    dphno=tf_dphno.getText();
                    //-----------------------------------------d alt phno
                    daltphno=tf_daltphno.getText();
                    //-------------------------------------------g phno
                    gphno=tf_gphno.getText();
                    //-----------------------------------------------mail
                    mailid=tf_mailid.getText();
                    //----------------------------------------------address
                    address=ta_address.getText();
                    //----------------------------------------------gender
                    String gender="Null";
                    if(rb_male.isSelected())
                        gender="Male";
                    else if(rb_female.isSelected())
                        gender="Female";
                    else if(rb_others.isSelected())
                        gender="Others";
                    //---------------------------------------------authorise
                    String authorise="Null";
                    if(rb_research.isSelected())
                        authorise="Research";
                    else if(rb_transplant.isSelected())
                        authorise="Transplant";
                    else if(rb_both_rt.isSelected())
                        authorise="Research And Transplant";
                    //---------------------------------------------blood grp
                    String bloodgrp;
                    bloodgrp=(String)cb_bloodgrp.getSelectedItem();
                    //---------------------------------------------DOB
                    String date,month,year;
                    date=(String)cb_date.getSelectedItem();
                    month=(String)cb_month.getSelectedItem();
                    year=(String)cb_year.getSelectedItem();
                    //---------------------------------------------Organs
                    boolean all=false,heart=false,lungs=false,kidneys=false,eyes=false,liver=false;
                    if(chb_all.isSelected()==false){
                        if(chb_heart.isSelected())
                            heart=true;
                        if(chb_lungs.isSelected())
                            lungs=true;
                        if(chb_kidneys.isSelected())
                            kidneys=true;
                        if(chb_eyes.isSelected())
                            eyes=true;
                        if(chb_liver.isSelected())
                            liver=true;
                        
                    }
                    else if(chb_all.isSelected()){
                        all=true;
                        heart=true;
                        lungs=true;
                        kidneys=true;
                        eyes=true;
                        liver=true;
                    }       
                    //---------------------------------------------------------------------------------------------
                    OrganRegDB db=new OrganRegDB();
                    Validate v=new Validate();
                    res=v.validate(dfname,dlname,gfname,glname,dphno,daltphno,gphno,gender,authorise,bloodgrp,date,month,year,all,heart,lungs,liver,kidneys,eyes);
                    String currentdate=Operations.currentdate();
                    if(res==""){
                        try {
                            dbres=db.insertValues(dfname,dlname,gfname,glname,dphno,daltphno,gphno,mailid,address,authorise,gender,bloodgrp,date,month,year,all,heart,liver,eyes,lungs,kidneys,currentdate);
                        }catch (Exception ex) {
                        System.out.println(ex);
                        }
                        JOptionPane.showMessageDialog(frame,dbres);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,res);     
                    }     
            }
        });
        c1.add(btn_submit);
        c1.setBounds(900,51,400,690);
        frame.add(c1);
        
        
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(0,0,1280,690);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new DonorRegForm(); 
    }
}
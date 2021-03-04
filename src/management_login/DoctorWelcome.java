package management_login;

/*  -- This class is the control panel for management, where can store or view 
       an donor's data --
*/

import organRegForm.DonorRegForm;
import bootathon.BOOTATHON;
import searchtable.Remove_data;
import searchtable.Search_table1;
import searchtable.EditOrganDonor;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
public class DoctorWelcome extends JFrame {
    public static JFrame frame=new JFrame();
    public static JLabel lbl_home,lbl_back;
    public static JButton btn_user,btn_management;
    public static Font font=new Font("SansSerif",Font.BOLD,20);
        
        public DoctorWelcome()
        {
        Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setTitle("MANAGEMENT WELCOME PAGE");
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel(img_home);
        lbl_home.setBounds(1100,600,53,54);
        frame.add(lbl_home);
        
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
        
        ImageIcon img_back= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel(img_back);
        lbl_back.setBounds(1200,600,53,54);
        frame.add(lbl_back);
        
        lbl_back.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                frame.setVisible(false);
                new Login();                
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
        

        JLabel title;
        title = new JLabel("WELCOME TO YOUR CONTROL PANEL");
        title.setForeground(Color.red);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setBounds(400,25,686,125);
        frame.add(title);
        
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        
        JLabel background4;
        ImageIcon img4= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\rsz_doctor1.jpg");
        background4=new JLabel("",img4,JLabel.CENTER);
        background4.setBounds(100,40,100,100);
        frame.add(background4);
        
        JLabel background;
        JLabel icon2;
        icon2 = new JLabel("SEARCH ORGAN");
        icon2.setForeground(Color.black);
        icon2.setBounds(440,350,228,222);
        icon2.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon2);
        JLabel icon2_1;
        icon2_1 = new JLabel("DONOR");
        icon2_1.setForeground(Color.black);
        icon2_1.setBounds(480,380,228,222);
        icon2_1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon2_1);
        ImageIcon img= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\search1.jpg");
        background=new JLabel("",img,JLabel.CENTER);
        background.setBounds(400,180,228,222);
        background.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                frame.setVisible(false);
                new EditOrganDonor();
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
        frame.add(background);

        JLabel background1;
        JLabel icon1;
        icon1 = new JLabel("REGISTER ORGAN");
        icon1.setForeground(Color.black);
        icon1.setBounds(75,350,228,222);
        icon1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon1);
        JLabel icon1_1;
        icon1_1 = new JLabel("DONOR");
        icon1_1.setForeground(Color.black);
        icon1_1.setBounds(125,380,228,222);
        icon1_1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon1_1);
        ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\register1.jpg");
        background1=new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(50,180,228,222);
        background1.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new DonorRegForm();
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
         frame.add(background1);
         
        JLabel background2;
        JLabel icon3;
        icon3 = new JLabel("ACKNOWLEDGE");
        icon3.setForeground(Color.black);
        icon3.setBounds(790,350,228,222);
        icon3.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon3);  
        JLabel icon3_1;
        icon3_1 = new JLabel("BLOOD DONOR");
        icon3_1.setForeground(Color.black);
        icon3_1.setBounds(795,380,228,222);
        icon3_1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon3_1);
        ImageIcon img2= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\acknowledge1.jpg");
        background2=new JLabel("",img2,JLabel.CENTER);
        background2.setBounds(750,180,228,222);
        background2.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new Remove_data();
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
        frame.add(background2);
        
        JLabel background3;
        JLabel icon4;
        icon4 = new JLabel("SEARCH BLOOD");
        icon4.setForeground(Color.black);
        icon4.setBounds(1140,350,228,222);
        icon4.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon4);
        JLabel icon4_1;
        icon4_1 = new JLabel("DONOR");
        icon4_1.setForeground(Color.black);
        icon4_1.setBounds(1180,380,228,222);
        icon4_1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(icon4_1);
         ImageIcon img3= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\search1.jpg");
         background3=new JLabel("",img3,JLabel.CENTER);
         background3.setBounds(1100,180,228,222);
         background3.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new Search_table1();
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
        frame.add(background3);
        frame.setVisible(true);
        }
        
         public static void main(String[] args) {
             DoctorWelcome docwel=new DoctorWelcome();
    }   
}
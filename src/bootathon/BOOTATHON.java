package bootathon;
/*   -- This class is the control unit of our project it contains the paths for
        Management login, User login and Admin login --
*/
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import login.User_login;
import management_login.Login;
public class BOOTATHON extends JFrame {
    JFrame frame=new JFrame();
    JLabel lbl_admin,lbl_info,lbl_title,lbl_management,lbl_user,lbl_txtmanagement,lbl_txtuser;
    JButton btn_user,btn_management;
    Font font_1=new Font("Arial",Font.BOLD,20);
    Font font_2=new Font("Arial",Font.BOLD,40);
        public void welcome_page(){
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("BLOOD & ORGAN DONATION");
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_title = new JLabel("BLOOD & ORGAN DONATION");
        lbl_title.setForeground(Color.red);
        lbl_title.setFont(font_2);
        lbl_title.setBounds(410,25,683,125);
        frame.add(lbl_title);
        
        lbl_txtmanagement = new JLabel("MANAGEMENT");
        lbl_txtmanagement.setFont(font_2);
        lbl_txtmanagement.setBounds(190,300,300,411);
        frame.add(lbl_txtmanagement);
        
        lbl_txtuser=new JLabel("USER");
        lbl_txtuser.setFont(font_2);
        lbl_txtuser.setBounds(985,300,255,411);
        frame.add(lbl_txtuser);
                
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        
        ImageIcon img_management= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\Management.jpg");
        lbl_management=new JLabel(img_management);
        lbl_management.setBounds(180,100,343,432);
        lbl_management.addMouseListener(new MouseListener(){
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
        frame.add(lbl_management);
                
        ImageIcon img_user= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\user.jpg");
        lbl_user=new JLabel(img_user);
        lbl_user.setBounds(900,100,255,411);
        lbl_user.addMouseListener(new MouseListener(){
           @Override
           public void mouseReleased(MouseEvent e)
           {
           }
           @Override
           public void mouseClicked(MouseEvent e) 
           {
               frame.setVisible(false);
               User_login Ulog = new User_login();
               Ulog.U_login();
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
        frame.add(lbl_user);
        
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\admin.jpeg");
        lbl_admin=new JLabel(img_home);
        lbl_admin.setBounds(80,600,53,54);
        frame.add(lbl_admin);
        
        lbl_admin.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                frame.setVisible(false); 
                AdminLogin adminLogin = new AdminLogin();   
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
        
        ImageIcon img_info= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\info.jpeg");
        lbl_info=new JLabel(img_info);
        lbl_info.setBounds(1230,600,53,54);
        frame.add(lbl_info);
        
        lbl_info.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e)
            {
            }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                JOptionPane.showMessageDialog(frame,"FOR HELP,\n\nCONTACT : 9876543210\n\nEMAIL ID   : T2SKIB@gmail.com\n\n"); 
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
        frame.setVisible(true);
       }
       public static void main(String[] args) {
            BOOTATHON boot=new BOOTATHON();
            boot.welcome_page();
    }   
}

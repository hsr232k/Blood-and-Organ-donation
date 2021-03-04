package login;

/*  -- This class controls the user's login --

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import blooddonar_regform.bdonar_regform;
import bootathon.BOOTATHON;

public class User_login extends WindowAdapter{
    JFrame frame=new JFrame();
    JLabel lbl_home,lbl_head,lbl_username,lbl_password;
    JTextField txt_username;
    JPasswordField pf_pass;
    JButton btn_login,btn_createacc;
    Font font=new Font("Arial",Font.BOLD,18);
    Font font_1=new Font("Arial",Font.BOLD,30);
    Font font_2=new Font("Arial",Font.PLAIN,20);
    
    public void U_login(){
        Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setTitle("User Login");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        
        ImageIcon img_home= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel(img_home);
        lbl_home.setBounds(40,30,53,54);
        frame.add(lbl_home);
        
        lbl_head=new JLabel("USER LOGIN");
        lbl_head.setFont(font_1);
        lbl_head.setForeground(Color.red);
        lbl_head.setBounds(600,35,683,125);
        frame.add(lbl_head);
        
        lbl_username=new JLabel("Enter user name *");
        lbl_username.setFont(font);
        lbl_username.setBounds(400,140,350,120);
        frame.add(lbl_username);
        
        txt_username=new JTextField();
        txt_username.setFont(font_2);
        txt_username.setBounds(650,180,350,35);
        frame.add(txt_username);
        
        lbl_password=new JLabel("Enter the password *");
        lbl_password.setFont(font);
        lbl_password.setBounds(400,250,350,120);
        frame.add(lbl_password);
        
        pf_pass=new JPasswordField();
        pf_pass.setFont(font_2);
        pf_pass.setBounds(650,295,350,35);
        frame.add(pf_pass);
        
        btn_login=new JButton("LOGIN");
        btn_login.setBounds(700,400,200,40);
        btn_login.setForeground(Color.WHITE);
        btn_login.setBackground(Color.red);
        btn_login.setFont(font);
        frame.add(btn_login);
        
        btn_createacc=new JButton("Create Account");
        btn_createacc.setBounds(700,500,200,40);
        btn_createacc.setFont(font_2);
        frame.add(btn_createacc);
        
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
        
        btn_login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String Uname=txt_username.getText();
                String Pass=pf_pass.getText();
                verification val=new verification();
                String result_verify=val.verify(Uname,Pass);
                if(!result_verify.equals("SUCCESS")){
                    JOptionPane.showMessageDialog(frame, result_verify);
                }
                if(result_verify.equals("SUCCESS"))
                {
                    pf_pass.setText("");
                    txt_username.setText("");
                    frame.setVisible(false);
                    
                    user_panel up=new user_panel();
                    up.Upanel(Uname);
                }
                
            }
        });
        
        btn_createacc.addActionListener((ActionEvent e) -> {
            bdonar_regform regform=new bdonar_regform();
            frame.setVisible(false);
            regform.donar_regform();
        });
        
        frame.setVisible(true);
    }
    public static void main(String[] args){
        User_login Ulogin=new User_login();
        Ulogin.U_login();
    }
    
}

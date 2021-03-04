package management_login;

/*  -- This class controls the management's login

*/
import DB_operations.connect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.BorderFactory;
import bootathon.BOOTATHON;
public class Login extends JFrame
{
        JLabel title,user_id,password;
        JTextField type_id;
        JButton login_button,Create_button,Forget_button;
        JPasswordField type_password;
        JFrame frame =new JFrame();
        public Login()
            {   
                frame.setTitle("MANAGEMENT LOGIN");
                Dimension SCREEN_Size=Toolkit.getDefaultToolkit().getScreenSize();
                frame.setSize(SCREEN_Size.width,SCREEN_Size.height);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.white);
                Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
                frame.setIconImage(icon);
                frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));

                JLabel background;
                ImageIcon img= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\donate_blood_rotator.jpg");
                background=new JLabel("",img,JLabel.CENTER);
                background.setBounds(30,350,545,320);
                frame.add(background);
                
                JLabel background1;
                ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
                background1=new JLabel("",img1,JLabel.CENTER);
                background1.setBounds(40,30,53,54);
                background1.addMouseListener(new MouseListener(){
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
                frame.add(background1);
         
                title = new JLabel("SIGN IN AS MANAGEMENT");
                title.setForeground(Color.red);
                title.setFont(new Font("Arial", Font.BOLD, 30));
                title.setBounds(470,35,683,125);
                
                user_id = new JLabel("Enter User ID *");
                user_id.setForeground(Color.black);
                user_id.setFont(new Font("Arial", Font.BOLD, 20));
                user_id.setBounds(300,140,445,120);
                type_id = new JTextField();
                type_id.setFont(new Font("Arial", Font.PLAIN, 20));
                type_id.setBounds(640,180,400,40);
                
                password = new JLabel("Enter the Password *");
                password.setForeground(Color.black);
                password.setFont(new Font("Arial",Font.BOLD, 20));
                password.setBounds(300,210,445,120);
                type_password = new JPasswordField();
                type_password.setFont(new Font("Arial", Font.PLAIN, 20));
                type_password.setBounds(640,250,400,40);
                
                login_button = new JButton("LOGIN");
                login_button.setFont(new Font("Arial", Font.BOLD, 20));
                login_button.setForeground(Color.WHITE);
                login_button.setBackground(Color.RED);
                login_button.setBounds(760,350,250,40);
                
                Create_button = new JButton("Create New Account");
                Create_button.setFont(new Font("Arial",Font.BOLD, 20));
                Create_button.setBounds(760,440,250,40);
                
                frame.add(title);
                frame.add(user_id);
                frame.add(password);
                frame.add(type_id);
                frame.add(type_password);
                frame.add(login_button);
                frame.add(Create_button);
                login_button.addActionListener((ActionEvent e) -> {
                    String suser_id = type_id.getText();
                    String spassword = type_password.getText();
                    try 
                    {
                        int flag=0;
                        String temp=""; 
                        Connection con=connect.getconnection();
                        String query = "SELECT * FROM hospitaltable WHERE userid = ?";
                        PreparedStatement p=con.prepareStatement(query);
                        p.setString(1,suser_id);
                        ResultSet res=p.executeQuery();
                        while(res.next())
                        {
                            flag=1;
                            temp=res.getString("password");
                        }
                        if(flag==1)
                        {
                        if(temp.equals(spassword))
                        {
                        DoctorWelcome doctorWelcome = new DoctorWelcome();
                        frame.setVisible(false);                        
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(frame,"USER ID & PASSWORD DOESN'T MATCH");
                        type_id.setText("");
                        type_password.setText("");
                        }
                        }
                        else
                        {
                            if(suser_id.isEmpty() || spassword.isEmpty())
                            {
                            JOptionPane.showMessageDialog(frame,"ENTER ALL THE REQUIRED FIELDS");
                            }
                            else
                            {
                            JOptionPane.showMessageDialog(frame,"NO USER FOUND");
                            type_id.setText("");
                            type_password.setText("");
                            }
                        }
                        con.setAutoCommit(true);
                        con.close();
                    }
                    catch(SQLException ei)
                    {
                        System.out.println("--->"+ei);
                        
                    }
                  } );
                Create_button.addActionListener((ActionEvent e) -> {
                    frame.setVisible(false);
                    CreateAccount createAccount = new CreateAccount();
                });
                frame.setVisible(true);
            }
        
    public static void main(String args[])
    {
        Login login = new Login();
        
    }

}
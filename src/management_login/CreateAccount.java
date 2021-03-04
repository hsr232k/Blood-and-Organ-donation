package management_login;

/*  -- This class allows the management to create their own 
       accounts to store and view the donor's data
*/

import DB_operations.connect;
import bootathon.BOOTATHON;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.BorderFactory;
public class CreateAccount extends JFrame 
    {
        JLabel lbl_title,lbl_userid,lbl_hospitalid,lbl_password,lbl_repassword;
        JTextField text_hospitalid,text_userid;
        JButton button_createaccount;
        JPasswordField pwd_password,pwd_repassword;
        JFrame frame =new JFrame();
        CreateAccount()
            {   
                
                frame.setTitle("ACCOUNT CREATION");
                frame.setSize(1366,768);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.white);
                Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
                frame.setIconImage(icon);
                frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));


                JLabel lbl_home;
                ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
                lbl_home=new JLabel("",img1,JLabel.CENTER);
                lbl_home.setBounds(40,30,53,54);
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
                frame.add(lbl_home);
                
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
                    Login login = new Login(); 
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
                frame.add(lbl_back);
                
                lbl_title = new JLabel("CREATE USER ID AND PASSWORD");
                lbl_title.setForeground(Color.red);
                lbl_title.setFont(new Font("Arial", Font.BOLD, 30));
                lbl_title.setBounds(450,25,683,125);
                
                lbl_hospitalid = new JLabel("Enter Hospital ID *");
                lbl_hospitalid.setForeground(Color.black);
                lbl_hospitalid.setFont(new Font("Arial", Font.BOLD, 20));
                lbl_hospitalid.setBounds(400,140,400,120);
                text_hospitalid = new JTextField();
                text_hospitalid.setFont(new Font("Arial", Font.PLAIN, 20));
                text_hospitalid.setBounds(750,180,400,40);
                
                lbl_userid = new JLabel("Enter User ID *");
                lbl_userid.setForeground(Color.black);
                lbl_userid.setFont(new Font("Arial", Font.BOLD, 20));
                lbl_userid.setBounds(400,210,400,120);
                text_userid = new JTextField();
                text_userid.setFont(new Font("Arial", Font.PLAIN, 20));
                text_userid.setBounds(750,250,400,40);
                
                lbl_password = new JLabel("Enter New Password *");
                lbl_password.setForeground(Color.black);
                lbl_password.setFont(new Font("Arial", Font.BOLD, 20));
                lbl_password.setBounds(400,280,400,120);
                pwd_password = new JPasswordField();
                pwd_password.setFont(new Font("Arial", Font.PLAIN, 20));
                pwd_password.setBounds(750,320,400,40);
                
                
                lbl_repassword = new JLabel("Re-Type Password *");
                lbl_repassword.setForeground(Color.black);
                lbl_repassword.setFont(new Font("Arial",Font.BOLD, 20));
                lbl_repassword.setBounds(400,350,400,120);
                pwd_repassword = new JPasswordField();
                pwd_repassword.setFont(new Font("Arial", Font.PLAIN, 20));
                pwd_repassword.setBounds(750,390,400,40);
                
                button_createaccount = new JButton("Create Account");
                button_createaccount.setFont(new Font("Arial", Font.BOLD, 20));
                button_createaccount.setBackground(Color.RED);
                button_createaccount.setForeground(Color.white);
                button_createaccount.setBounds(900,460,200,40);
                button_createaccount.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String hospitalid=text_hospitalid.getText();
                    String userid=text_userid.getText();
                    String password=pwd_password.getText();
                    String re_type=pwd_repassword.getText();
                    String regex = "^(?=.*[0-9])"
                                        + "(?=.*[a-z])(?=.*[A-Z])"
                                        + "(?=.*[@#$!%^&+=])"
                                        + "(?=\\S+$).{8,20}$";
                    boolean pass=Pattern.matches(regex,password);
                    if(hospitalid.isEmpty() || userid.isEmpty() || password.isEmpty() || re_type.isEmpty() )
                    {
                    JOptionPane.showMessageDialog(frame,"ENTER ALL THE REQUIRED FIELDS");
                    }
                    else if(pass==false)
                    {
                    JOptionPane.showMessageDialog(frame,"Password should,\nContain at least 8 and 20 characters long\n" +
                                                        "Contain at least one digit.\n" +
                                                        "Contain at least one lower case character.\n" +
                                                        "Contain at least one upper case character.\n" +
                                                        "Contain at least on special character from [ @ # $ % ! . ].");
                    pwd_password.setText("");
                    pwd_repassword.setText("");
                    }
                    else{
                     if(password.equals(re_type))
                    {
                    try
                    {
                        int flag=0;
                        String temp="";
                        Connection con=connect.getconnection();
                        String query = "SELECT * FROM id_hospital WHERE Hospitalid = ?";
                        PreparedStatement p=con.prepareStatement(query);
                        p.setString(1,hospitalid);
                        ResultSet res=p.executeQuery();
                        while(res.next())
                        {
                        flag=1;
                        temp=res.getString("Hospitalid");
                        }
                        if(flag==1)
                        {
                        DBHospital db=new DBHospital();
                        String E=db.tablecreate(hospitalid,userid,password);
                        if(E.equals("SUCCESS"))
                        {
                        JOptionPane.showMessageDialog(frame,"ACCOUNT CREATED");
                        frame.setVisible(false);
                        Login login = new Login();
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(frame,"HOSPITAL ID OR USER ID ALREADY EXISTS");
                        text_hospitalid.setText("");
                        text_userid.setText("");
                        pwd_password.setText("");
                        pwd_repassword.setText("");
                        }
                       }
                        else
                        {
                        JOptionPane.showMessageDialog(frame,"ENTER A VALID HOSPITAL ID");
                        text_hospitalid.setText("");
                        text_userid.setText("");
                        pwd_password.setText("");
                        pwd_repassword.setText("");
                        }
                    }
                    catch(HeadlessException | SQLException eid)
                            {
                            System.out.println("--->"+eid);
                            }
                    }
                     else{
                     JOptionPane.showMessageDialog(frame,"PASSWORD AND RETYPE PASSWORD DOES NOT MATCH");
                     pwd_password.setText("");
                     pwd_repassword.setText("");
                     }
                       
                   } }
              });
                
                frame.add(lbl_title);
                frame.add(lbl_hospitalid);
                frame.add(text_hospitalid);
                frame.add(lbl_userid);
                frame.add(text_userid);
                frame.add(lbl_password);
                frame.add(pwd_password);
                frame.add(lbl_repassword);
                frame.add(pwd_repassword);
                frame.add(button_createaccount);
                frame.setVisible(true);
    }
        
    public static void main(String args[])
    {
        CreateAccount create = new CreateAccount();
        
    }
}

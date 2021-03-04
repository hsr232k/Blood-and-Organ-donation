package searchtable;

/*  -- This class allows the management to view the data about the organ 
       donars --
*/

import DB_operations.connect;
import bootathon.BOOTATHON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import management_login.DoctorWelcome;

public class EditOrganDonor extends JFrame{
    JFrame frame;
    JLabel lbl_phno,lbl_operation,lbl_title;
    JTextField tf_phno;
    Container c;
    JComboBox cb_option;
    JButton btn_execute;
    
    private String options[]={ "View","Remove"};
    
    
    public EditOrganDonor(){
        
        frame=new JFrame();
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        c=new Container();
        frame.setTitle("DONAR SEARCH");
        
        
        JLabel lbl_home;
        ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
        lbl_home=new JLabel("",img1,JLabel.CENTER);
        lbl_home.setBounds(80,20,53,54);
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
        c.add(lbl_home);
                
        JLabel lbl_back;
        ImageIcon img2= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\back.jpg");
        lbl_back=new JLabel("",img2,JLabel.CENTER);
        lbl_back.setBounds(1200,550,53,54);
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
        c.add(lbl_back);
        
        lbl_title=new JLabel("ORGAN DONOR SEARCH FORM");
        lbl_title.setFont(new Font("",Font.BOLD,30));
        lbl_title.setForeground(Color.red);
        lbl_title.setBounds(500,40,500,30);
        frame.add(lbl_title);
       
        
        lbl_phno=new JLabel("PHONE NUMBER");
        lbl_phno.setBounds(440,200,200,30);
        lbl_phno.setFont(new Font("",Font.BOLD,18));
        lbl_phno.setBackground(Color.LIGHT_GRAY);
        c.add(lbl_phno);
        
        tf_phno=new JTextField();
        tf_phno.setBounds(750,200,250,30);
        tf_phno.setBackground(Color.WHITE);
        c.add(tf_phno);
        
        lbl_operation=new JLabel("OPERATION");
        lbl_operation.setFont(new Font("",Font.BOLD,18));
        lbl_operation.setBounds(440,300,200,30);
        c.add(lbl_operation);
        
        
        cb_option=new JComboBox(options);
        cb_option.setBounds(750,300,200,30);
        cb_option.setFont(new Font("",Font.PLAIN,16));
        cb_option.setBackground(Color.WHITE);
        c.add(cb_option);
        
        btn_execute=new JButton("EXECUTE");
        btn_execute.setBounds(750,400,150,30);
        btn_execute.setFont(new Font("",Font.BOLD,18));
        btn_execute.setBackground(Color.RED);
        btn_execute.setForeground(Color.WHITE);
        c.add(btn_execute);
        btn_execute.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String ph="",oper="",query="";
                String date,name,heart,lungs,kidneys,liver,eyes;
                ph=tf_phno.getText();
                if(!ph.isEmpty() && ph.matches("\\d{10}") ){
                    oper=(String)cb_option.getSelectedItem();
                    
                try{
                Connection conn=connect.getconnection();
                Statement  st=conn.createStatement();
                
                query="select * from organreg";
                ResultSet rs = st.executeQuery(query);
                
                
                
                int flag=0;
                while(rs.next() && flag==0){
                    if(ph.equals(rs.getString("dphno"))){
                        flag=1;
                        //-------------
                    if(oper.equals("View")){
                            
                        date=rs.getString("cdate");
                        name=rs.getString("dfname")+" "+rs.getString("dlname");
                        heart=rs.getString("heart");
                        lungs=rs.getString("lungs");
                        liver=rs.getString("liver");
                        eyes=rs.getString("eyes");
                        kidneys=rs.getString("kidneys");
                        String pri="";
                        pri=pri+"\nName         : "+name+"\nReg Date   : "+date+"\n\nOgans Donating :\n";
                        pri=pri+"\n     Heart          :     "+heart+"\n     lungs          :     "+lungs+"\n     liver            :     "+liver;
                        pri=pri+"\n     Kidneys     :     "+kidneys+"\n     Eyes           :     "+eyes;
                        JOptionPane.showMessageDialog(frame,pri);
                                }//view over
                    else if(oper.equals("Remove")){
                            //System.out.println("clicked remove");
                            query="delete from organreg where dphno=?";
                            PreparedStatement ps=conn.prepareStatement(query);
                            ps.setString(1, ph);
                            ps.executeUpdate();
                            conn.setAutoCommit(true);
                            conn.close();
                            JOptionPane.showMessageDialog(frame,"REMOVED SUCCESSFULLY");
                            
                            
                    }//remove
                    }//ph crt
                     
                    else
                        flag=0;
                    
                    
                
                }//while
                if(flag==0){
                        JOptionPane.showMessageDialog(frame,"No data related to this no");
                    }
               
                    //----------------------------------------------------
                            
                }//try
                catch(Exception ex){
                    System.out.println(ex);
                }//catch
            }//valid number
                
            else{
                JOptionPane.showMessageDialog(frame,"NUMBER IS NOT VALID");
            }
            
            }//action performed
            
        });
        
        c.setBounds(frame.getBounds());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.add(c);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(0, 0,1300, 700);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
    public static void main(String args[]){
     new EditOrganDonor();
    }
    
}

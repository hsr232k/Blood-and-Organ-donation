package bootathon;
/*  -- This class allows the admin to create a new Management id or remove an 
       existing management id along with its account --
*/
import DB_operations.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class EditHospitals {
    JFrame frame;
    JLabel lbl_phno,lbl_operation,lbl_title;
    JTextField tf_hid;
    Container c;
    JComboBox cb_option;
    JButton btn_execute;
    private String options[]={ "Insert","Remove"};
    EditHospitals(){
        frame=new JFrame("EDIT MANAGEMENT");
        frame.getRootPane().setBorder (BorderFactory.createMatteBorder(4,4,4,4, Color.RED));
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\blood.png");    
        frame.setIconImage(icon);
        c=new Container();
        JLabel background1;
                ImageIcon img1= new ImageIcon("D:\\BOOTCAMP\\BOOTATHON_1\\Assets\\home.jpg");
                background1=new JLabel("",img1,JLabel.CENTER);
                background1.setBounds(80,20,53,54);
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
                c.add(background1);
                
        lbl_title=new JLabel("ADMIN CONTROL PANEL");
        lbl_title.setFont(new Font("Arial",Font.BOLD,25));
        lbl_title.setForeground(Color.red);
        lbl_title.setBounds(550,60,350,60);
        frame.add(lbl_title);
       
        lbl_phno=new JLabel("HOSPITAL ID");
        lbl_phno.setFont(new Font("Arial",Font.BOLD,18));
        lbl_phno.setBounds(500,200,120,30);
        lbl_phno.setBackground(Color.LIGHT_GRAY);
        c.add(lbl_phno);
        
        tf_hid=new JTextField();
        tf_hid.setBounds(700,200,200,30);
        tf_hid.setFont(new Font("Arial",Font.PLAIN,18));
        tf_hid.setBackground(Color.WHITE);
        c.add(tf_hid);
        
        lbl_operation=new JLabel("OPERATION");
        lbl_operation.setFont(new Font("Arial",Font.BOLD,18));
        lbl_operation.setBounds(500,300,120,30);
        c.add(lbl_operation);
        
        cb_option=new JComboBox(options);
        cb_option.setBounds(700,300,200,30);
        cb_option.setFont(new Font("Arial",Font.PLAIN,18));
        cb_option.setBackground(Color.WHITE);
        c.add(cb_option);
        
        btn_execute=new JButton("EXECUTE");
        btn_execute.setBounds(750,400,100,30);
        btn_execute.setBackground(Color.RED);
        btn_execute.setForeground(Color.WHITE);
        c.add(btn_execute);
        btn_execute.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String hid="",oper="",query="";
                String date,name,heart,lungs,kidneys,liver,eyes;
                hid=tf_hid.getText();
                if(!hid.isEmpty()){
                    oper=(String)cb_option.getSelectedItem();
                    
                try{
                Connection conn=connect.getconnection();
                Statement  st=conn.createStatement();
                
                query="select * from id_hospital";
                ResultSet rs = st.executeQuery(query);
                 
                int flag=0;
                while(rs.next() && flag==0){
                    if(hid.equals(rs.getString("Hospitalid"))){
                        flag=1;
                        //-------------
                    if(oper.equals("Insert")){
                            
                        
                        JOptionPane.showMessageDialog(frame,"ID ALREADY EXISTS");
                                }//view over
                    else if(oper.equals("Remove")){
                            //System.out.println("clicked remove");
                            query="Delete from id_hospital where Hospitalid=?";
                            PreparedStatement ps=conn.prepareStatement(query);
                            ps.setString(1, hid);
                            ps.executeUpdate();
                            query="Delete from hospitaltable where hospitalid=?";
                            ps=conn.prepareStatement(query);
                            ps.setString(1, hid);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(frame,"REMOVED SUCCESSFULLY");                            
                            
                    }//remove
                    }//hospital found
                     
                    else
                        flag=0;
                    
                }//while
                if(flag==0){
                    
                    if(oper.equals("Insert")){
                        query="insert into id_hospital values(?)";
                        PreparedStatement ps=conn.prepareStatement(query);
                        ps.setString(1, hid);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(frame,"DATA INSERTED SUCCESSFULLY");
                    }
                    
                    else if(oper.equals("Remove"))
                        JOptionPane.showMessageDialog(frame,"NO DATA RELATED TO THIS HOSPITAL ID");
                    }
                        conn.setAutoCommit(true);
                        conn.close();  
            }//try
            catch( SQLException ex){
                System.out.println(ex);
            }//catch
                }//valid number
                
                else{
                    JOptionPane.showMessageDialog(frame,"ENTER AN HOSPITAL ID");
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
        new EditHospitals();
 
    }
    
}

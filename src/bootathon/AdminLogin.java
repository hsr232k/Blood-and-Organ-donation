package bootathon;
/*  -- This class is to control the login provided to Admins --

*/
import javax.swing.*;
public class AdminLogin {
    JFrame frame;
    JLabel jpassword = new JLabel("Password");
    JTextField password = new JPasswordField();
    Object[] ob={jpassword,password};
    String passwordValue;  
    AdminLogin()
    {  
       
        int result = JOptionPane.showConfirmDialog(null, ob, "ENTER THE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){
            passwordValue = password.getText();
            if(AdminLogin.checkPassword(passwordValue)){
                EditHospitals editHospitals = new EditHospitals(); 
            }
            else{
                JOptionPane.showMessageDialog(frame,"ACCESS DENIED");
                BOOTATHON boot=new BOOTATHON();
                boot.welcome_page(); 
            }
        }
        else if (result == JOptionPane.CANCEL_OPTION){
            BOOTATHON boot=new BOOTATHON();
            boot.welcome_page();
        }
        else if(result == JOptionPane.CLOSED_OPTION){
            BOOTATHON boot=new BOOTATHON();
            boot.welcome_page();
        }
    }
    public static boolean checkPassword(String s){
        if(s.equals("12345")){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {  
        AdminLogin adminLogin = new AdminLogin();  
    }        
}

package organRegForm;

/*  -- This class is to validate the organ donors data, which is 
       provided by the management --
*/

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
public class Operations{
 
public String btos(boolean x){
    if(x==true)
        return "Yes";
    else
        return"No";
    
}

public boolean checkName(String fn,String ln){
    String f="First Name";
    String l="Last Name";
    if(fn.equals(f) || fn.equals(""))
        return false;
    if(ln.equals("") || ln.equals(l))
        return false;
    return true;
}

public boolean checkPh(String ph){
    Boolean flag;
    if(ph.length()==10){
        for(int i=0;i<10;i++){
            flag = Character.isDigit(ph.charAt(i));
            if(flag==false){
                return false;
            }
        }
        return true;          
    }
    return false;
 }


public boolean checkAltPh(String ph){
    Boolean flag;
    if(ph.length()==10){
        for(int i=0;i<10;i++){
            flag = Character.isDigit(ph.charAt(i));
            if(flag==false){
                return false;
            }
        }
        return true;          
    }
    else if(ph.length()==0)
        return true;
    else
        return false;
 }

public boolean checkMail(String m){
    return true;
}

public boolean checkGender(String g){
    if(g=="Null")
        return false;
    else
        return true;
}

public boolean checkAuthorise(String a){
    if(a=="Null")
        return false;
    else
        return true;
}

public boolean checkBg(String bg){
    if(bg=="---")
        return false;
    else 
        return true;
}

public boolean checkDOB(String d,String m,String y){
    if(d=="--" || m=="---" ||y=="----")
        return false;
    else
        return true;
}

public boolean checkOrgans(boolean all,boolean heart,boolean lungs,boolean liver,boolean kidneys,boolean eyes){
    if(all==true || heart==true || liver==true || kidneys==true || lungs==true || eyes==true){
        return true;
    }
    
    return false;
}

public boolean checkAddress(String a){
    return true;
}



 public static String currentdate(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
    }
 
}


package organRegForm;

/*  -- This class is to validate the organ donors data, which is 
       provided by the management --
*/

public class Validate {
    
    public String validate( String df,String dl,String gf,String gl,String dph,String daltph,String gph,String g,String a,String bg,String d,String m,String y,boolean all,boolean heart,boolean lungs,boolean liver,boolean kidneys,boolean eyes){
    Operations op=new Operations();
    String res="";

    if(op.checkName(df,dl)==false)//---------------------------donor name
        return "PLEASE ENTER A VALID DONAR NAME\n";

    if(op.checkGender(g)==false)//-----------------------------gender
        return "PLEASE SELECT A GENDER\n";

    if(op.checkDOB(d, m, y)==false)//--------------------------dob
        return "PLEASE SELECT A DATE OF BIRTH PROPERLY\n";

    if(op.checkBg(bg)==false)//--------------------------------bloodgrp
        return "PLEASE SELECT A DATE OF BIRTH\n";

    if(op.checkAddress("")==false)//---------------------------address
        return "PLEASE ENTER ADDRESS\n";

    if(op.checkPh(dph)==false)//-------------------------------dphno
        return "PLEASE ENTER A VALID DONOR PHONE NUMBER\n";

    if(op.checkAltPh(daltph)==false)//-------------------------daltphno
        return "PLEASE ENTER A VALID ALTERNATE PHONE NUMBER OR ELSE MAKE THE FIELD EMPTY\n";

    if(op.checkMail("")==false)//------------------------------mail
        return "PLEASE ENTER VALID MAIL ID\n";

    if(op.checkName(gf, gl)==false)//--------------------------guardian name
        return "PLEASE ENTER A VALID GUARDIAN NAME\n";

    if(op.checkPh(gph)==false)//---------------------------gphno
        return "PLEASE ENTER A VALID GUARDIAN PHONE NUMBER\n";

    if(op.checkOrgans(all,heart,lungs,liver,kidneys,eyes)==false)//----organs
        return "PLEASE SELECT ATLEAST ONE OF THE ORGANS\n";

    if(op.checkAuthorise(a)==false)//--------------------------------authorise
        return "PLEASE SELECT AN AUTHORISE FIELD\n";

    return res;
    } 
}

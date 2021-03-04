package blooddonar_regform;
/*  -- This class is used to validate the data provided by the user during their
       account creation --
*/
public class field_validation {   
    String regex_pass="^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$!%^&+=])"+ "(?=\\S+$).{8,16}$";
    public String valid(String name,String userid,String pass,String retype_pass,String age,String weight,String gender,String bgroup,String district,String address,String phno,String alt_phno,String email ,String pincode){
        if(name.isEmpty()||userid.isEmpty()||pass.isEmpty()||retype_pass.isEmpty()||age.isEmpty()||weight.isEmpty()||gender.isEmpty()||bgroup.isEmpty()||district.equals("--")||address.isEmpty()||phno.isEmpty()||email.isEmpty()||pincode.isEmpty()){
            return "PLEASE FILL EVERY FIELD";
        }else if (name.length()<3)
        {
            return "NAME SHOULD CONTAIN ATLEAST 2 CHARACTERS";
        }
        else if (name.length()>20){
            return "NAME SHOULD NOT EXCEED 20 CHARACTERS";
        }
        else if(userid.length()>20){
            return "USER ID SHOULD NOT EXCEED 20 CHARACTERS";
        }
        else if(name.matches(".*[0-9].*")){
            return "YOUR NAME MUST CONTAIN ONLY ALHABETS";
        }
        else if(!pass.matches(regex_pass)){
            return "Password should,\nContain at least 8 and 20 characters long\n" +
                                                        "Contain at least one digit.\n" +
                                                        "Contain at least one lower case character.\n" +
                                                        "Contain at least one upper case character.\n" +
                                                        "Contain at least on special character from [ @ # $ % ! . ].";
        }
        else if(!pass.equals(retype_pass)){
            return "PASSWORD AND RETYPE PASSWORD DOESN'T MATCH";
        }
        int i_age,i_weight;
        try{
           i_age= Integer.parseInt(age);
        }
        catch(NumberFormatException e){
            System.out.println(e);
            return "INVALID AGE";
        }
        try{
            i_weight=Integer.parseInt(weight);
        }
        catch(NumberFormatException e){
            System.out.println(e);
            return "INVALID WEIGHT";   
        }
        if(i_age<18){
            return "YOU ARE NOT ELIGIBLE TO DONATE BLOOD";
        }
        else if(i_age>65){
            return "YOU ARE NOT ELIGIBLE TO DONATE BLOOD";
        }
        else if(i_weight<=45){
            return "YOU ARE NOT ELIGIBLE TO DONATE BLOOD";
        }
        else if(i_weight>150){
            return "YOU ARE NOT ELIGIBLE TO DONATE BLOOD";    
        }
        else if(bgroup.equals("--")){
            return "PLEASE SELECT A BLOOD GROUP";
        }
        else if(district.equals("--")){
            return "PLEASE SELECT A DISTRICT";
        }
        else if(!phno.matches("\\d{10}")){
            return "INVALID PHONE NUMBER";
        }
        else if(!alt_phno.matches("\\d{10}")){
                return "INVALID ALTERNATE PHONE NUMBER";
        }
        else if(!pincode.matches("\\d{6}")){
            return "INVALID PIN CODE";
        }
        else{
            return "SUCCESSFULLY REGISTERED";
        }
    }
}

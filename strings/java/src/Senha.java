import java.util.regex.*;

public class Senha {
	
    public static void main(String[] args) {
        System.out.println(validatePassword("amerca1@"));
        System.out.println(validatePassword("amrca154682"));
    }

    public static boolean validatePassword(String str) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@&#]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}

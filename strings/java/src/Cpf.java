public class Cpf {

	public static String removeNonDigits(String str) {
		
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String removeNonDigits2(String str) {
        String regex = "\\D";
        return str.replaceAll(regex, "");
    }
	
    public static void main(String[] args) {

        System.out.println(removeNonDigits("949.237.847-99"));
        System.out.println(removeNonDigits2("949.237.847-99"));
    }
}

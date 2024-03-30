public class Data2 {

    public static String formatDate(int day, int month, int year) {
        String formatDay = String.format("%02d", day);
        String formatMonth = String.format("%02d", month);

        return formatDay + "/" + formatMonth + "/" + year;
    }

    public static void main(String[] args) {
        System.out.println(formatDate(21, 7, 2010));
    }
}

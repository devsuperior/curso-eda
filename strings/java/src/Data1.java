public class Data1 {

	public static DateData extractDateData(String date) {

		String[] parts = date.split("/");

		int day = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);

		return new DateData(day, month, year);
	}

	public static void main(String[] args) {
		DateData obj = extractDateData("21/07/2010");
		System.out.println("Dia: " + obj.day);
		System.out.println("Mês: " + obj.month);
		System.out.println("Ano: " + obj.year);
	}
}

class DateData {
	int day;
	int month;
	int year;

	public DateData(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}


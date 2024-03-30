import java.util.Locale;

public class DemoLiterals {

	public static void main(String[] args) {

		String name = "Alice";
		int age = 31;
		double points = 8.347;

		// Simple literal
		String str1 = "Olá, mundo!";
		System.out.println("str1:\n" + str1);

		// Concatenation
		String str2 = "Cliente " + name + " tem idade " + age + " anos e fez " + points + " pontos.";
		System.out.println("\nstr2:\n" + str2);

		// Escape characters
		String str3 = "Cliente: " + name + "\nIdade: " + age;
		String str4 = "c:\\Program Files\\Windows";
		String str5 = "Senha = \"carro123\"";
		// @formatter:off
		String str6 = "<html>\n" 
			+ "\t<body>\n" 
	        + "\t\t<p>Hello, World!</p>\n" 
	        + "\t</body>\n" 
	        + "</html>\n";
		// @formatter:on
		System.out.println("\nstr3:\n" + str3);
		System.out.println("\nstr4:\n" + str4);
		System.out.println("\nstr5:\n" + str5);
		System.out.println("\nstr6:\n" + str6);

		// StringBuilder or StringBuffer (thread-safe)
		StringBuilder sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("\t<body>\n");
		sb.append("\t\t<p>Hello, World!</p>\n");
		sb.append("\t</body>\n");
		sb.append("</html>\n");
		String str7 = sb.toString();
		System.out.println("\nstr7:\n" + str7);

		// Text block
		String str8 = """
				<html>
					<body>
						<p>Hello, World!</p>
					</body>
				</html>
				""";
		System.out.println("\nstr8:\n" + str8);

		// String format
		String str9 = String.format("Cliente %s tem idade %d anos e fez %.2f pontos.", name, age, points);
		String str10 = String.format(Locale.US, "Cliente %s tem idade %d anos e fez %.2f pontos.", name, age, points);
		String str11 = String.format("""
				<html>
					<body>
						<p>Hello, World %s! Parabéns pelos %d anos!</p>
					</body>
				</html>
				""", name, age);
		System.out.println("\nstr9:\n" + str9);
		System.out.println("\nstr10:\n" + str10);
		System.out.println("\nstr11:\n" + str11);
	}
}

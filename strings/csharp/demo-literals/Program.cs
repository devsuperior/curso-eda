using System.Globalization;
using System.Text;

namespace MyApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string name = "Alice";
            int age = 31;
            double points = 8.347;

            // Simple literal
            string str1 = "Olá, mundo!";
            Console.WriteLine("str1:\n" + str1);

            // Concatenation
            string str2 = "Cliente " + name + " tem idade " + age + " anos e fez " + points + " pontos.";
            Console.WriteLine("\nstr2:\n" + str2);

            // Escape characters
            string str3 = "Cliente: " + name + "\nIdade: " + age;
            string str4 = "c:\\Program Files\\Windows";
            string str5 = "Senha = \"carro123\"";
            string str6 = "<html>\n"
                + "\t<body>\n"
                + "\t\t<p>Hello, World!</p>\n"
                + "\t</body>\n"
                + "</html>\n";
            Console.WriteLine("\nstr3:\n" + str3);
            Console.WriteLine("\nstr4:\n" + str4);
            Console.WriteLine("\nstr5:\n" + str5);
            Console.WriteLine("\nstr6:\n" + str6);

            // Interpolation
            string str7 = $"Cliente {name} tem idade {age} anos e fez {points} pontos.";
            Console.WriteLine("\nstr7:\n" + str7);

            // Verbatim strings
            string str8 = @"c:\Program Files\Windows";
            string str9 = @"Senha = ""carro123""";
            string str10 =
@"<html>
    <body>
        <p>Hello, World!</p>
    </body>
</html>
";
            string str11 =
$@"<html>
    <body>
        <p>Hello, World {name}!</p>
    </body>
</html>
";
            Console.WriteLine("\nstr8:\n" + str8);
            Console.WriteLine("\nstr9:\n" + str9);
            Console.WriteLine("\nstr10:\n" + str10);
            Console.WriteLine("\nstr11:\n" + str11);

            // String literals multilines

            string str12 = """
                <html>
                    <body>
                        <p>Hello, World!</p>
                    </body>
                </html>
                """;

            string str13 = $"""
                <html>
                    <body>
                        <p>Hello, World {name}!</p>
                    </body>
                </html>
                """;

            Console.WriteLine("\nstr12:\n" + str12);
            Console.WriteLine("\nstr13:\n" + str13);

            // Number format
            string str14 = $"Cliente {name} fez {points:F2} pontos.";
            string str15 = $"Cliente {name} fez {points.ToString("F2", CultureInfo.InvariantCulture)} pontos.";
            Console.WriteLine("\nstr14:\n" + str14);
            Console.WriteLine("\nstr15:\n" + str15);

            // StringBuilder
            StringBuilder sb = new StringBuilder();
            sb.Append("<html>\n");
            sb.Append("\t<body>\n");
            sb.Append("\t\t<p>Hello, World!</p>\n");
            sb.Append("\t</body>\n");
            sb.Append("</html>\n");
            string str16 = sb.ToString();
            Console.WriteLine("\nstr16:\n" + str16);

        }
    }
}

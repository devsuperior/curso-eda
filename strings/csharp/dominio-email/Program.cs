class Program {
    public static void Main(string[] args) {

        EmailInfo emailInfo1 = ExtractEmailInformation("joao.silva23@yahoo.com.br");
        Console.WriteLine($"Usuario: {emailInfo1.Username}");
        Console.WriteLine($"Dominio: {emailInfo1.Domain}");
        Console.WriteLine($"Brasileiro: {(emailInfo1.IsBrazilian ? "sim" : "nao")}");

        EmailInfo emailInfo2 = ExtractEmailInformation("maria123@gmail.com");
        Console.WriteLine($"Usuario: {emailInfo2.Username}");
        Console.WriteLine($"Dominio: {emailInfo2.Domain}");
        Console.WriteLine($"Brasileiro: {(emailInfo2.IsBrazilian ? "sim" : "nao")}");
    }

    public static EmailInfo ExtractEmailInformation(string email) {

        string[] parts = email.Split('@');
        string username = parts[0];
        string domain = parts[1];

        bool isBrazilian = domain.EndsWith(".br");

        return new EmailInfo(username, domain, isBrazilian);
    }

    public class EmailInfo {
        public string Username { get; }
        public string Domain { get; }
        public bool IsBrazilian { get; }

        public EmailInfo(string username, string domain, bool isBrazilian) {
            Username = username;
            Domain = domain;
            IsBrazilian = isBrazilian;
        }
    }
}

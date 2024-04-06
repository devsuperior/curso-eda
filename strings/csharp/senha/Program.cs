using System.Text.RegularExpressions;

class Program {
    
    static void Main() {
        Console.WriteLine(ValidatePassword("amerca1@"));
        Console.WriteLine(ValidatePassword("amrca154682"));
    }

    static bool ValidatePassword(string str) {
        string regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@&#]).{8,}$";
        return Regex.IsMatch(str, regex);
    }
}

import java.util.Locale;

public class DemoString2 {

    public static void main(String[] args) {
    	
        String str1 = "Hello, World!";
        String str2 = "Java,String,Split,Example";
        String str3 = "  Maria Red     ";
        
    	System.out.println("str1: \"" + str1 + "\"");
    	System.out.println("str2: \"" + str2 + "\"");
    	System.out.println("str3: \"" + str3 + "\"");

        // charAt(int index)
        System.out.println("str1.charAt(0): " + str1.charAt(0)); // H
        
        // substring(int beginIndex)
        System.out.println("str1.substring(7): " + str1.substring(7)); // World!
        
        // substring(int beginIndex, int endIndex)
        System.out.println("str1.substring(0, 5): " + str1.substring(0, 5)); // Hello
        
        // split(String regex)
        String[] parts = str2.split(",");
        System.out.print("str2.split(\",\"): ");
        for (String str : parts) {
        	System.out.print(str + " ");
        }
        System.out.println();
        
        // split(String regex, int limit)
        String[] partsLimited = str2.split(",", 2);
        System.out.print("str2.split(\",\", 2): ");
        for (String str : partsLimited) {
        	System.out.print(str + " ");
        }
        System.out.println();
        
        // trim()
        System.out.println("str3.trim(): \"" + str3.trim() + "\""); // 'Trim me'
        
        // toLowerCase()
        System.out.println("str1.toLowerCase(): " + str1.toLowerCase()); // hello, world!
        
        // toUpperCase()
        System.out.println("str1.toUpperCase(): " + str1.toUpperCase()); // HELLO, WORLD!
        
        // replace(char oldChar, char newChar)
        System.out.println("str1.replace('l', 'p'): " + str1.replace('l', 'p')); // Heplo, Worpd!
        
        // replaceAll(String regex, String replacement)
        System.out.println("str1.replaceAll(\"o\", \"X\"): " + str1.replaceAll("o", "X")); // HellX, WXrld!
        
        // replaceFirst(String regex, String replacement)
        System.out.println("str1.replaceFirst(\"o\", \"X\"): " + str1.replaceFirst("o", "X")); // HellX, World!
        
        // toCharArray()
        char[] charArray = str1.toCharArray();
        System.out.print("str1.toCharArray(): ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        // valueOf(Various Types)
        System.out.println("String.valueOf(123): " + String.valueOf(123)); // 123
        
        // matches(String regex)
        System.out.println("str1.matches(\"Hello, World!\"): " + str1.matches("Hello, World!")); // true
        System.out.println("str1.matches(\"World\"): " + str1.matches("World")); // true
        System.out.println("str1.matches(\".*World.*\"): " + str1.matches(".*World.*")); // true
        
        // concat(String str)
        System.out.println("str1.concat(\" Yeah!\"): " + str1.concat(" Yeah!")); // Hello, World! Yeah!

        // join(delimiter, elements)
        String[] words = { "banana", "abacate", "morango" };
        System.out.println("String.join(\"-\", words): " + String.join("-", words)); // Java String Split Example
        
        // format(Locale, format, text)
        System.out.println("String.format(Locale.US, \"%.2f\", 2.345): " + String.format(Locale.US, "%.2f", 2.345));
     }
}

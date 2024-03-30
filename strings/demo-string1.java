public class DemoString1 {
    public static void main(String[] args) {
    	
    	String str1 = "Hello, ";
    	String str2 = "World!";
    	String str3 = "This is a test. Testing, test one, two, three.";
    	String str4 = "HELLO, ";

    	System.out.println("str1: \"" + str1 + "\"");
    	System.out.println("str2: \"" + str2 + "\"");
    	System.out.println("str3: \"" + str3 + "\"");
    	System.out.println("str4: \"" + str4 + "\"");
    	
        // length()
        System.out.println("str1.length(): " + str1.length());

        // isEmpty()
        System.out.println("str1.isEmpty(): " + str1.isEmpty());

        // equals(Object anObject)
        System.out.println("str1.equals(str2): " + str1.equals(str2));

        // equalsIgnoreCase(String anotherString)
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));
        System.out.println("str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4));

        // compareTo(String anotherString)
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));
        System.out.println("str1.compareTo(str4): " + str1.compareTo(str4));

        // compareToIgnoreCase(String str)
        System.out.println("str1.compareToIgnoreCase(str2): " + str1.compareToIgnoreCase(str2));
        System.out.println("str1.compareToIgnoreCase(str4): " + str1.compareToIgnoreCase(str4));

        // startsWith(String prefix)
        System.out.println("str1.startsWith(\"He\"): " + str1.startsWith("He"));

        // endsWith(String suffix)
        System.out.println("str2.endsWith(\"rld!\"): " + str2.endsWith("rld!"));

        // contains(CharSequence s)
        System.out.println("str2.contains(\"World\"): " + str2.contains("World"));

        // indexOf(int ch)
        // indexOf(int ch, int fromIndex)
        System.out.println("str3.indexOf('y'): " + str3.indexOf('y'));
        System.out.println("str3.indexOf('t'): " + str3.indexOf('t'));
        System.out.println("str3.indexOf('t', 11): " + str3.indexOf('t', 11));
        System.out.println("str3.indexOf('t', 42): " + str3.indexOf('t', 42));

        // indexOf(String str)
        // indexOf(String str, int fromIndex)
        System.out.println("str3.indexOf(\"bla\"): " + str3.indexOf("bla"));
        System.out.println("str3.indexOf(\"test\"): " + str3.indexOf("test"));
        System.out.println("str3.indexOf(\"test\", 11): " + str3.indexOf("Test", 11));
        System.out.println("str3.indexOf(\"test\", 30): " + str3.indexOf("Test", 30));

        // lastIndexOf(int ch)
        // lastIndexOf(int ch, int fromIndex)
        System.out.println("str3.lastIndexOf('t'): " + str3.lastIndexOf('t'));
        System.out.println("str3.lastIndexOf('t', 15): " + str3.lastIndexOf('t', 15));
        System.out.println("str3.lastIndexOf('t', 5): " + str3.lastIndexOf('t', 5));

        // lastIndexOf(String str)
        // lastIndexOf(String str, int fromIndex)
        System.out.println("str3.lastIndexOf(\"test\"): " + str3.lastIndexOf("test"));
        System.out.println("str3.lastIndexOf(\"test\", 15): " + str3.lastIndexOf("test", 15));
        System.out.println("str3.lastIndexOf(\"test\", 5): " + str3.lastIndexOf("test", 5));
    }
}

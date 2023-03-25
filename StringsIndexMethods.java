import javax.swing.*;

public class StringsIndexMethods {

    public static void main(String args[])

    {

        String letters = "abcdefghijklmabcdefghijklm";

        // test indexOf to locate a character in a string

        String output = "'c' is located at index " + letters.indexOf('c');
        output += "\n'a' is located at index " + letters.indexOf('a', 1);

        output += "\n'$' is located at index " + letters.indexOf('$');
        // test lastIndexOf to find a character in a string
        output += "\n\nLast 'c' is located at index " +
                letters.lastIndexOf('c');
        output += "\nLast 'a' is located at index " +
                letters.lastIndexOf('a', 25);
        output += "\nLast '$' is located at index " +
                letters.lastIndexOf('$');
        // test indexOf to locate a substring in a string

        output += "\n\n\"def\" is located at index " +

                letters.indexOf("def");

        output += "\n\"def\" is located at index " +

                letters.indexOf("def", 7);
        output += "\n\"hello\" is located at index " +
                letters.indexOf("hello");
        // test lastIndexOf to find a substring in a string
        output += "\n\nLast \"def\" is located at index " +

                letters.lastIndexOf("def");
        output += "\nLast \"def\" is located at index " +
                letters.lastIndexOf("def", 25);
        output += "\nLast \"hello\" is located at index " +
                letters.lastIndexOf("hello");
        JOptionPane.showMessageDialog(null, output, "String searching methods", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
} // end class StringIndexMethods
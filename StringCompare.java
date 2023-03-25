
\[import javax.swing.JOptionPane;

public class StringCompare {

    public static void main(String args[]) {

        String s1 = new String("tello"); // s1 is a copy of "hello"

        String s2 = "vello";
        String s3 = "HAPPY BIRTHDAY";
        String s4 = "happy birthday";
        String output = "s1 = " + s1 + "\ns2 = " + s2 + "\ns3 = " + s3 + "\ns4 = " + s4 + "\n\n";

        // test for equality

        if (s1.equals("hello")) // true

            output += "s1 equals \"hello\"\n";

        else
            output += "s1 does not equal \"hello\"\n";

        // test for equality with ==

        if (s1 == "hello") // false; they are not the same object

            output += "s1 equals \"hello\"\n";

        else

            output += "s1 does not equal \"hello\"\n";

        // test for equality (ignore case)

        if (s3.equalsIgnoreCase(s4)) // true

            output += "s3 equals s4\n";

        else

            output += "s3 does not equal s4\n";

        // test compareTo

        output += "\ns1.compareTo( s2 ) is " + s1.compareTo(s2) +

                "\ns2.compareTo( s1 ) is " + s2.compareTo(s1) +

                "\ns1.compareTo( s3) is " + s1.compareTo(s3) +

                "\ns3.compareTo( s4 ) is " + s3.compareTo(s4) +

                "\ns4.compareTo( s3 ) is " + s4.compareTo(s3) + "\n\n";

        // test regionMatches (case sensitive)

        if (s3.regionMatches(6, s4, 6, 5))

            output += "First 5 characters of s3 and s4 match\n";

        else

            output += "First 5 characters of s3 and s4 do not match\n";

        // test regionMatches (ignore case)

        if (s3.regionMatches(true, 6, s4, 6, 5))

            output += "First 5 characters of s3 and s4 match";

        else

            output += "First 5 characters of s3 and s4 do not match";

        JOptionPane.showMessageDialog(null, output,

                "String comparisons", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);

    }

} // end class StringCompare
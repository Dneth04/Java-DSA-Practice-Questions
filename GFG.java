import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Scanner sc = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String s1[] = new String[T];
        for (int i = 0; i < T; i++) {
            s1[i] = in.nextLine();
        }
        for (String j : s1) {
            boolean containsDigit = false;
            boolean containsUppercase = false;
            for (int i = 0; i < j.length(); i++) {
                if (Character.isDigit((j.charAt(i)))) {
                    containsDigit = true;
                }
                if (Character.isUpperCase(j.charAt(i))) {
                    containsUppercase = true;
                }
            }
            if (containsDigit == true && containsUppercase == true) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }

    }
}

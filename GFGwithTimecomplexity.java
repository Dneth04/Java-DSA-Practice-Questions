import java.util.Scanner;

public class GFGwithTimecomplexity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine(); // consume the newline character left by nextInt()

        while (T-- > 0) {
            String s = in.nextLine();
            boolean containsDigit = false;
            boolean containsUppercase = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    containsDigit = true;
                }
                if (Character.isUpperCase(c)) {
                    containsUppercase = true;
                }
            }
            if (containsDigit && containsUppercase) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}

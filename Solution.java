public class Solution {
    public static void main(String[] args) {
        Solution.validString(2, "aAu");
    }

    public static int validString(int N, String S) {
        boolean flag = false;
        // S="aapA";
        for (int i = 0; i < N; i++) {
            char y = S.charAt(i);
            if (Character.isLowerCase(y)) {
                flag = true;
                if (flag == true) {
                    while (S.charAt(i + 1) == S.charAt(N - 1)) {
                        char p = S.charAt(i + 1);
                        if (Character.isUpperCase(p)) {
                            flag = true;
                            break;

                        }
                    }

                }
            }
        }

        if (flag == true) {
            return 1;

        }
        return 1;

    }

}

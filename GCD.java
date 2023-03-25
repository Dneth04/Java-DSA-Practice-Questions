import java.util.Scanner;

public class GCD {
    public static void main(String args[]) {
        Scanner gc = new Scanner(System.in);
        int n1 = gc.nextInt();
        int n2 = gc.nextInt();
        int lcm = 0;
        int max;
        int gcd;
        int i;
        if (n1 > n2)
            max = n1;
        else
            max = n2;
        for (i = 0;; i++) {
            if (max % n1 == 0 && max % n2 == 0) {
                lcm = max;
                break;
            }
            max++;
        }
        gcd = (n1 * n2) / lcm;
        System.out.println("The lcm is " + lcm);
        System.out.println("The GCD is " + gcd);
    }
}
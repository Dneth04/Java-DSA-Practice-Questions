import java.util.*;

class FiboSquence1 {
    int num;

    public FiboSquence1(int x) {
        num = x;
    }

    int Calc(int n) {
        if (n == 1 || n == 0)
            return 0;
        else if (n == 2)
            return 1;
        // else if (n > 2)
        return Calc(n - 1) + Calc(n - 2);
    }

    public static void main(String args[]) {
        Scanner fb = new Scanner(System.in);
        System.out.println("Enter the nth position to print nth member of fibonacii");
        int n = fb.nextInt();
        FiboSquence1 b1 = new FiboSquence1(n);
        System.out.println(b1.Calc(n));
    }
}

import java.util.*;

public class Lowercasecheck {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        char charc = inp.next().charAt(0);
        if (charc >= 97 && charc <= 122) {
            System.out.println("Lower case");
        } else
            System.out.println("uppercase");

    }
}
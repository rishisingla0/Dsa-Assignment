package Week2;

import java.util.Scanner;

public class UpperToLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an uppercase character: ");
        char ch = sc.next().charAt(0);

        char lower = Character.toLowerCase(ch);

        System.out.println("Lowercase character: " + lower);

        sc.close();
    }
}

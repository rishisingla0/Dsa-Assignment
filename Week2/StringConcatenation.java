package Week2;

import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        String result = str1 + str2;

        System.out.println("Concatenated string: " + result);

        sc.close();
    }
}

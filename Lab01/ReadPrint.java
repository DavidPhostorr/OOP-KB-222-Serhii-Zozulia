package Lab01;

import java.util.Scanner;

public class ReadPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок:");
        String inputString = scanner.nextLine();
        System.out.println("Hello, " + inputString);
        scanner.close();
    }
}
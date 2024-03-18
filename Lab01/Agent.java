package Lab01;

import java.util.Scanner;

public class Agent {
    private final static int password = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password:");
        int pass = scanner.nextInt();
        scanner.close();

        if (pass == password){
            System.out.println("Hello, Agent");
        }
        else {
            System.out.println("Access denied");
        }
    }
}

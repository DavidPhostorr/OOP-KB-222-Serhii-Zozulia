package Lab01;

import java.util.Scanner;

public class Strangers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість незнайомців: ");
        int NumStrangers = scanner.nextInt();
        
        if (NumStrangers <= 0) {
            System.out.println("Неправильне число");
        }
        else {
            scanner.nextLine();
            for (int i = 1; i <= NumStrangers; i++) {
                System.out.println("Введіть ім'я незнайомців " + i + ":");
                String StrangerName = scanner.nextLine();
                System.out.println("Hello, " + StrangerName);
            }
        }
        scanner.close();
    }
}

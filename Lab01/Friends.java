package Lab01;

import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть загальну суму рахунку:");
        double total =  scanner.nextDouble();

        System.out.println("Введіть кількість друзів: ");
        int friend = scanner.nextInt();

        if (total <= 0 || friend <= 0) {
            System.out.println("Невірна сума рахунку або кількість друзів"); 
        }
        else {
            double pay = (total * 1.1) / friend;
            System.out.println("Результат: " + pay);
        }
        scanner.close();
    }
}

package Lab01;

import java.util.Scanner;

public class Valuefinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть полслідовність цілих значень. В кінці введіть 0 для завершення");
        int max = Integer.MIN_VALUE;

        while (true) {
            int current = scanner.nextInt();

            if (current == 0) {
                break;
            }
            
            if (current > max) {
                max = current;
            }
        }

        System.out.println("Результат: " + max);

        scanner.close();
    }
}

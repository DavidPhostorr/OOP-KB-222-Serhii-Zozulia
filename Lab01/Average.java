package Lab01;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть полслідовність цілих значень. В кінці введіть 0 для завершення");
        int sum = 0;
        int count = 0;

        while (true) {
            int current = scanner.nextInt();

            if (current == 0) {
                break;
            }

            sum += current;
            count++;
        }

        double average = (double) sum / count;
        System.out.println("Реузльтат: " + average);
        scanner.close();

    }
}

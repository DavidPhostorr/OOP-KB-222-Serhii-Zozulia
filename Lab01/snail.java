package Lab01;

import java.util.Scanner;

public class snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть висоту, на яку равлик піднімається за день: ");
        int a = scanner.nextInt();

        System.out.println("Введіть висоту, на яку равлик сповзає вниз за ніч: ");
        int b = scanner.nextInt();

        System.out.println("Введіть висоту дерева: ");
        int h = scanner.nextInt();

        if (a <= b || h <= 0) {
            System.out.println("impossible");
        }
        else {
            int days = (h - b - 1) / (a - b) + 1;
            System.out.println("Равлику знадобиться " + days + " днів, щоб дістатися до вершини дерева");
        }
        scanner.close();
    }
}

package Lab01;

import java.util.Scanner;

public class Time{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть поточний час у секундах: ");
        int Newseconds = scanner.nextInt();
        scanner.close();

        int hours = Newseconds / 3600;
        int minutes = (Newseconds % 3600) / 60;
        int seconds = Newseconds % 60;

        String Time = String.format("%d:%02d:%02d", hours, minutes, seconds);
        System.out.println(Time);

    }


}

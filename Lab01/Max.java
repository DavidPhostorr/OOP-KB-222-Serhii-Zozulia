package Lab01;

public class Max {
    public static void main(String[] args) {
        System.out.println("Введіть масив чисел");
        int[] numbers = {2, 4, 5, 3, 6, 8};
        int maxVal = max(numbers);
        System.out.println("Максимальне значення: " + maxVal);
    }

    public static int max(int[] array) {
        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        return maxVal;
    }
}

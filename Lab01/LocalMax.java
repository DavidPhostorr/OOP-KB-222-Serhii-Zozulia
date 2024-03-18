package Lab01;

import java.util.Arrays;

public class LocalMax {
    public static void main(String[] args) {
        int[] inputarray = {18, 1, 3, 6, 7, -5};
        int[] resultarray = localMax(inputarray);

        System.out.println("Вхідний масив: " + Arrays.toString(inputarray));
        System.out.println("Результат виконання: " + Arrays.toString(resultarray));
    }

    public static int[] localMax(int[] array) {
        int length = array.length;

        int[] resultarray = Arrays.copyOf(array, length);

        for (int i = 1; i < length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                resultarray[i] = (array[i - 1] + array[i + 1]) / 2;
            }
        }

        return Arrays.copyOfRange(resultarray, 1, length - 1);
    }
}
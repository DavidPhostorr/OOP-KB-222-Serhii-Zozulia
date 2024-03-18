package Lab01;

import java.util.Arrays;

public class Swap {
     public static void main(String[] args) {
        int[] array1 = {1, 3, 2, 7, 4};
        int[] array2 = {1, 3, 2, 7, 4};

        cycleSwap(array1);
        System.out.println("Масив після зсуву на 1 позицію: " + Arrays.toString(array1));

        cycleSwap(array2, 3);
        System.out.println("Масив після зсуву на 3 позиції: " + Arrays.toString(array2));
    }

    public static void cycleSwap(int[] array) {
        int lastElement = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElement;
    }

    public static void cycleSwap(int[] array, int shift) {
        shift = shift % array.length;
        int[] temp = Arrays.copyOfRange(array, array.length - shift, array.length);
        System.arraycopy(array, 0, array, shift, array.length - shift);
        System.arraycopy(temp, 0, array, 0, shift);
    }
}


package Lab01;

public class Sum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int result = sum(numbers);
        System.out.println("Сума парних чисел: " + result);
    }

    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0; 
        }
        int sum = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                sum += num;
            }
        }

        return sum;
    }
}

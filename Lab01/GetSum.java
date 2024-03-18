package Lab01;

public class GetSum {
    public static void main(String[] args) {
        int[] inputarray = {1, -1, 0, 4, 6, 10, 15, 25};
        boolean[] resultarray = getSum(inputarray);

        System.out.println("[");
        for (boolean value : resultarray) {
            System.out.println(value + ", ");
        }
        System.out.println("]");
    }

    public static boolean[] getSum(int[] array) {
        int length = array.length;
        boolean[] resultarray = new boolean[length];

        resultarray[0] = false; 
        resultarray[1] = false;

        for (int i = 2; i < length; i++) {
            resultarray[i] = array[i] == array[i - 1] + array[i - 2];
        }

        return resultarray;
    }
}

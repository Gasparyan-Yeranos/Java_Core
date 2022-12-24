package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {48, 1, 98, 10, 30, 42, 66, 20, 9, 71};
        System.out.print("array: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


        int min = array[0];
        for (int i = 1; i < 10; i++) {
            if (min > array[i]) {
                min = array[1];
            }
        }
        System.out.println("minimum == " + min);


        int max = array[0];
        for (int i = 1; i < 10; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("maximum == " + max);
    }
}

package homework.homework5;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {43, 55, 5, -9, 0, 12, 5, 65};
        int size = numbers.length;
        Boolean isSorted = false;
        int a;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    a = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = a;
                    isSorted = false;
                }
            }
        }
        for (int x : numbers) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

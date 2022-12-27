package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {48, 1, 98, 10, 30, 42, 66, 20, 9, 71};
        int size = array.length;
        System.out.print("evens of array: ");
        for (int i = 0; i < size; i++) {
            if(array[i]%2==0){
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        //--------------------------------------------------------------
        System.out.print("odds of array: ");
        for (int i = 0; i < size; i++) {
            if(array[i]%2==1){
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        //--------------------------------------------------------------
        int evenAmount = 0;
        for (int i = 0; i < size; i++) {
            if(array[i]%2==0){
                evenAmount++;
            }
        }
        //--------------------------------------------------------------
        System.out.println("evens: " + evenAmount);
        int oddAmount = 0;
        for (int i = 0; i < size; i++) {
            if(array[i]%2==1){
                oddAmount++;
            }
        }
        System.out.println("odds: " + oddAmount);
        //--------------------------------------------------------------
        double average = 0;
        for (int i = 0; i < 10; i++) {
            average += array[i];
        }
        average = average/size;
        System.out.println("average: " + average);
        //--------------------------------------------------------------
        System.out.println("first element: " + array[0]);
        //--------------------------------------------------------------
        System.out.println("last element: " + array[size-1]);
        //--------------------------------------------------------------
        System.out.println("middler element: " + array[(size-1)/2]);

    }
}

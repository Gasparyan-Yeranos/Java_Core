package homework.homework8;

public class DynamicArray {
    int[] array = new int[10];
    int size = 0;
    int length = 10;
    public void add(int value) {
        if( size == length ){
            this.extend();
        }
        array[size] = value;
        size++;
    }
    private void extend() {
        length += 10;
        int[] newArray = new int[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        newArray = null;
    }
    public int getByIndex(int index) {
        if(index >= 0 && index < size){
            return array[index];
        }
        System.out.println("Index out of borders");
        return -1;
    }
    public void print() {
        if(size == 0){
            System.out.println("----------------------------");
            System.out.println("This array is empty.");
            System.out.println("Input something first.");
            System.out.println("____________________________");
        }else {
            System.out.print("Array: ");
            for (int i = 0; i < size - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[size - 1] + ";");
        }
    }
}
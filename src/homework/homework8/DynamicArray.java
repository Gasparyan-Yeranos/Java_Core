package homework.homework8;

public class DynamicArray {
    private int[] array = new int[10];
    int size = 0;
    int length = 10;
    public void add(int value) {
        if( size == length ){
            this.extend();
        }
        array[size++] = value;

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
    public void deleteByIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("Index Out Of Borders.");
            return;
        }
        for (int i = index + 1; i < size; i++) {
            array[i-1] = array[i];
        }
        size--;
    }
    public void set(int index, int value){
        if(index < 0 || index >= size){
            System.out.println("Index Out Of Borders.");
        }else {
            array[index] = value;
        }
    }
    public void add(int index, int value){
        if(index < 0 || index > size){
            System.out.println("Index Out Of Borders.");
        }else{
            if(size == length){
                extend();
            }
            for (int i = size + 1; i > index; i--) {
                array[i] = array[i-1];
            }
            array[index] = value;
            size++;
        }
    }
    public boolean exist(int value) {
        for (int x: array) {
            if( x == value ) {
                return true;
            }
        }
        return false;
    }
    public int getIndexByValue(int value){
        for (int i = 0; i < size; i++) {
            if(value == array[i]){
                return i;
            }
        }
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
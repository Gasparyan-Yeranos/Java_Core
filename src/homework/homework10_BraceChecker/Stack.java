package homework.homework10_BraceChecker;

public class Stack {
    private int[] array = new int[10];
    private int size = 0;
    private int length = 10;
    public Stack(){}

    private void extend() {
        length += 10;
        int[] newArray = new int[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        newArray = null;
    }

    public void push(char value) {
        if( size == length ){
            this.extend();
        }
        array[size++] = value;

    }

    public void pop(){
        array[size--] = 0;
    }

    public int getLastElement(){
        if(size == 0){
            return '-';
        }
        return(array[size-1]);
    }
}

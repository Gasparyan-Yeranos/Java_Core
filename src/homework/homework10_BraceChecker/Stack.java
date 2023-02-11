package homework.homework10_BraceChecker;

public class Stack {
    private char[] array = new char[10];
    private int size = 0;
    private int length = 10;
    public Stack(){}

    private void extend() {
        length += 10;
        char[] newArray = new char[length];
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
        if(size > 0){
            array[size--] = 0;
        }
    }

    public int getLastElement(){
        if(size <= 0){
            return '-';
        }
        return(array[size-1]);
    }
}

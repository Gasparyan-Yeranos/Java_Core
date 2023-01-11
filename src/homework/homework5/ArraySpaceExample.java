package homework.homework5;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] text = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        int start = 0;
        int finish = text.length - 1;
        for(int i = 0; i < text.length; i++) {
            start = i;
            if(text[i]!=' '){
                break;
            }
        }
        for (int i = text.length-1; i>0; i--) {
            finish = i;
            if(text[i]!=' '){
                break;
            }
        }
        for (int i = start; i < finish + 1; i++) {
            System.out.print(text[i]);
        }
    }
}

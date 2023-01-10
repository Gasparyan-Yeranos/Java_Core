package homework.homework4;

public class CharArrayExample {
    public static void main(String[] args) {
        char[] chars1 = {'j','a','v','a','l','o','v', 'e'};
        //------------------------------------------------
        char c = 'o';
        int count = 0;
        for (int x: chars1) {
            if(x == c){
                count++;
            }
        }
        System.out.println(count);
        //------------------------------------------------
        char[] chars2 = {'j','a','v','a','l','o','v', 'e'};
        int size2 = chars2.length;
        char a = chars2[size2/2-1];
        char b = chars2[size2/2];
        System.out.println(a + ", " + b);
        //------------------------------------------------
        char[] chars3 = {'j','a','v','a','l','o','l', 'y'};
        int size3 = chars3.length;
        if((chars3[size3-1] == 'y') && (chars3[size3-2] == 'l')){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        //------------------------------------------------
        char[] text = {' ',' ','b','a','r','e','v',' ',' '};
        for (int i = 0; i < text.length; i++) {
            if(text[i]!=' '){
                System.out.print(text[i]);
            }
        }
    }
}

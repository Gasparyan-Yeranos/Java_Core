package chapter2;

public class Example2 {
    public static void main(String[] args) {
        int x = 4;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("o  ");
            }
            System.out.println();
        }
    }
}

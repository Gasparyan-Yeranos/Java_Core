package Homework1;

public class IfForExample {
    public static void main(String[] args) {
        int a = 15;
        int b = 15;
        System.out.print("max: ");
        if (a >= b) {
            System.out.println(a);
        }
        if (a < b) {
            System.out.println(b);
        }
        //.................
        if (a >= b) {
            for (int i = b; i < a; i++) {
                System.out.print(i + ",");
            }
            System.out.println(a);
        }
        if (a < b) {
            for (int i = a; i < b; i++) {
                System.out.print(i + ",");
            }
            System.out.println(b);
        }
        //.................
        if (a == b) {
            System.out.println("a-ն հավասար է b-ին");
        }
        if (a != b) {
            System.out.println("a-ն հավասար չէ b-ին");
        }
    }
}

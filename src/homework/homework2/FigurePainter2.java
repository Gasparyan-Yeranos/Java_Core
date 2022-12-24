package homework.homework2;

public class FigurePainter2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 + i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j < 4; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("/*************************/");
        for (int i = 0; i < 5; i++) {
            System.out.print("   ");
            for (int j = i; j <5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 3; i > 0; i--) {
            System.out.print("   ");
            for (int j = i; j <5; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

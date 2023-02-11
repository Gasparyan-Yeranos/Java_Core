package homework.homework10_BraceChecker;

public class BraceCheckerDemo {
    public static void main(String[] args) {
        String text = "(hello)) [world} {[)";
        BraceChecker bc = new BraceChecker(text);
        bc.check();

    }
}

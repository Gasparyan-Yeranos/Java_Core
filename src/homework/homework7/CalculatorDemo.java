package homework.homework7;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator numbers = new Calculator();
        System.out.println("56 + 3 == " + numbers.plus(56.0, 3.0) );
        System.out.println("2.9 + 7.1 == " + numbers.plus(2.9, 7.1) );
        System.out.println("100 - 71 == " + numbers.minus(100.0, 71.0) );
        System.out.println("67.7 - 12.3 == " + numbers.minus(67.7, 12.3) );
        System.out.println("24.1 * 10 == " + numbers.multiply(24.1, 10.0) );
        System.out.println("9 * 9 == " + numbers.multiply(9.0, 9.0) );
        System.out.println("27 / 3 == " + numbers.divide(27.0, 3.0) );
        System.out.println("23546 / 0 == " + numbers.divide(23546, 0) );
//        double a = 2.7 - 0.4;
//        System.out.println(a);
    }

}

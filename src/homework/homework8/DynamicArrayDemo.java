package homework.homework8;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray list = new DynamicArray();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
//        list.add(100);
//        list.add(110);
//        list.add(120);
//        list.add(130);
//        list.add(140);
        list.print();
        list.add(4,7);
        list.print();

    }
}

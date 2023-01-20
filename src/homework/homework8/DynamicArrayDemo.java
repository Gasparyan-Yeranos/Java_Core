package homework.homework8;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray list = new DynamicArray();
        list.print();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(110);
        list.add(120);
        list.add(130);
        list.add(140);
        list.print();
        System.out.println("getByIndex 0: " + list.getByIndex(0));
        System.out.println("getByIndex 4: " + list.getByIndex(4));
        System.out.println("getByIndex 14: " + list.getByIndex(14));
    }
}

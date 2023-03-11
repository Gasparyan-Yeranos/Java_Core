package homework.homework12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class CollectionExample2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //-------------------------------------
        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();
            if(!list.contains(name)){
                list.add(name);
            }
        }
        for (String name: list) {
            System.out.println(name);
        }
        //-------------------------------------
        for (int i = 0; i < 10; i++) {
            String name = scanner.nextLine();
            list.add(name);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }
}

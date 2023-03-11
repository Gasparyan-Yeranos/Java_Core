package homework.homework12;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionExample1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Vardan");
        list.add("Poxos");
        list.add("Petros");
        list.add("Martiros");
        list.add("Kirakos");

        //-------------------------------------
//        String name = scanner.nextLine();
//        if(list.contains(name)){
//            System.out.println("The name " + name + " is in the list.");
//        }else{
//            System.out.println("The name " + name + " isn't in the list.");
//        }
//        //-------------------------------------
//        String name1 = scanner.nextLine();
//        if(list.contains(name1)){
//            list.remove(name1);
//            for (String s : list) {
//                System.out.println(s);
//            }
//            System.out.println("the name " + name1 + " was deleted from the list");
//        }
        //-------------------------------------
        String name2 = scanner.nextLine();
        int index = scanner.nextInt();
        list.set(index, name2);
    }
}

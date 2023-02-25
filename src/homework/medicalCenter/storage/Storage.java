package homework.medicalCenter.storage;

import homework.medicalCenter.model.Person;

public class Storage {
    private Person[] storage = new Person[10];
    private int size = 0;
    private int length = 10;
    public int getSize(){
        return size;
    }
    public Person[] getStorage(){
        return storage;
    }
    public void add(Person a){
        extend();
        storage[size++] = a;
    }
    public void extend(){
        if(size == length) {
            length += 10;
            Person[] storageTmp = new Person[length];
            storage = storageTmp;
        }
    }
    public void pop(String ID){
        int j = size;
        for (int i = 0; i < size; i++) {
            if(storage[i].getID().equals(ID)){
                j = i;
            }
            break;
        }
        for (int i = j; i < size; i++) {
            storage[i] = storage[i+1];
            size--;
        }
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(storage[i]);
        }
    }
    public Person getByID(String ID){
        Person tmp = null;
        for (int i = 0; i < size; i++) {
            if(storage[i].getID().equals(ID)){
                tmp = storage[i];
                break;
            }
        }
        return tmp;
    }
    //0A_001,John,Smith,doc@gmail.com,012345678,dentist
}

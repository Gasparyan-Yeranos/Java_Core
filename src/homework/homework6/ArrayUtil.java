package homework.homework6;

public class ArrayUtil {
    void printEvens(int[] array){
        for(int x: array){
            if(x%2==0){
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
    void printOdds(int[] array){
        for(int x: array){
            if(x%2!=0){
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }
    void printEvensUnit(int[] array){
        int unit = 0;
        for(int x: array){
            if(x%2==0){
                unit++;
            }
        }
        System.out.println(unit);
    }
    void printOddsUnit(int[] array){
        int unit = 0;
        for(int x: array){
            if(x%2!=0){
                unit++;
            }
        }
        System.out.println(unit);
    }
    void average(int[] array){
        int count = 0;
        for(int x: array){
            count += x;
        }
        count = count/array.length;
        System.out.println(count);
    }
    void printFirst(int[] array){
        System.out.println(array[0]);
    }
    void printLast(int[] array){
        int index = array.length - 1;
        System.out.println(array[index]);
    }
    void printMiddle(int[] array){
        int index = (array.length - 1)/2;
        System.out.println(array[index]);
    }
    void findMin(int[] array){
        int min = array[0];
        for(int x: array){
            if(min > x){
                min = x;
            }
        }
        System.out.println(min);
    }
    void findMax(int[] array){
        int max = array[0];
        for(int x: array){
            if(max < x){
                max = x;
            }
        }
        System.out.println(max);
    }
}

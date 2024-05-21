package algo;

import java.util.Arrays;

public class SortExample {

    public static void main(String[] args) {
        String[] array = {"e", "d", "c", "b", "a"};
        /*
        * 1) d, c, b, a, e -> move the largest to the end(i=0 to 4, j=0 to 4)
        * 2) c, b, a, d, e -> move the 2nd largest to 2nd last(i=1 to 4, j=0 to 3(because the last element is the largest))
        * 2) b, a, c, d, e -> move the 3rd largest to 3rd last(i=2 to 4, j=0 to 2(because the last 2 element is the largest))
        * ...
        * */
        sortAsc(array);
        System.out.println(Arrays.toString(array));

        String[] array1 = {"banana", "apple", "orange", "grape", "kiwi"};
        sortAsc(array1);
        System.out.println(Arrays.toString(array1));
    }

    private static void sortAsc(String[] arrayOfName) {

        int length = arrayOfName.length;

        for (int i = 0; i < length-1; i++) {
            boolean swapped = false; // for optimization
            System.out.println(i);
            for (int j = 0; j < length-i-1; j++) {
                //For descending make it less than 0
                if(arrayOfName[j].compareTo(arrayOfName[j+1])>0) {
                    String temp = arrayOfName[j];
                    arrayOfName[j] = arrayOfName[j+1];
                    arrayOfName[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;// if element not get swapped in the complete j iteration that means array is already sorted so need to continue.
        }
    }
}

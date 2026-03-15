import java.util.*;
public class Leet1356SortIntegersByTheNumbersof1bits {
    public static int[] sortByBits(int[] arr) { //TC->O(nlogn), SC->O(n)
        Integer[] temp = new Integer[arr.length];  //SC->O(n)

        for (int i = 0; i < arr.length; i++) {  // convert int array into Integer array ->TC->O(n)
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {  // comparetor  -> TC->O(nlogn)
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA == countB)  // if bits are equal sort on the bases of numbers
                return a - b;

            return countA - countB; // otherwise sort on the bases of set bits
        });

        for (int i = 0; i < arr.length; i++) {   // reconvert Integer to int ->TC->O(n)
            arr[i] = temp[i];
        }

        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8};
        System.out.print(Arrays.toString(sortByBits(arr)));
    }
    
}

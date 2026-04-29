package Neetcode;

import java.util.Arrays;

public class MoveNegToStart {
    static void main() {

        int [] arr = {-1,-20,30,40,50,-8};
        performOperationUsingSort(arr);
        int [] arr1 = {-1,-20,30,40,50,-8};
        performOperation(arr1);
    }

    private static void performOperation(int[] arr) {
        int left = 0;
        for (int right =0 ; right<arr.length; right++){
            if(arr[right]<0){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void performOperationUsingSort(int[] arr) {
        Arrays.sort(arr);
        System.out.println("************ performOperationUsingSort *****************");
        System.out.println(Arrays.toString(arr));
    }
}

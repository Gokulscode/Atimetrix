package Neetcode;

import java.util.Arrays;

public class MoveZeros {
    static void main() {
        int[] arr = {10,0,0,4,5,6,};
        moveZeros(arr);
    }

    private static void moveZeros(int[] arr) {
        int left = 0;

        for(int right=0;right<arr.length;right++){
            if(arr[right]!=0){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

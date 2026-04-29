package Neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    static void main() {
        int [] input = {2,7,11,15};
        int target = 13 ;
        int[] result = findTwoSum(input,target);
        System.out.println(Arrays.toString(result));

    }

    private static int[] findTwoSum(int[] input, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<input.length ; i++){
            int complement = target - input[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(input[i],i);
        }
        return new int[]{};
    }
}

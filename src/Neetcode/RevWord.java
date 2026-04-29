package Neetcode;

public class RevWord {
    static void main() {
        String name = "madam";
        revOperation(name);
    }

    private static void revOperation(String name) {
        char[] arr = name.toCharArray();
        int end = arr.length-1;
        for(int start=0;start<arr.length/2;start++){
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            end --;

        }
        name = String.valueOf(arr);
        System.out.println(name);
    }
}

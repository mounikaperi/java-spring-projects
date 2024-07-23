import java.util.Arrays;

class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        ReverseArray obj = new ReverseArray();
        obj.reverseAnArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverseAnArray(int[] arr) {
        for (int start =0, end=arr.length-1; start < end; start++, end--) {
            if(start == end) return;
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}

import java.util.Arrays;

class ShuffleTheArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int n = 6;
        arr = shuffleWithExtraSpace(arr, n);
        System.out.println(Arrays.toString(arr));
        arr = shiffleWithoutExtraSpace(arr, n);
        System.out.printn(Arrays.toString(arr));
    }
    static int[] shuffleWithExtraSpace(int[] arr, int n) {
        int[] result = new int[2*n];
        int j=0;
        for (int i=0; i<n; i++) {
            result[j++] = arr[i];
            result[j] = arr[i+n];
            j++;
        }
        return result;
    }
    static int[] shuffleWithoutExtraSpace(int[] arr, int n) {
        // Bit Manipulation
    }

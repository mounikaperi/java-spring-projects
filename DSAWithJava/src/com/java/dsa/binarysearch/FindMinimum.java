class FindMinimum {
    public static void main(String[] args) {
       int arr[] = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
       System.out.println(findMin(arr));
    }
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] < min) 
                min = arr[i];
        }
        return min;
    }
}

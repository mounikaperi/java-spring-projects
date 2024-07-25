class FindMinimum {
    public static void main(String[] args) {
       int arr1D[] = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
       int arr2D[][] = {
          {10, 8, 9},
          {3, 7, 1},
          {2, 6, 4}
       };
       System.out.println(findMin1D(arr1D));
       System.out.println(findMin2D(arr2D));
    }
    static int findMin1D(int[] arr) {
        int min = arr[0];
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] < min) 
                min = arr[i];
        }
        return min;
    }
    static int findMin2D(int[][] arr) {
        int min = arr[0][0];
        for (int row =0; row<arr.length; row++) {
            for (int col =0; col<arr[row].length; col++) {
                if (arr[row][col] < min) {
                    min = arr[row][col];
                }
            }
        }
        return min;
    }
}

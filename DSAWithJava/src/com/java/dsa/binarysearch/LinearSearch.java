class LinearSearch {
    public static void main(String[] args) {
       int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       System.out.println("Element found at position: " + findElement(arr, 10));
    }
    static int findElement(int[] arr, int elementToSearch) {
        if(arr.length == 0) return -1;
        for (int i=0; i<arr.length;i++)
            if (elementToSearch == arr[i]) return i+1;
        return -1;
    }
}

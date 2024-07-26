class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int arr[] = {0,2,1,5,3,4};
        arr = buildArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] buildArray(int[] arr) {
        int count = 1001;
        for(int i=0; i<arr.length; i++) {
            int a = arr[i];
            int b = arr[a] % COUNT;
            arr[i] = a + b * COUNT;
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] /= COUNT;
        }
        return arr;
    }
}
        

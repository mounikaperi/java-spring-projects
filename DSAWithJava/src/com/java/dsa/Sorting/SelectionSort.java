import java.util.*;

class SelectionSort {
    public static void main(String[] args) {
        int N = 5;
        int arr[] = {4, 1, 3, 9, 7};
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(N, arr);
    }
    void selectionSort(int N, int arr[]) {
        for (int i = 0; i<N-1; i++) {
            int min = select(i, arr);
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    int select(int i, int arr[])  {
        int min = i;
        for (int j=i+1; j<arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = i;
            }
        }
        return min;
    }
}

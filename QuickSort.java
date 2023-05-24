// Quick sort in Java

import java.util.Arrays;

public class QuickSort {
    public void QuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivindx = partition(arr, low, high);
            QuickSort(arr, low, pivindx - 1);
            QuickSort(arr, pivindx + 1, high);
        }

    }

    public int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // i++;
        // swap
        int temp1 = arr[i + 1];
        arr[i + 1] = arr[ei];
        arr[ei] = temp1;

        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = { 1, 5, 63, 23, 74, 23, 55 };
        qs.QuickSort(arr, 0, arr.length - 1);
        // qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
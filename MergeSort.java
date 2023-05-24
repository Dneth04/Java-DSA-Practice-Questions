public class MergeSort {
    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int ind1 = si; // starting index of array1 end=mid
        int ind2 = mid + 1; // starting index of array2 end=ei
        int x = 0;
        while (ind1 <= mid && ind2 <= ei) { // merging happens until index vales are less than total elements in arr1
                                            // &arr2
            if (arr[ind1] < arr[ind2]) {
                merged[x++] = arr[ind1];
                ind1++;
            } else {
                merged[x++] = arr[ind2];
                ind2++;
            }
        }
        while (ind1 <= mid) {
            merged[x++] = arr[ind1];
            ind1++;
        }
        while (ind2 <= ei) {
            merged[x++] = arr[ind2];
            ind2++;
        }
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 3, 6, 1 };
        int len = arr.length;
        MergeSort ob = new MergeSort();
        ob.divide(arr, 0, len - 1);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}

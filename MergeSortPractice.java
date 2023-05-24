public class MergeSortPractice {
    public void Divide(int arr[], int si, int ei) {
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            Divide(arr, si, mid);
            Divide(arr, mid + 1, ei);
            Conquer(arr, si, mid, ei);
        }
    }

    public void Conquer(int arr[], int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int x = 0;
        int ind1 = si;
        int ind2 = mid + 1;
        while (ind1 <= mid && ind2 <= ei) {
            if (arr[ind1] > arr[ind2]) {
                merged[x++] = arr[ind2];
                ind2++;
            } else {
                merged[x++] = arr[ind1];
                ind1++;
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

    public static void main(String[] args) {
        MergeSortPractice mp = new MergeSortPractice();
        int arr[] = { 1, 5, 3, 8, 56, 34, 53 };
        mp.Divide(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}


import java.util.*;

public class Heap {
    public void HeapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // heapSort
        for (int i = n - 1; i >= 0; i--) {
            // swap(arr[0],arr[i])
            int temp = 0;
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0); // to bring the largest element again to the root
        }
    }

    public void heapify(int arr[], int n, int root) {
        int largest = root;
        int leftchild = 2 * root + 1;
        int rightchild = 2 * root + 2;
        if (leftchild < n && arr[leftchild] > arr[largest]) {
            largest = leftchild;
        }
        if (rightchild < n && arr[rightchild] > arr[largest]) {
            largest = rightchild;
        }
        if (largest != root) {
            // swap(arr[root],arr[largest])
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        int arr[] = { 8, 12, 4, 5, 6, 10 };
        hp.HeapSort(arr);
        hp.printarr(arr);
    }
}

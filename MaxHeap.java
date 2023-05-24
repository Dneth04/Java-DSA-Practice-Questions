import java.util.*;

public class MaxHeap {
    public int pid;
    public int Btime;

    public MaxHeap(int pid, int Btime) {
        this.pid = pid;
        this.Btime = Btime;
    }

    public static void HeapSort(MaxHeap[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            Heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            MaxHeap t1 = arr[0];
            arr[0] = arr[i];
            arr[i] = t1;
            Heapify(arr, i, 0);
        }
    }

    public static void Heapify(MaxHeap[] sjf, int n, int i) {
        int largest = i; // parent index is i
        int l = 2 * i + 1; // left child indx
        int r = 2 * i + 2;// right child indx
        while (l < n && sjf[l].Btime > sjf[largest].Btime) {
            largest = l;
        }
        while (r < n && sjf[r].Btime > sjf[largest].Btime) {
            largest = r;
        }
        if (largest != i) {
            MaxHeap temp = sjf[i];
            sjf[i] = sjf[largest];
            sjf[largest] = temp;
            Heapify(sjf, n, largest);

        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        MaxHeap[] mp = new MaxHeap[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the pid and Burst time for process " + (i + 1) + ":");
            int p = sc.nextInt();
            int t = sc.nextInt();
            mp[i] = new MaxHeap(p, t);
        }
        HeapSort(mp);
        System.out.println("The SJF schedule is:");
        for (MaxHeap j : mp) {
            System.out.println("P" + j.pid);
        }
    }
}

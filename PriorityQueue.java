
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PriorityQueue {
    int pid;
    int Btime;

    public PriorityQueue(int pid, int Btime) {
        this.pid = pid;
        this.Btime = Btime;
    }

    public static void HeapSort(PriorityQueue arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // heapSort
        for (int i = n - 1; i >= 0; i--) {
            // swap(arr[0],arr[i])
            PriorityQueue temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0); // to bring the largest element again to the root
        }
    }

    public static void heapify(PriorityQueue arr[], int n, int root) {
        int largest = root;
        int leftchild = 2 * root + 1;
        int rightchild = 2 * root + 2;
        if (leftchild < n && arr[leftchild].Btime > arr[largest].Btime) {
            largest = leftchild;
        }
        if (rightchild < n && arr[rightchild].Btime > arr[largest].Btime) {
            largest = rightchild;
        }
        if (largest != root) {
            // swap(arr[root],arr[largest])
            PriorityQueue temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void printarr(PriorityQueue arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("P" + arr[i].pid);
        }
    }

    public static void main(String[] args) {
        String inFile = "PQ.txt";
        List<PriorityQueue> pq = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(inFile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] field = line.split(" ");

                if (field.length >= 2) {
                    int pid = Integer.parseInt(field[0]);
                    int Btime = Integer.parseInt(field[1]);
                    PriorityQueue pb = new PriorityQueue(pid, Btime);
                    pq.add(pb);

                } else {
                    System.out.println("invalid record : " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PriorityQueue[] mp = pq.toArray(new PriorityQueue[0]);
        HeapSort(mp);
        printarr(mp);

    }

}

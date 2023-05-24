
public class LL {
    int size;

    LL() {
        head = null;
        size = 0;
    }

    class Student {
        int sno;
        String id;
        double cgpa;

        public Student(int sno, String id, double cgpa) {
            this.sno = sno;
            this.id = id;
            this.cgpa = cgpa;
        }
    }

    class Node {
        Student data;
        Node link;

        public Node(Student data) {
            this.data = data;
            this.link = null;
        }
    }

    Node head;

    public void insert(int sno, String id, double cgpa) {
        Student details = new Student(sno, id, cgpa);
        Node data = new Node(details);
        size++;
        if (head == null) {
            head = data;
            return;
        }
        Node pointer = head;
        while (pointer.link != null) {
            pointer = pointer.link;
        }
        pointer.link = data;

    }

    public void delete(String id) {
        if (head == null) {
            return;
        }
        if (head.data.id.equals(id)) {
            head = head.link;
            size--;
            return;
        }
        Node prev = head;
        Node curr = head.link;
        while (curr != null) {
            if (curr.data.id.equals(id)) {
                prev.link = curr.link;
                size--;
                return;
            }
            prev = curr;
            curr = curr.link;
        }
    }

    public void insertIndex(int sno, String id, double cgpa, int index) {
        Student details = new Student(sno, id, cgpa);

        if (index < 0 || index > size) {
            System.out.println("Invalid index. Insertion at the specified index is not possible.");
            return;
        }
        size++;
        Node val = new Node(details);

        if (index == 0) {
            val.link = head;
            head = val;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.link;
        }

        val.link = prev.link;
        prev.link = val;
    }

    public void printlist() {
        Node curr = head;
        while (curr != null) {
            System.out.println(" " + curr.data.sno + " " + curr.data.id + " " + curr.data.cgpa + "-->");
            curr = curr.link;
        }
        System.out.println("null");
    }

    public Node reverseIterative() {
        if (head == null) {
            return null;
        }
        if (head.link == null) {
            return head;
        }

        Node prev = null;
        Node nxt = null;

        while (head != null) {
            nxt = head.link;
            head.link = prev;
            prev = head;
            head = nxt;
        }
        head = prev;
        return head;
    }

    public int find(double cgpa) {
        if (head == null) {
            System.out.println("List is empty");
            // return 0;
        }
        Node prev = head;
        int count = 0;
        while (prev != null) {

            if (prev.data.cgpa == cgpa) {
                break;
            }
            count++;
            prev = prev.link;
        }
        System.out.println("The element was found at : " + count);
        return count;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        LL x = new LL();

        // x.getSize();
        x.insert(1, "2021A7PS0031U", 3.4);
        x.insert(2, "2021A7PS0025U", 3.4);
        x.insert(3, "2021A7PS0045U", 3.4);
        x.insert(4, "2021A7PS0078U", 9.9);
        x.printlist();
        x.insertIndex(6, "2021A7PS0033U", 3.4, 3);
        // x.delete("2021A7PS0033U");
        x.printlist();
        // x.reverseIterative();
        int size = x.getSize();
        // x.printlist(); // Print the reversed list
        System.out.println("Size of the linked list: " + size);
        x.find(3.4);
        // x.printlist();
        // System.out.println("Size of the linked list: " + size);
        long endtime = System.currentTimeMillis();
        long totaltime = endtime - starttime;
        System.out.println(totaltime + " MILLISECS");
    }

}

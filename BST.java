import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BST {
    public static class Student {
        int IDNo;
        String name;
        double CGPA;

        public Student(int IDNo, String name, double CGPA) {
            this.IDNo = IDNo;
            this.name = name;
            this.CGPA = CGPA;
        }

        @Override
        public String toString() {
            return "(" + IDNo + ", " + name + ", " + CGPA + ")";
        }

    }

    class Node {
        Student data;
        Node left;
        Node right;

        public Node(Student data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int IDNo, String name, double CGPA) {
        Student std = new Student(IDNo, name, CGPA);
        root = inst(root, std);
    }

    private Node inst(Node root, Student std) {
        if (root == null) {
            return new Node(std);
        }
        if (std.IDNo < root.data.IDNo) {
            root.left = inst(root.left, std);
        } else if (std.IDNo > root.data.IDNo) {
            root.right = inst(root.right, std);
        }
        return root;
    }

    public boolean find(int IDNo) {
        return fnd(root, IDNo) != null;
    }

    public Node fnd(Node root, int IDNo) {
        if (root == null || root.data.IDNo == IDNo) {
            return root;
        }

        if (IDNo < root.data.IDNo) {
            return fnd(root.left, IDNo);
        } else {
            return fnd(root.right, IDNo);
        }
    }

    public Student delete(int IDNo) {
        Node deletedNode = deleteUtil(root, IDNo);
        return deletedNode != null ? deletedNode.data : null;
    }

    private Node deleteUtil(Node root, int IDNo) {
        if (root == null) {
            return root;
        }

        if (IDNo < root.data.IDNo) {
            root.left = deleteUtil(root.left, IDNo);
        } else if (IDNo > root.data.IDNo) {
            root.right = deleteUtil(root.right, IDNo);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValueNode(root.right).data;
            root.right = deleteUtil(root.right, root.data.IDNo);
        }

        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorder() {
        inord(root);
        System.out.println();
    }

    public void inord(Node root) {
        if (root != null) {
            inord(root.left);
            System.out.print("(" + root.data.IDNo + ", " + root.data.name + ", " + root.data.CGPA + ") ");
            inord(root.right);
        }
    }

    public void preorder() {
        preord(root);
        System.out.println();
    }

    public void preord(Node root) {
        if (root != null) {
            System.out.print("(" + root.data.IDNo + ", " + root.data.name + ", " + root.data.CGPA + ") ");
            preord(root.left);
            preord(root.right);
        }
    }

    public void postorder() {
        postord(root);
        System.out.println();
    }

    public void postord(Node root) {
        if (root != null) {
            postord(root.left);
            postord(root.right);
            System.out.print("(" + root.data.IDNo + ", " + root.data.name + ", " + root.data.CGPA + ") ");
        }
    }

    public int size() {
        return getSize(root);
    }

    public int getSize(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftSize = getSize(root.left);
            int rightSize = getSize(root.right);
            return 1 + leftSize + rightSize;
        }
    }

    public static void main(String[] args) {
        String inFile = "StudentRecordBst.txt"; // Specify the input file name

        // Read input from file
        Student[] records = readInput(inFile);

        // Create an instance of the BST class
        BST bst = new BST();
        for (Student student : records) {
            bst.insert(student.IDNo, student.name, student.CGPA);
        }

        // Perform operations on the BST as required (find, delete, inorder, preorder,
        // postorder, size)
        boolean found = bst.find(107);
        System.out.println("IDNo 103 found: " + found);
        int x = 104;
        Student deletedStudent = bst.delete(x);
        System.out.println("Deleted:" + x);

        System.out.println("Inorder:");
        bst.inorder();
        System.out.println();
        System.out.println("Preorder:");
        bst.preorder();
        System.out.println();
        System.out.println("Postorder:");
        bst.postorder();
        System.out.println();

        int size = bst.size();
        System.out.println("Size of BST: " + size);
    }

    public static Student[] readInput(String StudentRecordBst) {
        List<Student> studentRecords = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(StudentRecordBst))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(" ");

                System.out.println("Fields: " + Arrays.toString(fields));

                if (fields.length >= 3) {
                    int IDNo = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    double CGPA = Double.parseDouble(fields[2]);

                    Student student = new Student(IDNo, name, CGPA);
                    studentRecords.add(student);
                } else {
                    System.out.println("Invalid record: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Student records: ");
        for (Student student : studentRecords) {
            System.out.println("(" + student.IDNo + ", " + student.name + ", " + student.CGPA + ")");
        }

        return studentRecords.toArray(new Student[0]);
    }

}

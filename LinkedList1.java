import java.util.*;

class Student {
    private String name;
    private String id;
    private double cgpa;

    public Student(String name, String id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class LinkedList1 {
    private ArrayList<Student> lt;
    private int size;

    public LinkedList1() {
        lt = new ArrayList<Student>();
        size = 0;
    }

    public void insert(int index, String name, String id, double cgpa) {
        Student student = new Student(name, id, cgpa);
        lt.add(index, student);
        size++;
        System.out.println("Student added to list:");
        // display();
    }

    public int delete(String name) {
        int index = find(name);
        if (index != -1) {
            lt.remove(index);
            size--;
            display();
            return index;
        } else
            return -1;

    }

    public int find(String name) {
        int index = -1;
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getName().equals(name)) {
                index = i;
                System.out.println("The item was found in index " + index);
                break;
            }
        }
        if (index == -1) {
            System.out.println("The item was not found");
        }
        return index;
    }

    public void display() {
        if (lt.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("There are " + lt.size()
                + " records present in the list. The student records present in the list are:");
        for (int i = 0; i < lt.size(); i++) {
            Student student = lt.get(i);
            System.out.println((i + 1) + ". " + student.getName() + ", " + student.getId() + ", " + student.getCgpa());
        }
    }

    public void size() {
        System.out.println(lt.size());
    }

    public boolean isEmpty() {
        if (lt.isEmpty()) {
            System.out.println("The list is empty");
            return true;
        } else {
            System.out.println("The list is not empty");
            return false;
        }
    }

    void menu(LinkedList1 list) {
        Scanner sc = new Scanner(System.in);
        Scanner sp = new Scanner(System.in);
        System.out.println("MENU : 1.add 2.delete 3.find 4.display 5.isEmpty 6. size 7.exit ");
        int num = sc.nextInt();
        if (num == 1) {
            System.out.println("Enter the Name: ");
            String nm = sp.nextLine();
            System.out.println("Enter the id :");
            String idno = sp.nextLine();
            System.out.println("Enter the cgpa: ");
            Double cgpa = sc.nextDouble();
            System.out.println("Enter the index :");
            int ind = sc.nextInt();
            list.insert(ind, nm, idno, cgpa);
        } else if (num == 2) {
            System.out.println("ENTER THE NAME TO BE DELETED");
            String name1 = sp.next();
            list.delete(name1);
        } else if (num == 3) {
            System.out.println("ENTETR THE NAME TO BE SEARCHED");
            String name2 = sp.nextLine();
            list.find(name2);
        } else if (num == 4) {
            list.display();
        } else if (num == 5) {
            list.isEmpty();
        } else if (num == 6) {
            list.size();
        } else if (num == 7) {
            System.out.println("EXIT");
        }
    }

    public static void main(String[] args) {
        LinkedList1 ll = new LinkedList1();
        ll.insert(0, "ANN", "2021", 9.0);
        ll.insert(1, "Dysa", "2021", 8.5);
        ll.insert(2, "Alia", "2020", 7.9);
        ll.insert(3, "Jack", "2019", 9.5);

        Scanner np = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("Do you want to continue ?(1-YES/0-NO)");
            choice = np.nextInt();
            if (choice == 1)
                ll.menu(ll);
        }
    }
}

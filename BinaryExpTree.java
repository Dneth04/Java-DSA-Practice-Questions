import java.util.*;

public class BinaryExpTree {
    class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int idx = -1;

    public Node Build(String elements) {
        String[] symbols = elements.split(" ");
        Stack<Node> stk = new Stack<>();
        for (String i : symbols) {
            if (isOperand(i)) {
                Node newOperator = new Node(i);
                stk.push(newOperator);
            }
            if (isOperator(i)) {
                Node op = new Node(i);
                op.right = stk.pop();
                op.left = stk.pop();
                stk.push(op);

            }
        }
        return stk.pop();

    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }

    public boolean isOperand(String symbol) {
        return symbol.matches("[A-Z]+");
        // return true;
    }

    public boolean isOperator(String symbol) {
        return symbol.matches("[+*/%^\\-]");
    }

    public static void main(String[] args) {
        String exp = "A B + C D - *";
        BinaryExpTree tree = new BinaryExpTree();
        Node root = tree.Build(exp);
        // System.out.println(root.data);
        tree.inorder(root);
    }

}

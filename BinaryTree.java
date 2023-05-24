public class BinaryTree {
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

    public Node build(String elements[]) {

    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        return leftcount + rightcount + 1;
    }

    public static void main(String[] args) {
        String exp[] = { "apple", "orange", "banana", "grapes", "cherry" };
        BinaryTree tree = new BinaryTree();
        Node root = tree.build(exp);
        tree.preorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        int height = tree.height(root);
        System.out.println("Tree height: " + height);
    }
}

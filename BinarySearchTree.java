public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " -> ");
            inorder(root.right);
        }
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.data) {
            root.right = insert(root.right, val);
        } else if (val < root.data) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public int search(Node root, int val) {
        if (root == null) {
            // root = new Node(val);
            return -1;
        }
        if (val == root.data) {
            return root.data;
        } else if (val > root.data) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    public Node delete(Node root, int val) {
        if (root == null) {
            return root;
        }
        if (val < root.data)
            root.left = delete(root.left, val);
        else if (val > root.data)
            root.right = delete(root.right, val);
        // case with one child or no child
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);// delete the inorder successor
            // return root;
        }
        return root;
    }

    public int minValue(Node root) {
        int minv = 0;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;
        root = tree.insert(root, 8);
        root = tree.insert(root, 3);
        root = tree.insert(root, 1);
        root = tree.insert(root, 6);

        System.out.print("Inorder traversal: ");
        tree.inorder(root);

        System.out.println("\n\nAfter deleting 1");
        root = tree.delete(root, 1);
        System.out.print("Inorder traversal: ");
        tree.inorder(root);
    }
}

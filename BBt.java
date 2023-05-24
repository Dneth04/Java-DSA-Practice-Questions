public class BBt {
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

    public Node Build(Node root, String val) {
        if (root == null) {
            Node rt = new Node(val);
            return rt;
        }
        if (root.left == null) {
            root.left = Build(root.left, val);
        } else {
            root.right = Build(root.right, val);
        }
        return root;

    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String exp[] = { "1", "2", "3", "4", "5" };
        BBt tree = new BBt();
        Node rt = null;
        for (int i = 0; i < exp.length; i++) {
            rt = tree.Build(rt, exp[i]);
        }
        System.out.println("Postorder traversal:");
        tree.postorder(rt);
        System.out.println();

        System.out.println("inorder traversal:");
        tree.preorder(rt);
        System.out.println();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime + " milliseconds");

    }
}

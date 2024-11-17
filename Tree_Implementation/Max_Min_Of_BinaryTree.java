public class Max_Min_Of_BinaryTree {
    public int max_Of_BinaryTree(CreateTree.Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        // We will find the maximum no of left subtree and maximum no of right subtree
        // and then find the maximum of these two subtree and the main root node data
        return Math.max(root.data, Math.max(max_Of_BinaryTree(root.left), max_Of_BinaryTree(root.right)));
    }

    public int min_Of_BinaryTree(CreateTree.Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        // We will find the minimum no of left subtree and minimum no of right subtree
        // and then find the minimum of these two subtree and the main root node data
        return Math.min(root.data, Math.min(min_Of_BinaryTree(root.left), min_Of_BinaryTree(root.right)));

    }

    public static void main(String[] args) {
        Max_Min_Of_BinaryTree mmobt = new Max_Min_Of_BinaryTree();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        System.out.println("Max of binary tree is " + mmobt.max_Of_BinaryTree(root)); // root node of createTree
                                                                                      // funtion will be passed
                                                                                      // here
        System.out.println("Min of binary tree is " + mmobt.min_Of_BinaryTree(root)); // root node of createTree
        // funtion will be passed
        // here
    }
}

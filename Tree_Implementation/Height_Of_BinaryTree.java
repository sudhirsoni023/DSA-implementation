public class Height_Of_BinaryTree {
    public int height_Of_BinaryTree(CreateTree.Node root) {
        if (root == null) // if we have only 1 node in our tree
            return 0;
        // we will find the height of left subtree and height of right subtree and then
        // add 1 to that result
        return Math.max(height_Of_BinaryTree(root.left), height_Of_BinaryTree(root.right)) + 1;
    }

    public static void main(String[] args) {
        Height_Of_BinaryTree hobt = new Height_Of_BinaryTree();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        System.out.println("Height of binary tree is " + hobt.height_Of_BinaryTree(root)); // root node of createTree
                                                                                           // funtion will be passed
                                                                                           // here

    }
}

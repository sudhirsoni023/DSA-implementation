// Size of a binary tree means total no of nodes in that tree
public class Size_Of_BinaryTree {
    public int size_Of_BinaryTree(CreateTree.Node root) {
        if (root == null) // base condition
            return 0;
        // we will find the size of left subtree and add it to the size of right subtree
        // and then add 1 to the whole result.
        return (size_Of_BinaryTree(root.left) + size_Of_BinaryTree(root.right)) + 1;
    }

    public static void main(String[] args) {
        Size_Of_BinaryTree sobt = new Size_Of_BinaryTree();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        System.out.println("Size of binary tree is " + sobt.size_Of_BinaryTree(root)); // root node of createTree
                                                                                       // funtion will be passed
                                                                                       // here
    }
}

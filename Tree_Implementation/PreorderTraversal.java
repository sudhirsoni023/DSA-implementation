public class PreorderTraversal {

    public void preorderTraversal(CreateTree.Node root) {
        if (root == null) // base condition
            return;
        // PreOrder means Root will be in the First (NLR)
        // where N-> Node(Root), L-> Left, R-> Right
        System.out.print(root.data + " "); // Root Node will be passed from here
        preorderTraversal(root.left); // Left Node will be passed from here
        preorderTraversal(root.right); // Right Node will be passed from here
    }

    public static void main(String[] args) {
        PreorderTraversal pot = new PreorderTraversal();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        pot.preorderTraversal(root); // root node of createTree function will be passed from here
    }
}

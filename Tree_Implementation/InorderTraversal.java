public class InorderTraversal {

    public void inorderTraversal(CreateTree.Node root) {
        if (root == null) // base condition
            return;
        // Inorder means Root will be in the middle (LNR)
        // where L-> Left, N-> Node(Root), R-> Right
        inorderTraversal(root.left); // Left Node will be passed from here
        System.out.print(root.data + " "); // Root Node will be passed from here
        inorderTraversal(root.right); // Right Node will be passed from here
    }

    public static void main(String[] args) {
        InorderTraversal iot = new InorderTraversal();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        iot.inorderTraversal(root); // root node of createTree function will be passed from here
    }
}

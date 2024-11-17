public class PostorderTraversal {

    public void postorderTraversal(CreateTree.Node root) {
        if (root == null) // base condition
            return;
        // PostOrder means Root will be in the last (LRN)
        // where L-> Left, R-> Right, N-> Node(Root)
        postorderTraversal(root.left); // Left Node will be passed from here
        postorderTraversal(root.right); // Right Node will be passed from here
        System.out.print(root.data + " "); // Root Node will be passed from here
    }

    public static void main(String[] args) {
        PostorderTraversal pot = new PostorderTraversal();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        pot.postorderTraversal(root); // root node of createTree function will be passed from here
    }
}

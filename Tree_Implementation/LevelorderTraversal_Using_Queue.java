import java.util.LinkedList;
import java.util.Queue;

public class LevelorderTraversal_Using_Queue {
    public void levelorderTraversal(CreateTree.Node root) {
        if (root == null) // if there is no element at all then return from here
            return;
        Queue<CreateTree.Node> q = new LinkedList<>(); // we will make a queue first to store the nodes
        q.add(root); // add the main root node to the queue
        while (!q.isEmpty()) { // while queue is not empty we will run the below code
            CreateTree.Node curr = q.poll(); // curr will store the first node of queue and that node will be deleted
                                             // from the queue
            System.out.print(curr.data + " "); // printing the curr's data
            if (curr.left != null) // if curr.left is having some data
                q.add(curr.left); // we will add that node to the queue
            if (curr.right != null) // if curr.right is having some data
                q.add(curr.right); // we will add that node to the queue
        }
    }

    public static void main(String[] args) {
        LevelorderTraversal_Using_Queue lotuq = new LevelorderTraversal_Using_Queue();
        CreateTree ct = new CreateTree();
        CreateTree.Node root = ct.createTree(); // for calling the createTree function of CreateTree Class
        lotuq.levelorderTraversal(root); // root node of createTree function will be passed from here
    }
}

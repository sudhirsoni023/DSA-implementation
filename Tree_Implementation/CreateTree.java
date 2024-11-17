import java.util.Scanner;

public class CreateTree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) { // constructor to create a node
            this.data = data;
        }
    }

    Scanner sc = new Scanner(System.in);

    // Using recursion we will create a tree here
    public Node createTree() {
        Node root = null;
        System.out.println("Enter data");
        int data = sc.nextInt();
        if (data == -1) // base condition
            return null;
        root = new Node(data); // create a node with given data
        System.out.println("Enter left data for " + data);
        System.out.println("Enter -1 if you dont want to insert left data of " + data);
        root.left = createTree(); // link left of root node with the new node created
        System.out.println("Enter right data for " + data);
        System.out.println("Enter -1 if you dont want to insert right data of " + data);
        root.right = createTree(); // link right of root node with the new node created
        return root; // return the root node of the binary Tree
    }

    public static void main(String[] args) {

    }
}

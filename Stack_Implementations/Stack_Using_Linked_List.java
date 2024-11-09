public class Stack_Using_Linked_List {
    private Node top;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Implementation of push method in Stack will be exactly same as
    // 'insertAtBeginning method' in SinglyLinkedList
    public void push(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (top == null) { // means no node is created
            top = n; // make the first node as top
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        n.next = top; // link the newly created node with the previous top node
        top = n; // make the new node as top node now
    }

    // Implementation of pop method in Stack will be exactly same as
    // 'deleteAtBeginning method' in SinglyLinkedList
    public void pop() {
        if (top == null) {
            System.out.println("List is already empty");
            return;
        }
        top = top.next; // link the top pointer to the 2nd node of the list
    }

    public void peek() {
        System.out.println("top most element is " + this.top.data);
    }

    public void display() {
        Node temp = top; // make a temp pointer which points to top node in the starting of the list
        if (top == null) {
            System.out.println("No lists to show");
            return;
        }
        while (temp != null) { // while temp pointer not reaches the last node
            if (temp.next != null)
                System.out.print(temp.data + "=>");
            else
                System.out.print(temp.data);
            temp = temp.next; // move the temp pointer by 1 node
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Using_Linked_List sull = new Stack_Using_Linked_List();
        sull.push(3);
        sull.push(5);
        sull.push(6);
        sull.push(7);
        sull.push(8);
        sull.display();
        sull.pop();
        sull.push(9);
        sull.push(4);
        sull.pop();
        sull.display();
        sull.peek();
    }
}

package Queue_Implementations;

// Here we will first make a doubly linked list and then implement its insertAtBeginning,insertAtEnding,deleteAtBeginning and deleteAtEnding methods
public class DoublyEndedQueue_Using_Linked_List {
    private Node front, rear; // this will point to the head node

    // Nested Node class to create a new node each time we need

    private static class Node {
        private int data; // this will store data value of node
        private Node next; // this will store address value of next node
        private Node prev; // this will store address value of prev node

        // for creating new node everytime
        public Node(int data) {
            this.data = data; // insert the data in the new node
            this.next = null; // point the next pointer of new node to null
            this.prev = null; // point the prev pointer of new node to null
        }
    }
    // Node class ends here

    // Same as insertAtBeginning of DoublyLinkedList
    public void insertAtFront(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (front == null) { // means no node is created
            front = n; // make the first node as front
            rear = n; // make the first node as rear
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        // (forward linking)
        n.next = front; // link the newly created node with the previous front node
        // (backward linking)
        front.prev = n; // link the front's prev node with newly created node
        front = n; // make the new node as front node now
    }

    // Same as insertAtEnding of DoublyLinkedList
    public void insertAtRear(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (rear == null) { // means no node is created
            insertAtFront(data);
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        // (forward linking)
        rear.next = n; // link the rear node of the list with the newly created node
        // (backward linking)
        n.prev = rear; // link the newly created node prev pointer with the last (rear) node;
        rear = n; // make the new node as rear
    }

    // Same as deleteAtBeginning of DoublyLinkedList
    public void deleteAtFront() {
        if (front == null) {
            System.out.println("Queue is already empty");
            return;
        }
        front = front.next; // link the front pointer to the 2nd node of the list
        front.prev = null; // link the front's prev pointer with null
    }

    // Same as deleteAtEnding of DoublyLinkedList
    public void deleteAtRear() {
        if (rear == null) {
            System.out.println("Queue is already empty");
            return;
        }
        rear = rear.prev; // make the ;ast 2nd node as rear
        rear.next = null; // link the rear's next pointer with null
    }

    // Same as showForwardLinkedList of DoublyLinkedList
    public void showQueue() {
        Node temp = front; // make a temp pointer which points to front node in the starting of the list
        if (front == null) {
            System.out.println("No Queue to show");
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
        DoublyEndedQueue_Using_Linked_List dequll = new DoublyEndedQueue_Using_Linked_List();
        System.out.println();
        dequll.insertAtFront(2);
        dequll.insertAtFront(9);
        dequll.insertAtRear(8);
        dequll.insertAtFront(5);
        dequll.insertAtRear(3);
        dequll.insertAtFront(8);
        dequll.insertAtRear(7);
        dequll.showQueue();
        dequll.deleteAtFront();
        dequll.deleteAtRear();
        dequll.showQueue();
    }
}

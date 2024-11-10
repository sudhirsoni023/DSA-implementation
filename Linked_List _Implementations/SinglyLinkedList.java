// A linked list is a linear data structure where elements (called nodes) are connected in a sequence, each containing two parts:
// Data: The value or content of the node.
// Next (or Pointer): A reference to the next node in the sequence (in the case of a singly linked list).
// A linked list allows for efficient insertion and deletion of elements, especially when you don't know the size in advance 
// or when frequent insertions/deletions are required. Unlike arrays, linked lists do not require contiguous memory allocation,
//  and they can dynamically grow or shrink in size.
public class SinglyLinkedList {

    private Node head; // this will point to the head node
    private Node prevNode; // this will initially point to the 1st node
    private Node currNode; // this will initially point to the 2nd node
    private Node nextNode; // this will initially point to the 3rd node

    // Nested Node class to create a new node each time we need
    private static class Node {
        private int data; // this will store data value of node
        private Node next; // this will store address value of next node

        // for creating new node everytime
        public Node(int data) {
            this.data = data; // insert the data in the new node
            this.next = null; // point the next pointer of new node to null
        }
    }
    // Node class ends here

    public void insertAtBeginning(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (head == null) { // means no node is created
            head = n; // make the first node as head
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        n.next = head; // link the newly created node with the previous head node
        head = n; // make the new node as head node now
    }

    public void insertAtEnding(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (head == null) { // means no node is created
            insertAtBeginning(data);
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (temp.next != null) // reach till last node
            temp = temp.next; // increment the pointer by 1 node
        temp.next = n; // link the last node of the list with the newly created node
    }

    public void insertAtSpecificPosition(int data, int position) {
        Node n = new Node(data); // new node is created with name 'n'
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        } else if (position == 1) { // insert at beginning
            insertAtBeginning(data);
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (--position > 1) // come till the value of position node
            temp = temp.next; // increment the pointer by 1 node
        n.next = temp.next; // link the newly created node with the next node after position node
        temp.next = n; // link the newly created node with the position place node
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        head = head.next; // link the head pointer to the 2nd node of the list
    }

    public void deleteAtEnding() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (temp.next.next != null) // reach till last 2nd node
            temp = temp.next; // increment the pointer by 1 node
        temp.next = null; // link the last 2nd node with null
    }

    public void deleteAtSpecificPosition(int position) {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        if (position == 1) { // deletion at beginning
            deleteAtBeginning();
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (--position > 1) // come till the value of position node
            temp = temp.next; // increment the pointer by 1 node
        temp.next = temp.next.next; // link the temp node with the second node after the temp node
    }

    public void showLinkedList() {
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        if (head == null) {
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

    public int searchElement(int searchElement) {
        int position = 1; // to track the index of the curr element
        Node temp = head; // temp pointer points to the head node
        boolean flag = false;
        while (temp != null) { // until the temp pointer not reaches the end of the list
            if (temp.data == searchElement) { // if current data is matching with searchElement
                flag = true;
                return position; // return its index no.
            }
            temp = temp.next; // moves the temp pointer by 1 node
            ++position;
        }
        if (flag == false) // if element not found
            return -1;
        return position;
    }

    public void reverseList() {
        if (head == null || head.next == null) // No OR Single element found
            return;
        currNode = head; // currNode points to head
        nextNode = head.next; // nextNode points to next node after head
        while (currNode != null) { // untill currNode not reaches the last node
            currNode.next = prevNode; // link the currNode with the prevNode
            prevNode = currNode; // moves the prevNode to its next node
            currNode = nextNode; // // moves the currNode to its next node
            if (currNode != null) // for the last node case we put this condition
                nextNode = nextNode.next; // // moves the nextNode to its next node
        }
        head = prevNode; // makes the last node as head node

    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        System.out.println();
        sll.insertAtBeginning(2);
        sll.insertAtBeginning(9);
        sll.insertAtEnding(8);
        sll.insertAtBeginning(5);
        sll.insertAtEnding(3);
        sll.insertAtSpecificPosition(4, 3);
        sll.insertAtBeginning(8);
        sll.insertAtEnding(7);
        sll.showLinkedList();
        sll.deleteAtBeginning();
        sll.deleteAtEnding();
        sll.deleteAtSpecificPosition(2);
        sll.showLinkedList();
        sll.deleteAtSpecificPosition(1);
        sll.showLinkedList();
        sll.insertAtSpecificPosition(6, 5);
        sll.showLinkedList();
        int searchPosition = sll.searchElement(8);
        if (searchPosition == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at position " + searchPosition);
        sll.reverseList();
        sll.showLinkedList();
    }
}
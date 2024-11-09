public class DoublyLinkedList {
    private Node head; // this will point to the head node
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

    public void insertAtBeginning(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (head == null) { // means no node is created
            head = n; // make the first node as head
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        // (forward linking)
        n.next = head; // link the newly created node with the previous head node
        // (backward linking)
        head.prev = n; // link the head's prev node with newly created node
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
        // (forward linking)
        temp.next = n; // link the last node of the list with the newly created node
        // (backward linking)
        n.prev = temp; // link the newly created node prev pointer with the last node;
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
        // (forward linking)
        n.next = temp.next; // link the newly created node with the next node after position node
        // (backward linking)
        n.next.prev = n; // link the next node after position node with the newly created node
        // (forward linking)
        temp.next = n; // link the newly created node with the position place node
        // (backward linking)
        n.prev = temp; //
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        head = head.next; // link the head pointer to the 2nd node of the list
        head.prev = null;
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
        if (position == 1) { // 1st node
            deleteAtBeginning();
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (--position > 1) // come till the value of position node
            temp = temp.next; // increment the pointer by 1 node
        // (forward linking)
        temp.next = temp.next.next; // link the temp node with the second node after the temp node
        // (backward linking)
        temp.next.prev = temp;
    }

    public void showForwardLinkedList() {
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

    public void showBackwardLinkedList() {
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        if (head == null) {
            System.out.println("No lists to show");
            return;
        }
        while (temp.next != null) // while temp pointer not reaches the last node
            temp = temp.next; // move the temp pointer forward by 1 node
        while (temp != null) {
            if (temp.prev != null)
                System.out.print(temp.data + "=>");
            else
                System.out.print(temp.data);
            temp = temp.prev; // move the temp pointer backward by 1 node
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

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println();
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(9);
        dll.insertAtEnding(8);
        dll.insertAtBeginning(5);
        dll.insertAtEnding(3);
        dll.insertAtSpecificPosition(4, 3);
        dll.insertAtBeginning(8);
        dll.insertAtEnding(7);
        dll.showForwardLinkedList();
        dll.showBackwardLinkedList();
        dll.deleteAtBeginning();
        dll.deleteAtEnding();
        dll.deleteAtSpecificPosition(2);
        dll.showForwardLinkedList();
        dll.deleteAtSpecificPosition(1);
        dll.showForwardLinkedList();
        int searchPosition = dll.searchElement(8);
        if (searchPosition == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at position " + searchPosition);
    }
}
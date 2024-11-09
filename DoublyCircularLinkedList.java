public class DoublyCircularLinkedList {
    private Node head; // this will point to the head node
    private Node last; // this will point to the last node
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
            last = n; // make the first node as last
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        // (forward linking)
        n.next = head; // link the newly created node with the previous head node
        // (backward linking)
        head.prev = n; // link the head's prev node with newly created node
        head = n; // make the new node as head node now
        last.next = head; // link the next pointer of last node to head
        head.prev = last; // link the prev pointer of last node to head
    }

    public void insertAtEnding(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (head == null) { // means no node is created
            insertAtBeginning(data);
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        // (forward linking)
        last.next = n; // link the last node of the list with the newly created node
        // (backward linking)
        n.prev = last; // link the newly created node prev pointer with the last node;
        n.next = head; // link the last node with head in forward direction
        head.prev = n; // link the last node with head in backward direction
        last = n; // make the 'n' as last node
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
        n.prev = temp; // link the prev of new node with the temp node
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        head = head.next; // link the head pointer to the 2nd node of the list
        head.prev = last; // link the head with last node in backward direction
        last.next = head; // link the head with last node in forward direction
    }

    public void deleteAtEnding() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (temp.next != last) // reach till last 2nd node
            temp = temp.next; // increment the pointer by 1 node
        last = temp;
        last.next = head; // link the last 2nd node with null
        head.prev = last; // link the head node to last node in backward direction
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
        temp.next.prev = temp; // link the temp with temp next prev
    }

    public void showForwardLinkedList() {
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        if (head == null) {
            System.out.println("No lists to show");
            return;
        }
        while (temp != last) { // while temp pointer not reaches the last node
            System.out.print(temp.data + "=>");
            temp = temp.next; // move the temp pointer by 1 node
        }
        System.out.print(last.data); // for printing the last value of list
        System.out.println();
    }

    public void showBackwardLinkedList() {
        Node temp = last; // make a temp pointer which points to head node in the starting of the list
        if (head == null) {
            System.out.println("No lists to show");
            return;
        }
        while (temp != head) { // while temp pointer not reaches the first(head) node
            System.out.print(temp.data + "=>");
            temp = temp.prev; // move the temp pointer backward by 1 node
        }
        System.out.print(head.data); // for printing the first value of list
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
        if (last.data == searchElement) // if last node data is matching with searchElement
            return position;// return its index no.
        if (flag == false) // if element not found
            return -1;
        return position;
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        System.out.println();
        dcll.insertAtBeginning(2);
        dcll.insertAtBeginning(9);
        dcll.insertAtEnding(8);
        dcll.insertAtBeginning(5);
        dcll.insertAtEnding(3);
        dcll.insertAtSpecificPosition(4, 3);
        dcll.insertAtBeginning(8);
        dcll.insertAtEnding(7);
        dcll.showForwardLinkedList();
        dcll.showBackwardLinkedList();
        dcll.deleteAtBeginning();
        dcll.deleteAtEnding();
        dcll.deleteAtSpecificPosition(2);
        dcll.showForwardLinkedList();
        dcll.deleteAtSpecificPosition(1);
        int searchPosition = dcll.searchElement(2);
        if (searchPosition == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at position " + searchPosition);
    }
}
public class CircularLinkedList {
    private Node head; // this will point to the head node
    private Node last; // this will point to the last node
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
            last = n; // make the last node as last
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'
        n.next = head; // link the newly created node with the previous head node
        head = n; // make the new node as head node now
        last.next = head; // link the last node with the head node.
    }

    public void insertAtEnding(int data) {
        Node n = new Node(data); // new node is created with name 'n'
        if (head == null) { // means no node is created
            insertAtBeginning(data);
            return; // come out of the function
        }
        // if 'if condition will not run then only below code will run'

        last.next = n; // link the last node of the list with the newly created node
        n.next = head; // link the newly created node prev pointer with the last node;
        last = n; // make the newly created node as last
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
        if (temp.next == last) {
            insertAtEnding(data);
            return;
        }
        n.next = temp.next; // link the newly created node with the next node after position node
        temp.next = n; // link the newly created node with the position place node
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        head = head.next; // link the head pointer to the 2nd node of the list
        last.next = head; // link the last node with the new head now.
    }

    public void deleteAtEnding() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        while (temp.next.next != head) // reach till last 2nd node
            temp = temp.next; // increment the pointer by 1 node
        temp.next = head; // link the last 2nd node with head node
        last = temp; // make the last node as last.
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
        if (temp.next == last) // means if we want to delete the last node
            deleteAtEnding();
        else
            temp.next = temp.next.next; // link the temp node with the second node after the temp node
    }

    public void showLinkedList() {
        Node temp = head; // make a temp pointer which points to head node in the starting of the list
        if (head == null) {
            System.out.println("No lists to show");
            return;
        }
        while (temp != last) { // while temp pointer not reaches the last node
            System.out.print(temp.data + "=>");
            temp = temp.next; // move the temp pointer by 1 node
        }
        System.out.print(last.data); // to print the value of last node
        System.out.println();
    }

    public int searchElement(int searchElement) {
        int position = 1;
        Node temp = head;// temp pointer points to the head node
        boolean flag = false;
        while (temp != last) { // until the temp pointer not reaches the end of the list
            if (temp.data == searchElement) {// if current data is matching with searchElement
                flag = true;
                return position;// return its index no.
            }
            temp = temp.next; // moves the temp pointer by 1 node
            ++position;
        }
        if (last.data == searchElement)// if last node data is matching with searchElement
            return position;// return its index no.

        if (flag == false) // if element not found
            return -1;
        return position;
    }

    public void reverseList() {
        if (head == null || head == last) // No OR Single element found
            return;
        prevNode = head; // prevNode points to head node
        currNode = head.next; // currNode points to next node of head node
        nextNode = head.next.next; // nextNode points to 2 node after the head node
        while (currNode != last) { // untill currNode not reaches the last node
            currNode.next = prevNode; // link the currNode with the prevNode
            prevNode = currNode; // moves the prevNode to its next node
            currNode = nextNode; // // moves the currNode to its next node
            if (currNode != last) // for the last node case we put this condition
                nextNode = nextNode.next; // // moves the nextNode to its next node
        }
        Node temp = head; // temp node points to the first(head) node
        head.next = last; // link the head node with the last node
        last.next = prevNode; // link the last node with the node before last node
        head = last; // head node now points to last node
        last = temp; // last node points to temp node now.
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        System.out.println();
        cll.insertAtBeginning(2);
        cll.insertAtBeginning(9);
        cll.insertAtEnding(8);
        cll.insertAtBeginning(5);
        cll.insertAtEnding(3);
        cll.insertAtSpecificPosition(4, 3);
        cll.insertAtBeginning(8);
        cll.insertAtEnding(7);
        cll.deleteAtBeginning();
        cll.deleteAtEnding();
        cll.deleteAtSpecificPosition(2);
        cll.deleteAtSpecificPosition(1);
        cll.showLinkedList();
        int searchPosition = cll.searchElement(4);
        if (searchPosition == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at position " + searchPosition);
        cll.reverseList();
        cll.showLinkedList();
    }
}
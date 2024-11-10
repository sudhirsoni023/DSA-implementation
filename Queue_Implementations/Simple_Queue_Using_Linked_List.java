// A queue is a fundamental data structure in computer science that follows a First-In, First-Out (FIFO) order. 
// This means that the first element added to the queue will be the first one to be removed. You can think of a queue
// as a line of people waiting to buy tickets: 
// the first person to get in line is the first person to get served.
package Queue_Implementations;

public class Simple_Queue_Using_Linked_List {
    private Node front;
    private Node rear;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null && rear == null); // when this condition will met means queue is empty
    }

    public void enqueue(int data) {
        Node n = new Node(data); // create new node
        if (isEmpty()) {
            front = rear = n; // when first element is inserted we will make first node as front and rear
            return;
        }
        rear.next = n; // link the rear node with the newly created node
        rear = rear.next; // move rear pointer to the next node
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }
        if (front == rear) { // when single element is present in queue
            front = rear = null; // both the pointers will point to null
            return;
        }
        front = front.next; // move front pointer to next node
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, can't show the queue");
            return;
        }
        Node temp = front;
        while (temp != rear.next) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Simple_Queue_Using_Linked_List squll = new Simple_Queue_Using_Linked_List();
        squll.enqueue(4);
        squll.enqueue(6);
        squll.enqueue(3);
        squll.enqueue(9);
        squll.enqueue(2);
        squll.enqueue(7);
        squll.enqueue(8);
        squll.enqueue(1);
        squll.showQueue();
        squll.dequeue();
        squll.dequeue();
        squll.showQueue();
    }
}

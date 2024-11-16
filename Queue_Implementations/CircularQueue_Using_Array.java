package Queue_Implementations;

public class CircularQueue_Using_Array {
    private final int maxSize = 8; // Total size of the array (queue size)
    private int[] arr = new int[maxSize]; // total size of array
    private int front = -1;
    private int rear = -1;

    public boolean isEmpty() {
        return (front == -1 && rear == -1); // Queue is empty
    }

    public boolean isFull() {
        return ((rear + 1) % maxSize == front); // Circular queue full condition
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0; // First element inserted, set both front and rear to 0
        } else {
            rear = (rear + 1) % maxSize; // Move rear to the next position
        }
        arr[rear] = data; // Insert data at rear position
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }
        if (front == rear) {
            front = rear = -1; // Only one element left, reset both front and rear
        } else {
            front = (front + 1) % maxSize; // Move front to the next position
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, can't show the queue");
            return;
        }

        System.out.println("Queue Elements:");
        int i = front;
        int count = 0;

        // Loop through the elements in the queue
        while (count < size()) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % maxSize; // Wrap around the circular array
            count++;
        }
        System.out.println();
    }

    // Helper method to calculate the current size of the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return maxSize - front + rear + 1;
        }
    }

    public static void main(String[] args) {
        CircularQueue_Using_Array cqua = new CircularQueue_Using_Array();

        // Enqueue some elements
        cqua.enqueue(4);
        cqua.enqueue(6);
        cqua.enqueue(3);
        cqua.enqueue(9);
        cqua.enqueue(2);
        cqua.enqueue(7);
        cqua.enqueue(8);
        cqua.enqueue(1);

        // Show the queue after all elements are added
        cqua.showQueue();

        // Dequeue two elements
        cqua.dequeue();
        cqua.dequeue();
        cqua.enqueue(5);
        // Show the queue after dequeuing
        cqua.showQueue();
    }
}

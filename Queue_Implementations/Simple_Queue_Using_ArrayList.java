package Queue_Implementations;

import java.util.ArrayList;

public class Simple_Queue_Using_ArrayList {
    private ArrayList<Integer> arr = new ArrayList<>(); // total size of array
    private int front = -1;
    private int rear = -1;

    public boolean isEmpty() {
        return arr.isEmpty(); // when this condition will meet means queue is empty
    }

    public void enqueue(int data) {
        if (isEmpty()) {
            front = rear = 0; // when first element is inserted we will set the index of front and rear as 0
            arr.add(data); // and then we will insert the data in that index. since arr is empty so no need
                           // to mention index here
            return;
        }

        arr.add(++rear, data); // we will increment the value of rear by 1 and then insert the data at that
                               // index
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }
        if (front == rear) { // when single element is present in queue
            front = rear = -1; // both rear and front values will be reset to -1
            return;
        }
        ++front; // increment the index value of front by 1
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, can't show the queue");
            return;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Simple_Queue_Using_ArrayList squa = new Simple_Queue_Using_ArrayList();
        squa.enqueue(4);
        squa.enqueue(6);
        squa.enqueue(3);
        squa.enqueue(9);
        squa.enqueue(2);
        squa.enqueue(7);
        squa.enqueue(8);
        squa.enqueue(1);
        squa.showQueue();
        squa.dequeue();
        squa.dequeue();
        squa.showQueue();
    }
}

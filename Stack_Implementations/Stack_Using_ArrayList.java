import java.util.ArrayList;

public class Stack_Using_ArrayList {
    ArrayList<Integer> arr = new ArrayList<>(); // make an initial fixed size array of size 8 with all elements as 0 by
                                                // default

    public void push(int data) {
        arr.add(data);
    }

    public void pop() {
        if (arr.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        arr.remove(arr.size() - 1);
    }

    public void peek() {
        if (arr.isEmpty()) {
            System.out.println("Array is empty right now");
            return;
        }
        System.out.println("top most element is " + arr.get(arr.size() - 1)); // display the value of last index of
                                                                              // array
    }

    public void display() {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Using_ArrayList sua = new Stack_Using_ArrayList();
        sua.push(1);
        sua.push(2);
        sua.push(3);
        sua.push(4);
        sua.push(5);
        sua.push(6);
        sua.push(8);
        sua.display();
        sua.pop();
        sua.pop();
        sua.pop();
        sua.display();
        sua.peek();
    }
}

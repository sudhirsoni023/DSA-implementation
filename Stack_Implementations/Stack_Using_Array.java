public class Stack_Using_Array {
    private int top = -1; // initialize the value of top by -1 so that it should not point any value of
                          // an array
    int arr[] = new int[8]; // make an initial fixed size array of size 8 with all elements as 0 by default

    public void push(int data) {
        if (top == (arr.length - 1)) { // Check if top is pointing to the last index of array, if yes means array is
                                       // already full
            System.out.print("Stack Overflow");
            return;
        }
        arr[++top] = data; // increment the value of top by 1 and insert data into that index
    }

    public void pop() {
        if (top == -1) { // Check if top is pointing to the negative index of array, if yes means array
                         // is already Empty
            System.out.print("Stack Underflow");
            return;
        }
        --top; // decrement the value of top by 1, this only is called popping the element
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Array is empty right now");
            return;
        }
        System.out.println("top most element is " + arr[top]); // display the value of top index of array
    }

    public void display() {
        for (int i = top; i >= 0; i--) // we will consider only those elements which is starting from the top index
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Using_Array sua = new Stack_Using_Array();
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

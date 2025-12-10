public class Queue<T> {

    // Node class for linked structure
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;   // head of queue
    private Node<T> rear;    // tail of queue
    private int size;        // optional but useful

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add element to the queue (enqueue)
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        if (rear == null) {       // queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove element from queue (dequeue)
    public T dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        T value = front.data;
        front = front.next;

        if (front == null) {      // queue became empty
            rear = null;
        }

        size--;
        return value;
    }

    // Peek at front element
    public T peek() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Optional: return size
    public int size() {
        return size;
    }
}

public class SinglyLinkedList {

    // ---------------- Node Class ----------------
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // ---------------- List Fields ----------------
    private Node head;
    private Node tail;
    private int length;

    // ---------------- Constructor ----------------
    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    // ---------------- Getter Methods ----------------
    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    // ---------------- Print List ----------------
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ---------------- Append ----------------
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // ---------------- Prepend ----------------
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // ---------------- Get Node by Index ----------------
    private Node getNode(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // ---------------- Get Value ----------------
    public Integer get(int index) {
        Node temp = getNode(index);
        return (temp != null) ? temp.value : null;
    }

    // ---------------- Set Value ----------------
    public boolean set(int index, int value) {
        Node temp = getNode(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // ---------------- Insert at Index ----------------
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node prev = getNode(index - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
        return true;
    }

    // ---------------- Remove at Index ----------------
    public Integer remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            length--;
            if (length == 0) tail = null;
            return temp.value;
        }

        Node prev = getNode(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        if (index == length - 1) {
            tail = prev;
        }

        length--;
        return temp.value;
    }

    // ---------------- Remove First ----------------
    public Integer removeFirst() {
        return remove(0);
    }

    // ---------------- Remove Last ----------------
    public Integer removeLast() {
        return remove(length - 1);
    }

    // ---------------- Reverse List ----------------
    public void reverse() {
        Node prev = null;
        Node current = head;
        tail = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }

    // ---------------- Clear List ----------------
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    // ---------------- Main Method Demo (Optional) ----------------
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList(10);

        list.append(20);
        list.append(30);
        list.prepend(5);

        list.printList();  // 5 -> 10 -> 20 -> 30 -> null

        list.insert(2, 99);
        list.printList();  // 5 -> 10 -> 99 -> 20 -> 30 -> null

        list.remove(3);
        list.printList();  // 5 -> 10 -> 99 -> 30 -> null

        list.reverse();
        list.printList();  // 30 -> 99 -> 10 -> 5 -> null
    }
}

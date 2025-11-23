package linkedList;


import java.util.Stack;

public class LinkedListTopic {
    static LinkedList linkedList = new LinkedList();

    public static void pushToLinkedList(int value) {
        if (linkedList.head == null) {
            linkedList.head = new Node(value);
        } else {
            Node temp = linkedList.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
        }
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        pushToLinkedList(1);
        pushToLinkedList(2);
        pushToLinkedList(3);
        pushToLinkedList(4);
        pushToLinkedList(5);
        pushToLinkedList(6);
        pushToLinkedList(7);
        System.out.println("Linked list");
        Node h = removeFromNodeFromLast(linkedList.head, 2);
        print(h);
//        nextGreaterElement();
    }

    public static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        head = prev;
        return head;
    }

    public static Node reverseLinkedListByRange(Node head, int left, int right) {
        Node temp = head;
        for (int i = 1; i < left - 1; i++) {
            temp = temp.next;
        }
        Node firstHalf = temp;
        Node start = firstHalf.next;
        Node pre = null;
        while (left < right) {
            Node nextNode = start.next;
            start.next = pre;
            pre = start;
            start = nextNode;
            left++;
        }
        return temp;
    }

    public static Node removeNode(Node head, int value) {
        if (head == null) return null;
        if (head.value == value) return head.next;
        Node temp = head;
        Node previousNode = null;

        while (temp != null) {
            if (temp.value == value) {
                previousNode.next = temp.next;
            }
            previousNode = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void nextGreaterElement() {
        int[] array = {12, 23, 0, 56, 100, 1, 78, 5};
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() > array[i]) {
                stack.pop();
            }
            System.out.println(stack);
            stack.push(array[i]);
        }
    }

    public static Node removeFromNodeFromLast(Node head, int n) {
        if (head == null) return null;
        if (head.next == null) return head.next;
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

// 1, 2, 3,4 ,5,6,6,7
//  null
package linkedList;

public class Solutions {
    public static void main(String[] args) {

    }

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        while (list1 != null) {
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            dummy = dummy.next;
            dummy.next = list2;
            list2 = list2.next;
        }
        return dummy.next;
    }

    private static boolean detectCycle(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode current = slow;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        slow = head;
        fast = prev;
        while (fast.next != null) {
            ListNode temp1 = slow.next;
            ListNode temp2 = fast.next;

            slow.next = fast;
            fast.next = temp1;

            slow = temp1;
            fast = temp2;
        }
    }
}

// 1 , 2 , 3 , 4 , 5

// 1 , 4 , 3 , 2 , 5
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
}

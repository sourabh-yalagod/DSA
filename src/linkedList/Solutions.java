package linkedList;

import java.util.List;
import java.util.PriorityQueue;

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

    private static ListNode removeNthNodeFromLast(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode prev = null;
        ListNode current = l1;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        l1 = prev;
        prev = null;
        current = l2;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        l2 = prev;
//        reversed
//        add number
        ListNode dummy = new ListNode(0);
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            int carry = sum;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            dummy.next = new ListNode(carry % 10);
            dummy = dummy.next;
            sum /= 10;
        }
        return dummy.next;
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[slow];
        }
        return slow;
    }

    private static ListNode mergeKSortedList(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) if (node != null) pq.add(node);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            while (min.next != null) pq.add(min.next);
        }
        return head.next;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentGroupHead = head;
        ListNode previousGroupEnd = dummy;
        int limit = 0;
        while (head != null) {
            limit++;
            if (limit == k) {
                ListNode nextGroupHead = head.next;
                ListNode prev = null;
                ListNode current = currentGroupHead;
                while (current != nextGroupHead) {
                    ListNode nextNode = current.next;
                    current.next = prev;
                    prev = current;
                    current = nextNode;
                }
                previousGroupEnd.next = prev;
                previousGroupEnd = currentGroupHead;
                currentGroupHead = nextGroupHead;
                head = nextGroupHead;
                limit = 0;
            } else head = head.next;
        }
        return dummy.next;
    }
}

// 1 , 2 , 3 , 4 , 5

// 1 , 4 , 3 , 2 , 5
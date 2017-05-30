package main.java.com.valiantsen.lcpractise.linkedlist;

public class AddTwoNumbersM {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0, sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + (add > 0 ? 1 : 0);
            if (sum > 9) {
                add = 1;
                sum = sum % 10;
            } else
                add = 0;
            ListNode a = new ListNode(sum);
            first.next = a;
            first = first.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {

            sum = (add > 0 ? 1 : 0) + l1.val;
            if (sum > 9) {
                sum = sum % 10;
                add = 1;
            } else
                add = 0;

            ListNode a = new ListNode(sum);
            first.next = a;
            l1 = l1.next;
            first = first.next;
        }
        while (l2 != null) {
            sum = (add > 0 ? 1 : 0) + l2.val;
            if (sum > 9) {
                sum = sum % 10;
                add = 1;
            } else
                add = 0;

            ListNode a = new ListNode(sum);
            first.next = a;
            l2 = l2.next;
            first = first.next;
        }
        if (add > 0) {
            ListNode a = new ListNode(1);
            first.next = a;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode a = new ListNode(sum % 10);
            d.next = a;
            d = d.next;
        }
        if (sum > 9) {
            ListNode a = new ListNode(1);
            d.next = a;
        }
        return dummy.next;
    }
}

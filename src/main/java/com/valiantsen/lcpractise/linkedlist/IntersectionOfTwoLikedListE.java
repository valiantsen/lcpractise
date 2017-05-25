package main.java.com.valiantsen.lcpractise.linkedlist;


/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @ClassName: IntersectionOfTwoLikedListE
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月20日
 */
public class IntersectionOfTwoLikedListE {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int la = 0, lb = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            la++;
            a = a.next;
        }
        while (b != null) {
            lb++;
            b = b.next;
        }
        int m = Math.abs(la - lb);
        if (la > lb) {
            while (m > 0) {
                headA = headA.next;
                m--;
            }
        } else {
            while (m > 0) {
                headB = headB.next;
                m--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

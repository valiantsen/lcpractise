package main.java.com.valiantsen.lcpractise.linkedlist;

import java.util.ArrayList;
import java.util.List;

import main.java.com.valiantsen.lcpractise.struct.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @ClassName: CopyListWithRandomPointerM
 * @author zhangyasen
 * @date 2017年9月22日
 */
public class CopyListWithRandomPointerM {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        List<RandomListNode> oldList = new ArrayList<>();
        RandomListNode first = head, pointer = head, temp;
        RandomListNode dummy = new RandomListNode(0);
        // 生成新链表
        while (first != null) {
            RandomListNode newNode = new RandomListNode(first.label);
            if (first == head) {
                dummy.next = newNode;
                pointer = newNode;
            } else {
                pointer.next = newNode;
                pointer = newNode;
            }
            oldList.add(first);
            first = first.next;
        }
        // 旧链表next指向新节点，新节点random指向旧节点
        first = head;
        pointer = dummy.next;
        while (first != null) {
            temp = first.next;
            first.next = pointer;
            pointer.random = first;
            pointer = pointer.next;
            first = temp;
        }
        pointer = dummy.next;
        // 生成新节点的真实random
        while (pointer != null) {
            if (pointer.random.random != null) {
                pointer.random = pointer.random.random.next;
            } else {
                pointer.random = null;
            }
            pointer = pointer.next;
        }
        // 恢复旧链表的next
        for (int i = 0; i < oldList.size(); i++) {
            if (i == oldList.size() - 1) {
                oldList.get(i).next = null;
            } else {
                oldList.get(i).next = oldList.get(i + 1);
            }
        }
        return dummy.next;
    }

}

package main.java.com.valiantsen.lcpractise.linkedlist;


/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to
 * that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the
 * linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 * @ClassName: DeleteNodeInALinkedList
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月25日
 */
public class DeleteNodeInALinkedList {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static void main(String[] args) {
    String[] a = {"124", "aa"};
    System.out.println();
  }
}

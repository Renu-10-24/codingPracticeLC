package contests;

public class LinkedList {
    public static void main(String args[]){
        Sol1 s = new Sol1();
        ListNode listNode = new ListNode();
        s.deleteMiddle(listNode);
    }
}

// Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Sol1 {
    public ListNode deleteMiddle(ListNode head) {

        return null;
    }
}
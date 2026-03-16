package scaler.degree.dsa3;

//  Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
public class RemoveOddValuesFromList {
    public ListNode solve(ListNode A) {
        ListNode head = A;
        ListNode currNode = null;
        while(A!=null){
            currNode = A;
            if(currNode.val %2 != 0){
                 A= currNode.next;
                 //delete currNode
            }else {
                head = A;
                    A= A.next;
            }
       }
        return head;
    }

    static void main() {
        RemoveOddValuesFromList r = new RemoveOddValuesFromList();
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(3);
        ListNode C = new ListNode(5);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(7);
        ListNode F = new ListNode(6);
        ListNode G = new ListNode(8);
        ListNode H = new ListNode(9);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        F.next = G;
        G.next = H;

        ListNode out = r.solve(A);
        while ( out !=null){
            System.out.println(out.val);
            out = out.next;
        }
    }
}
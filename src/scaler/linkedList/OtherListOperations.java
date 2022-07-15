package scaler.linkedList;

import java.util.List;

public class OtherListOperations {
    public static void main(String args[]){
        Solution s = new Solution();
        // A = [   [0, 1, -1]
        //            [1, 2, -1]
        //            [2, 3, 1]   ]
        int[][] A = new int[][]{{0, 1, -1},{1, 2, -1},{2, 3, 1}};
        ListNode headNode =null;
//        headNode = s.solve(A);
//        while(headNode != null){
//            System.out.println(headNode.val+" ->");
//            headNode = headNode.next;
//            }

//        A = new int[][]{{0, 1, -1},{1, 2, -1},{2, 3, 1},{0, 4, -1},{3, 1, -1},{3, 2, -1}};
//        headNode = s.solve(A);
//        while(headNode != null){
//            System.out.println(headNode.val+" ->");
//            headNode = headNode.next;
//        }
//        [1, 13, -1]
//  [3, 0, -1]
//  [3, 1, -1]
//  [2, 15, 0]
//  [3, 0, -1]
//  [1, 12, -1]
//  [3, 0, -1]
//  [1, 19, -1]
//  [1, 13, -1]
//  [3, 0, -1]
//  [0, 12, -1]
//  [1, 13, -1]
//  [3, 2, -1]
        A = new int[][]{{1, 13, -1},{3, 0, -1},{3, 1, -1},{2, 15, 0},{3, 0, -1},{1, 12, -1},{3, 0, -1},{1, 19, -1},{1, 13, -1},
                {3, 0, -1},{0, 12, -1},{1, 13, -1},{3, 2, -1}};
        headNode = s.solve(A);
        while(headNode != null){
            System.out.println(headNode.val+" ->");
            headNode = headNode.next;
            }
        }
    }

//  Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
class Solution {
    public ListNode solve(int[][] A) {
            int noOfTestcases = A.length;
            ListNode headNode = null;
            for(int i=0;i<noOfTestcases;i++){
                int operation = A[i][0];
                switch(operation){
                    case 0 : headNode = addBeforeFirst(headNode,A[i][1]);
                        break;
                    case 1 : headNode = addAfterLast(headNode,A[i][1]);
                        break;
                    case 2 : headNode = addBeforeIndex(headNode,A[i][1],A[i][2]);
                        break;
                    case 3 : headNode = deleteNodeAtIndex(headNode,A[i][1]);
                }
            }
            return headNode;
        }

        public ListNode addBeforeFirst(ListNode headNode, int x){
            ListNode newNode = new ListNode(x);
            if(headNode == null){
                headNode = newNode;
            }else{
                newNode.next = headNode;
                headNode = newNode;
            }
            return headNode;
        }

        public ListNode addAfterLast(ListNode headNode, int x){
            ListNode newNode = new ListNode(x);
            if(headNode == null){
                headNode = newNode;
            }else{
                ListNode currNode = headNode;
                while(currNode.next !=null){
                    currNode = currNode.next;
                }
                currNode.next  = newNode;
            }
            return headNode;
        }

        public ListNode addBeforeIndex(ListNode headNode, int x, int index){
            int i=0;
            ListNode newNode = new ListNode(x);
            ListNode currNode = headNode;
            while(i<index-1 && currNode.next !=null){
                currNode = currNode.next;
                i++;
            }
            if(index==0){
                newNode.next = headNode;
                headNode = newNode;
            }
            if(i==index-1) {//if index is more than length of list, then, in that case, we dont insert the node, just return existing headNode.
                //also in that case, the headNode will be null and we get a NPE, when we do a headNode.next..
                newNode.next = currNode.next;
                currNode.next = newNode;
            }
            return headNode;
        }

        public ListNode deleteNodeAtIndex(ListNode headNode, int index){
            int i=0;
            ListNode currNode = headNode;
            if(headNode != null) {
                while (i < index - 1 && currNode != null) {
                    currNode = currNode.next;
                    i++;
                }
                if (index==0) {
                    headNode = headNode.next;
                } else if(currNode!= null && currNode.next !=null){
                    currNode.next = currNode.next.next;
                }
            }
            return headNode;
        }
}
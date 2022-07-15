package leetcode.contest;

public class MergeNodesBetnZeros {

	public static void main(String[] args) {
		S4 s = new S4();
		// 0,3,1,0,4,5,2,0
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(0);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(0);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		ListNode output = s.mergeNodes(n1);
		ListNode c = output;
		System.out.println("output : ");
		while (c != null) {
			System.out.println(output.val);
			c = c.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class S4 {
	public ListNode mergeNodes(ListNode head) {
		ListNode outputHead = null;
		int val = 0;
		ListNode currNode = head.next;
		while (currNode != null) {
			if (currNode != null && currNode.val != 0) {
				val = val + currNode.val;
			} else {
				val = 0;
				if (outputHead == null) {
					outputHead = new ListNode(val, null);
				} else {
					ListNode temp = new ListNode(val, null);
					ListNode node = outputHead;
					while (node.next != null) {
						node = node.next;
					}
					node.next = temp;
				}
			}
			currNode = currNode.next;
		}
		return outputHead;
	}
}
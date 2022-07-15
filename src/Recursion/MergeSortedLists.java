package Recursion;

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public ListNode() {
		this.data = 0;
		this.next = null;
	}
}

public class MergeSortedLists {

	public static void main(String[] args) {
		Solns s = new Solns();

//		ListNode l1node1 = new ListNode(10, null);
//		ListNode l1node2 = new ListNode(20, null);
//		ListNode l1node3 = new ListNode(30, null);
//		ListNode l1node4 = new ListNode(40, null);
//		ListNode l1node5 = new ListNode(50, null);
//
//		l1node1.next = l1node2;
//		l1node2.next = l1node3;
//		l1node3.next = l1node4;
//		l1node4.next = l1node5;
//
//		ListNode l2node1 = new ListNode(1, null);
//		ListNode l2node2 = new ListNode(8, null);
//		ListNode l2node3 = new ListNode(9, null);
//		ListNode l2node4 = new ListNode(10, null);
//		ListNode l2node5 = new ListNode(11, null);
//		ListNode l2node6 = new ListNode(33, null);
//
//		l2node1.next = l2node2;
//		l2node2.next = l2node3;
//		l2node3.next = l2node4;
//		l2node4.next = l2node5;
//		l2node5.next = l2node6;
//
//		ListNode headMerged = s.sortIterative(l1node1, l2node1);
//		while (headMerged.next != null) {
//			System.out.println(headMerged.data);
//			headMerged = headMerged.next;
//		}
//		System.out.println(headMerged.data);

		ListNode l1node1 = new ListNode(10, null);
		ListNode l1node2 = new ListNode(20, null);
		ListNode l1node3 = new ListNode(30, null);
		ListNode l1node4 = new ListNode(40, null);

		l1node1.next = l1node2;
		l1node2.next = l1node3;
		l1node3.next = l1node4;

		ListNode reversedList = s.reverseList(l1node1);
		while (reversedList.next != null) {
			System.out.println(reversedList.data);
			reversedList = reversedList.next;
		}
		System.out.println(reversedList.data);
		
//		ListNode l2node1 = new ListNode(1, null);
//		ListNode l2node2 = new ListNode(8, null);
//		ListNode l2node3 = new ListNode(9, null);
//		ListNode l2node4 = new ListNode(10, null);
//		ListNode l2node5 = new ListNode(11, null);
//		ListNode l2node6 = new ListNode(33, null);
//		ListNode l2node7 = new ListNode(50, null);

//		l2node1.next = l2node2;
//		l2node2.next = l2node3;
//		l2node3.next = l2node4;
//		l2node4.next = l2node5;
//		l2node5.next = l2node6;
//		l2node6.next = l2node7;
//
//		ListNode headMerged1 = s.sortRecursive(l1node1, l2node1, null);
//		while (headMerged1.next != null) {
//			System.out.println(headMerged1.data);
//			headMerged1 = headMerged1.next;
//		}
//		System.out.println(headMerged1.data);
	}
}

class Solns {
	public ListNode sortIterative(ListNode head1, ListNode head2) {
		// use a tail pointer also, for the lists to make insert at end of list easier
		// without traversing for each insert.
		ListNode headMerged = null;
		while (head1 != null && head2 != null) {
			ListNode newNode = new ListNode();
			if (head1.data > head2.data) {
				newNode.data = head2.data;
				head2 = head2.next;
			} else {
				newNode.data = head1.data;
				head1 = head1.next;
			}

			if (headMerged == null) {
				headMerged = newNode;
			} else {
				// append at the end of the list
				ListNode currNode = headMerged;
				while (currNode.next != null) {
					currNode = currNode.next;
				}
				currNode.next = newNode;
			}
		}

		while (head1 != null) {
			ListNode newNode = new ListNode();
			newNode.data = head1.data;
			// append at the end of the list
			ListNode currNode = headMerged;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
			head1 = head1.next;
		}

		while (head2 != null) {
			ListNode newNode = new ListNode();
			newNode.data = head2.data;
			// append at the end of the list
			ListNode currNode = headMerged;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
			head1 = head1.next;
		}
		return headMerged;
	}

	public ListNode sortRecursive(ListNode head1, ListNode head2, ListNode headMerged) {
		if (head1 == null && head2 == null) {
			return headMerged;
		}
		if(head1==null) {
			copyFromListTo(head2, headMerged);
		}
		if(head2==null) {
			copyFromListTo(head1, headMerged);
		}
		if (head1 != null && head2 != null) {
			ListNode newNode = new ListNode();
			if (head1.data > head2.data) {
				newNode.data = head2.data;
				head2 = head2.next;
			} else {
				newNode.data = head1.data;
				head1 = head1.next;
			}

			if (headMerged == null) {
				headMerged = newNode;
			} else {
				// append at the end of the list
				ListNode currNode = headMerged;
				while (currNode.next != null) {
					currNode = currNode.next;
				}
				currNode.next = newNode;
			}
			sortRecursive(head1, head2, headMerged);
		}
		// copy remaining elements from list1 using a recursive function
		return headMerged;
	}

	public void copyFromListTo(ListNode head, ListNode headMerged) {
		if (head == null)
			return;
		ListNode newNode = new ListNode();
		newNode.data = head.data;
		// append at the end of the list
		ListNode currNode = headMerged;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
		head = head.next;
		copyFromListTo(head, headMerged);
	}
	
	ListNode reverseList(ListNode listNode) {
		if(listNode==null || listNode.next == null) {
			return listNode;
		}
		ListNode x= reverseList(listNode.next);
		listNode.next.next = listNode;
		listNode.next = null;
		return x;
	}
	
}

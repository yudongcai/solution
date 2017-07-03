package com.codility.solution;

public class LinkedListCycleDetect {
	public boolean hasCycle(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		
		Node p1 = n;
		Node p2 = n.next;
		
		while (p2 != null && p2.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
			if (p2 == p1) {
				return true;
			}
		}
		
		
		return false;
	}
	
	public Node reverse(Node currentNode) {
		if (currentNode == null) {
			return currentNode;
		}
		
		// For first node, previousNode will be null
		Node previousNode = null;
		Node nextNode = currentNode.next;
		while (currentNode != null) {
			// reversing the link
			currentNode.next = previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode = currentNode;
			currentNode = nextNode;
			nextNode = currentNode.next;
		}
		return previousNode;

	}
	
	public Node lastElement(Node currentNode) {
		if (currentNode == null) {
			return currentNode;
		}
		
		Node nextNode = currentNode.next;
		while (nextNode != null) {
			currentNode = nextNode;
			nextNode = currentNode.next;
		}
		return currentNode;
	}

	public Node removeLastThreeNode(Node head) {
		Node ptr0 = head;
		Node ptr1 = ptr0 != null ? ptr0.next : null;
		Node ptr2 = ptr1 != null ? ptr1.next : null;
		Node ptr3 = ptr2 != null ? ptr2.next : null;

		while (ptr3 != null && ptr3.next != null) {
			ptr0 = ptr1;
			ptr1 = ptr2;
			ptr2 = ptr3;
			ptr3 = ptr3.next;
		}
		
		ptr0.next = null;

		return head;
	}
}

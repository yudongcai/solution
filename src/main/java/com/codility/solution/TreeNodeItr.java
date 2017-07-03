package com.codility.solution;

import java.util.Stack;

public class TreeNodeItr {
	public void inOrderIter(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<>();
		TreeNode currentNode = root;

		while (!s.empty() || currentNode != null) {

			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode n = s.pop();
				System.out.printf("%d ", n.data);
				currentNode = n.right;
			}
		}
	}

}

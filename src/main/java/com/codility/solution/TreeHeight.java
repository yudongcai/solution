package com.codility.solution;

public class TreeHeight {
	public int solution(Tree T) {
		return Math.max(getDepth(T) - 1, 0);
	}

	private int getDepth(Tree t) {
		if (t != null) {
			return 1 + Math.max(getDepth(t.l), getDepth(t.r));
		} else {
			return 0;
		}
	}

}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

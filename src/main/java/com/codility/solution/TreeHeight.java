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
	
	public int getLevelOfNode(Tree T, int key, int level) {
		if (T == null) {
			return 0;
		}
		
		if (T.x == key) {
			return level;
		}
		
		int result = getLevelOfNode(T.l, key, level + 1);
		
		if (result != 0) {
			return result;
		}
		
		return getLevelOfNode(T.r, key, level + 1);
	}

}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

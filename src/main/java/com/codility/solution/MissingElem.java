package com.codility.solution;

import java.util.Arrays;

/* num 1...N+1, find the missing num */
public class MissingElem {
	public int solution(int[] A) {
		Arrays.sort(A);
		int cur = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != cur) {
				break;
			}
			cur++;
		}
		return cur;
	}
}

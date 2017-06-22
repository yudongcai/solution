package com.codility.solution;

/* find min diff between before and after, scored 91%*/
public class TapeEquilibrium {
	public int solution(int[] A) {
		if (A.length == 2) {
			return Math.abs(A[0] - A[1]); 
		}
		
		long after = 0;
		for (int i = 0; i < A.length; i++) {
			after += A[i];
		}

		long pre = 0;
		long min = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			pre += A[i];
			after -= A[i];
			long diff = Math.abs(pre - after);
			if (min > diff) {
				min = diff;
			}
		}
		return (int) min;
	}

}

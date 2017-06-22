package com.codility.solution;

public class Rotation {
	public int[] solution(int[] A, int K) {
        if (K < 1 || A == null || A.length < 2) {
        	return A;
        }
        
        K = K % A.length;
        if (K == 0) {
        	return A;
        }
        
        int[] b = new int[A.length];
        for (int i=0; i<A.length; i++) {
        	int j = getNewIndex(i, K, A.length);
        	b[j] = A[i];
        }
        
		return b;
    }

	private int getNewIndex(int i, int k, int size) {
		
		int pos = i+k;
		if (pos < size) {
			return pos;
		} else {
			return pos - size;
		}
	}

}

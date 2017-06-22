package com.codility.solution;

/*f a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

Write a function,

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.

For example, given array A consisting of six elements such that:

  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
the function should return 356, as explained above.

Assume that:

N is an integer within the range [0..400,000];
each element of array A is an integer within the range [0..200,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).*/
//66%, performance - 25%
public class MaxProfit {
	public int solution(int[] A) {
		int l = A.length;
		if (l < 2) {
			return 0;
		}

		//int min = Integer.MAX_VALUE;
		int profit = 0;
		int maxHight = 0;
		int maxPos = 0;
		for (int i = 0; i < l - 1; i++) {
			int cur = A[i];

			if (i <= maxPos) {
				profit = Math.max(profit, A[maxPos] - cur);
				continue;
			}
			
			//find next maxProfit and maxHight
			for (int j = i + 1; j < l; j++) {
				if (A[j] > maxHight) {
					maxHight = A[j];
					maxPos = j;
				}
				if (A[j] > cur) {
					profit = Math.max(profit, A[j] - cur);
				}
			}
			
			
		}
		return profit;

	}

}

package com.codility.solution;

/*We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
56%,, performance 25%
*/
public class Intersect {
	public int solution(int[] A) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }
        
        int[] lower = new int[len];
        int[] upper = new int[len];
        for (int i=0; i<len; i++) {
            int cur = A[i];
            lower[i] = i - cur;
            upper[i] = i + cur;
        }
        
//        App.print(A);
//        App.print(lower);
//        App.print(upper);
        
       /* We say that the J-th disc and K-th disc intersect if J ≠ K 
        * and the J-th and K-th discs have at least one common point 
        * (assuming that the discs contain their borders).*/
        int count = 0;
        for (int i=0; i<len; i++) {
            int a1 = lower[i];
            int a2 = upper[i];
            //int sect = 0;
            for (int j=i+1; j<len; j++) {
                int b1= lower[j];
                int b2 = upper[j];
                if ((b1 >= a1 && b1 <= a2) || (b2 >= a1 && b2 <= a2) || (b1 <= a1 && b2 >= a2)) {
                	//sect++;
                    count++;
                    if (count > 10000000) {
                        return -1;
                    }
                }
            }
            //System.out.println(i + ", " + A[i] + ", has sects - " + sect);
        }
        
        return count;       
    }
}

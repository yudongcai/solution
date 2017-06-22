package com.codility.solution;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		int[] a = {1, 5, 2, 1, 4, 0};
		Intersect r = new Intersect();
		int v = r.solution(a);
		System.out.println(v + "");
	}
	
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}
	
	/*public static void main(String[] args) {
		int[] a = {1, 2, 3};
		Rotation r = new Rotation();
		for (int k = 0; k<5; k++) {
			int[] b = r.solution(a, k);
			for (int i : b) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}
		
	}*/
	
	/*public static void main(String[] args) {
		int N = 805306373;
		BinaryGap g = new BinaryGap();
		System.out.println(g.solution(N));
	}*/
}

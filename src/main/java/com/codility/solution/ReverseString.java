package com.codility.solution;

public class ReverseString {
	public String solution(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		
		final char[] arr = s.toCharArray();
		final int len = arr.length;
		for (int start = 0, end = len - 1; start > end; start++, end--) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		
		return new String(arr);
	}

}

package com.codility.solution;

public class BinaryGap {
	public int solution(int N) {
		String binStr = Integer.toBinaryString(N);
		System.out.println(binStr);
		int max = 0;
		for (int i = 0; i < binStr.length();) {
			char c = binStr.charAt(i);
			if (c == '0') {
				i++;
			} else if (c == '1') {
				int count = 0;
				int j = i + 1;
				for (; j < binStr.length(); j++) {
					char c2 = binStr.charAt(j);
					if (c2 == '0') {
						count++;
					} else if (c2 == '1') {
						// terminate
						if (count > max) {
							max = count;
						}
						break;
					}
				}
				i = j;
			}
		}

		return max;
	}
}

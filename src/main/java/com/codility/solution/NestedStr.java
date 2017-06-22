package com.codility.solution;

import java.util.Stack;

/*A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".*/
public class NestedStr {
	public int solution(String S) {
		int len = S.length();
        if (len == 0) {
            return 1;
        }
        if (len == 1) {
            return 0;
        }
        Stack<Character> st = new Stack<>();
        
        for (char c : S.toCharArray()) {
        	if (c == '(' || c == '[' || c == '{') {
        		st.push(c);
        		continue;
        	} else if (st.empty()) {
        		return 0;
        	} else {
        		char top = st.pop();
        		boolean isPare = false;
        		switch (c) {
        		case ')' : isPare = top == '('; break;
        		case ']' : isPare = top == '['; break;
        		case '}' : isPare = top == '{';
        		}
        		if (!isPare) {
        			return 0;
        		}
        	}
        	
        }
        
        return st.empty() ? 1 : 0; //!iimportant
	}

}

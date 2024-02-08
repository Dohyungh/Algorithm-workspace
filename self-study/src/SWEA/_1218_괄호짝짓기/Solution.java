package SWEA._1218_괄호짝짓기;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc<=10; tc++) {
			boolean flag = true;
			
			Stack<Character> stack = new Stack<Character>();
			
			int N = sc.nextInt();
			String str = sc.next();
			
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c !='}' && c!='>' && c!=')' && c!=']') {
					stack.push(c);
					
				} else {
					if (stack.isEmpty()) {
						flag = false;
						continue;
					}
					char o = stack.pop();
					if (o == '{' && c=='}' || o=='('&& c==')'|| o=='<'&& c=='>'|| o=='['&& c==']') {
						continue;
					} else flag = false;
				}
			}
			
			if (flag) System.out.printf("#%d 1%n",tc);
			if (!flag) System.out.printf("#%d 0%n",tc);
			
		}
	}

}

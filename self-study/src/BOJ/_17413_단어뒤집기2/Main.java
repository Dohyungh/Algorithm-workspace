package BOJ._17413_단어뒤집기2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		// 변수 이름 짓기는 참 어려워
		boolean inthegwalho = false;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		int idx = 0;
		while (idx < str.length()) {
			if (str.charAt(idx) == '<') {
				sb.append(str.charAt(idx));
				inthegwalho = true;
				idx++;
				continue;
			}
			
			if (str.charAt(idx) == '>') {
				sb.append(str.charAt(idx));
				inthegwalho = false;
				idx++;
				continue;
			}
			
			if (inthegwalho) {
				sb.append(str.charAt(idx));
				idx++;
				continue;
			}
			
			if (!inthegwalho) {
				if(str.charAt(idx) != ' ') {
					stack.add(str.charAt(idx));
				}
				
			}
			
			if(!inthegwalho && (str.charAt(idx)==' ' || idx <str.length() && r.charAt(idx+1)=='<')) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				if(idx != str.length()-1 && str.charAt(idx+1)!='<') {
					sb.append(' ');
				}
			}
//			System.out.println(idx);
//			System.out.println(sb.toString());
			idx++;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		
		sc.close();
	}

}

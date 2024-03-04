package SWEA._모의_두개의탑;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IM {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt();
			int M1 = sc.nextInt();
			int M2 = sc.nextInt();
			
			int answer = Integer.MAX_VALUE;
			
			int[] weights = new int[N];
			
			for (int i = 0; i <N; i++) {
				weights[i] = sc.nextInt();
			}
			
			Arrays.sort(weights);
			
			
			Stack<Integer> stack1 = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			
			for (int i = N-1; i>=0; i--) {
				if (i %2 ==0 && stack1.size() < M1) {
					stack1.add(weights[i]);
				}
				else if (i %2 == 1 && stack2.size() <M2) {
					stack2.add(weights[i]);
				}
				else {
					if (stack1.size() <M1) stack1.add(weights[i]);
					if (stack2.size() <M2) stack2.add(weights[i]);
				}
			}
			
//			System.out.println(stack1);
//			System.out.println(stack2);
			
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = 0; i < M1; i++) {
				sum1 += stack1.pop() * (M1-i);
//				System.out.println(sum1);
				
			}
			for (int i = 0; i < M2; i++) {
				sum2 += stack2.pop() * (M2-i);
//				System.out.println(sum2);
				
			}
			
			
			
			System.out.printf("#%d %d%n", tc, sum1+sum2);
		}
	}

}

package SWEA._B2_이진수표현;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			boolean off = false;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				if ((M & (1<<i)) == 0) {
//					System.out.println(i);
					off = true;
					break;
				}
			}
			
			
			if (off) {
				System.out.printf("#%d OFF%n", tc);
			} else {
				System.out.printf("#%d ON%n", tc);
			};
			
		}
	}

}

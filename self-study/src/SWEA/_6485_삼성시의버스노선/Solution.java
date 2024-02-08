package SWEA._6485_삼성시의버스노선;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] stop = new int[5001];
			
			for (int i = 0; i<N; i++) {
				int small = sc.nextInt();
				int big = sc.nextInt();
				
				for (int j = small; j<=big; j++) {
					stop[j]++;
				}
				
			}
			int P = sc.nextInt();
			System.out.printf("#%d", tc);
			for (int i =0; i<P; i++) {
				System.out.printf(" %d", stop[sc.nextInt()]);
				
			}
			System.out.println();
		}
	}

}

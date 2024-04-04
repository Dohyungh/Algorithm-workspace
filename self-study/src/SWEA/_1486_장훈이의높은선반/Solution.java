package SWEA._1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			
			int[] heights = new int[N];
			
			int S = 0;
			for (int i = 0; i < N; i++) {
				heights[i] = sc.nextInt();
				S += heights[i];
			}
			
			boolean[][] dpTable = new boolean[N][S+1];
			dpTable[0][S-heights[0]] = true;
			dpTable[0][S] = true;
			// 모든 점원에 대해서
			for (int i = 1; i < N; i++) {
				for (int j = S; j >= B; j--) {
					if (dpTable[i-1][j]) {
						dpTable[i][j] = true;
						dpTable[i][j-heights[i]] = true;
					}
				}
			}
			
			for (int i = B; i < S+1; i++) {
				if (dpTable[N-1][i]) {
					System.out.printf("#%d %d%n", tc, i-B);
					break;
				}
			}
			
		}
		
		sc.close();
		
	}
	
	

}

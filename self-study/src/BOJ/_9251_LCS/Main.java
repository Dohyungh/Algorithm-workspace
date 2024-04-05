package BOJ._9251_LCS;

import java.util.Scanner;

public class Main {
	static int answer = 0;
	
	static char[] str1;
	static char[] str2;
	
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.nextLine().toCharArray();
		str2 = sc.nextLine().toCharArray();
		
		dp = new int[str2.length][str1.length];
		
		int start_idxR = 0;
		int start_idxC = 0;
		int start_idxR1 = 0;
		int start_idxC1 = 0;
		out:
		for (int i = str1.length-1; i >=0; i--) {
			for(int j = str2.length-1; j>=0; j--) {
				if (str1[i] == str2[j]) {
					System.out.println(i);
					System.out.println(j);
					start_idxR1 = j;
					start_idxC1 = i;
					
					for (int c = 0; c <=i; c++) {
						dp[j][c] = 1;
					}
					for (int c = 0; c <=j; c++) {
						dp[c][i] = 1;
					}
					break out;
				}
			}
		}
		int start_idxC2 = 0;
		int start_idxR2 = 0;
		out:
		for (int i = str2.length-1; i >=0; i--) {
			for(int j = str1.length-1; j>=0; j--) {
				if (str2[i] == str1[j]) {
					start_idxC2 = j;
					start_idxR2 = i;
					
					for (int c = 0; c <=j; c++) {
						dp[i][c] = 1;
					}
					for (int c = 0; c <=i; c++) {
						dp[c][j] = 1;
					}
					break out;
				}
			}
		}
		if (start_idxR1 * str1.length + start_idxC1 > start_idxR2 * str1.length + start_idxC2) {
			start_idxR = start_idxR1;
			start_idxC = start_idxC1;
		} else {
			start_idxR = start_idxR2;
			start_idxC = start_idxC2;
		}

		for (int i = start_idxR-1; i>=0; i--) {
			for(int j = str1.length-2; j>=0; j--) {
				if (str2[i] == str1[j]) {
					dp[i][j] = Math.max(dp[i][j+1], 1+dp[i+1][j+1]);
				} else {
					dp[i][j] = dp[i][j+1];
				}
				dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
				
			}
		}
		System.out.println(dp[0][0]);
		
	}
//	private static void DP(int start_i, int start_j, int i, int j, int pick ) {
//		System.out.println("start_i: " + start_i + " start_j: " + start_j + " i: " + i + " j: " + j + " pick: " + pick);
//		
//		if (i == str2.length || j==str1.length) {
//			dp[start_i][start_j] = Math.max(pick, dp[start_i][start_j]);
//			return;
//		}
//		
//		int earliest = -1;
//		for (int b = j; b < str1.length; b++) {
//			if (str2[i] == str1[b]) {
//				earliest = b;
//				break;
//			}
//		}
//		
//		// 고를래
//		if (earliest != -1)	DP(start_i,start_j,i+1,earliest+1,pick+1);
//		
//		// 안고를래
//		// 이거 이미 했는데?!!!
//		DP(start_i,start_j,i+1,j,pick);
//	}

}

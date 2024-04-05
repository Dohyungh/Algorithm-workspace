package BOJ._11048_이동하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int[][] map;
	
	static int N;
	static int M;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();
		}
		
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[N-1][M-1] = map[N-1][M-1];
		
		
		System.out.println(DFS(0,0));
	}
	private static int DFS(int i, int j) {
		
		
		if (dp[i][j] != -1) return dp[i][j];
		
		dp[i][j] = map[i][j];
		
		int plus = -1;
		if ( i+1 < N) {
			plus = Math.max(plus, DFS(i+1,j));
		}
		if ( j+1 < M) {
			plus = Math.max(plus, DFS(i,j+1));
		}
		if ( i+1 < N && j+1 < M) {
			plus = Math.max(plus, DFS(i+1,j+1));
		}

		
		dp[i][j] += plus;
		return dp[i][j];
	}

}

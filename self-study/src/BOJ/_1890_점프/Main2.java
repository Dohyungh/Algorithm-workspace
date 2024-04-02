package BOJ._1890_점프;

import java.util.Scanner;

public class Main2 {
	//시간초과
	
	static long answer;
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		answer = 0L;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DP(0,0);
		
		System.out.println(answer);
		
		
	}

	private static void DP(int i, int j) {
		if (i >= N || j >= N) return;
		if (i == N-1 && j == N-1) {
			answer++;
			return;
		}
		DP(i+map[i][j],j);
		DP(i,j+map[i][j]);
		
	}

}

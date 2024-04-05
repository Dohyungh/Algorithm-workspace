package BOJ._1149_RGB거리;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j< 3;j++) map[i][j] = sc.nextInt();
		}
		
		int[][] dpMap = new int[N][3];
		
		dpMap[N-1] = map[N-1];
		for (int i = N-2; i>=0; i--) {
			dpMap[i][0] = Math.min(dpMap[i+1][1], dpMap[i+1][2]) + map[i][0];
			dpMap[i][1] = Math.min(dpMap[i+1][0], dpMap[i+1][2]) + map[i][1];
			dpMap[i][2] = Math.min(dpMap[i+1][1], dpMap[i+1][0]) + map[i][2];
		}
		int ans = Math.min(dpMap[0][0], dpMap[0][1]);
		ans = Math.min(dpMap[0][2], ans);		
		System.out.println(ans);
		
	}

}

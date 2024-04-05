package BOJ._2096_내려가기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) map[i][j] = sc.nextInt();
		}
		
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		
		dpMax[N-1][0] = dpMin[N-1][0] = map[N-1][0]; 
		dpMax[N-1][1] = dpMin[N-1][1] = map[N-1][1]; 
		dpMax[N-1][2] = dpMin[N-1][2] = map[N-1][2]; 
		for (int i = N-2; i>=0; i--) {
			dpMax[i][0] = Math.max(dpMax[i+1][0], dpMax[i+1][1]) + map[i][0];
			dpMax[i][1] = Math.max(dpMax[i+1][0], dpMax[i+1][1]);
			dpMax[i][1] = Math.max(dpMax[i][1], dpMax[i+1][2]) + map[i][1];
			dpMax[i][2] = Math.max(dpMax[i+1][1], dpMax[i+1][2]) + map[i][2];
			
			dpMin[i][1] = Math.min(dpMin[i+1][0], dpMin[i+1][1]);
			dpMin[i][0] = Math.min(dpMin[i+1][0], dpMin[i+1][1]) + map[i][0];
			dpMin[i][1] = Math.min(dpMin[i][1], dpMin[i+1][2]) + map[i][1];
			dpMin[i][2] = Math.min(dpMin[i+1][1], dpMin[i+1][2]) + map[i][2];
		}
		
		int max = 0;
		int min = 0;
		
		max = Math.max(dpMax[0][0], dpMax[0][1]);
		max = Math.max(max , dpMax[0][2]);
		
		min = Math.min(dpMin[0][0], dpMin[0][1]);
		min = Math.min(min, dpMin[0][2]);
		
		System.out.print(max);
		System.out.print(" ");
		System.out.print(min);
		
		
	}

}

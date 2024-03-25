package SWEA._모의_벌꿀채취;

import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int best;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 넉 중 for문
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-M+1; j++) {
					
					for (int k = 0; k <N; k++) {
						for (int l = 0; l <N-M+1; l++) {
							
							if (k < i || ((k ==i) && l<=j+M-1)) continue;
							
							best = 0;
							boolean[] chosen = new boolean[M];
							getBest(i, j, 0, 1, chosen, 0);
							int one = best;
							
							best = 0;
							chosen = new boolean[M];
							getBest(k, l, 0, 1, chosen, 0);
							int two = best;						
							
							answer = Math.max(answer, one+two);
							
							
						}
					}
				}
				
			}
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
	
	
	private static void getBest(int i, int j, int depth, int n, boolean[] chosen, int start) { // chosen : msize
				
		if (depth == n) {
			int sum = 0;
			for (int z = 0; z < M; z++) {
				if (chosen[z]) {
					sum += map[i][j+z];					
				}
			}
			if (sum > C) return;
			
			if (sum <= C) {
				best = Math.max(calc(i,j,chosen), best);
				getBest(i,j,depth,n+1,chosen,start);
			}
			
		}
		
		
		else {
			for (int z = start; z <chosen.length; z++) {
				if (!chosen[z]) {
					chosen[z] = true;
					getBest(i, j, depth+1, n, chosen, start+1);
					chosen[z] = false;
				}
			}
		}
	}


	private static int calc(int i, int j, boolean[] chosen) {
		int price = 0;
		for (int z = 0; z < M; z++) {
			if (chosen[z]) {
				price += map[i][j+z]*map[i][j+z];
			}
		}
		
		return price;
	}

}

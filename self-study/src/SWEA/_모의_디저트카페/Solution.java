package SWEA._모의_디저트카페;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++ ) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			boolean[] cnt;
			int answer = -1;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					
					for (int d1 = 1; d1 <=Math.min(j, N-2-i); d1++) {
						out:
						for (int d2 = 1; d2 <= Math.min(N-1-j, N-2-i); d2++) {
							
							if (!(j-d1>=0 && i+d1+d2 <=N-1 && j+d2 <=N-1)) continue;
							
							cnt = new boolean[101];
							
							int nr = i;
							int nc = j;
							// 출바알
							while(nr<i+d1) {
								if (cnt[map[nr][nc]]) continue out;
								cnt[map[nr][nc]] = true;
								nr++;
								nc--;
							}
							while(nr<i+d1+d2) {
								if (cnt[map[nr][nc]]) continue out;
								cnt[map[nr][nc]] = true;
								nr++;
								nc++;
							}
							while(nr>i+d2) {
								if (cnt[map[nr][nc]]) continue out;
								cnt[map[nr][nc]] = true;
								nr--;
								nc++;
							}
							while(nr>i) {
								if (cnt[map[nr][nc]]) continue out;
								cnt[map[nr][nc]] = true;
								nr--;
								nc--;
							}
							
							answer = Math.max(answer, 2*(d1+d2));
						}
					}
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
	}

}

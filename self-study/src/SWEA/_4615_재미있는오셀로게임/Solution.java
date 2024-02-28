package SWEA._4615_재미있는오셀로게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			
			map[N/2-1][N/2-1] = 2;
			map[N/2][N/2] = 2;
			
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			
			for (int m = 0; m < M; m++) {
				int c = sc.nextInt()-1;
				int r = sc.nextInt()-1;
				int color = sc.nextInt();
				
				map = play(r,c,color,map);
				
			}
			
			
			// 2
			int white_cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] ==2) white_cnt++;
				}
			}
			// 1
			int black_cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] ==1) black_cnt++;
				}
			}
			
			System.out.printf("#%d %d %d%n", tc, black_cnt, white_cnt);
			
		}
		
		sc.close();
	}
	
	public static int[][] play(int r, int c, int color, int[][] map) {
		int[][] temp = new int[map.length][map.length];
		
		for (int i = 0; i < map.length; i++) {
			temp[i] = Arrays.copyOf(map[i], map[i].length);
			
		}
		
		temp[r][c] = color;
		//팔방 탐색
		
		int[] dr = {-1,1,0,0,-1,-1,1,1};
		int[] dc = {0,0,-1,1,1,-1,1,-1};
		
		for (int d = 0; d < 8; d++) {
			int nr = r;
			int nc = c;
			int cnt = 0;
			while(true) {
				nr = nr+dr[d];
				nc = nc+dc[d];

				if (nr < 0 || nr>=map.length || nc <0 || nc >=map.length) break;
				
				if(temp[nr][nc] ==0) {
					break;
				}
				else if(temp[nr][nc] ==3-color) {
					cnt++;
				}
				else if(temp[nr][nc] ==color) {
					for (int i = 0; i < cnt; i++) {
						nr = nr - dr[d];
						nc = nc - dc[d];
						temp[nr][nc] =color;
					}
					break;
				}
			}
			
		}

		return temp;
	}

}

package SWEA._모의_핀볼게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1,1,0,0}; // 상, 하 ,좌, 우
	static int[] dc = {0,0,-1,1};
	static int dir;
	
	static int locX;
	static int locY;
	
	static int N;
	static int[][] map;
	
	
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1 ; tc <= T; tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			
			List<int[]> starts = new ArrayList<>();
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 0) starts.add(new int[] {i,j});
				}
			}
			answer = 0;
			
			int final_answer = 0;
			for (int[] start : starts) {
				for (int d = 0; d <4; d++) {
					dir = d;
					simulation(start);

					final_answer = Math.max(final_answer, answer);
					answer = 0;
				}
			}
			
			
			System.out.printf("#%d %d%n", tc, final_answer);
			
		}
		
	}

	private static void simulation(int[] start) {
		int init_locX = start[0];
		int init_locY = start[1];
		
		locX = start[0];
		locY = start[1];
		
		
		while (true) {
			
			update();
			
			if (locX == init_locX && locY ==init_locY) break;
			if (locX >=0 && locX <N && locY >=0 && locY <N && map[locX][locY] == -1) break;
		}
		
		
	}

	private static void update() {

		locX = locX +dr[dir];
		locY = locY +dc[dir];
		
		//벽
		if (locX <0 || locY<0 || locX>=N || locY>=N) {
			if (dir == 0 || dir ==1) dir = 1-dir;
			else dir = 5 -dir;
			answer++;
			return;
		}
		
		if (map[locX][locY] == 1) {
			answer++;
			if (dir == 0) {
				dir = 1;
				return;
			}
			if (dir == 1) {
				dir = 3;
				return;
			}
			if (dir == 2) {
				dir = 0;
				return;
			}
			if (dir == 3) {
				dir = 2;
				return;
			}

		}
		if (map[locX][locY] == 2) {
			answer++;
			if (dir == 0) {
				dir = 3;
				return;
			}
			if (dir == 1) {
				dir = 0;
				return;
			}
			if (dir == 2) {
				dir = 1;
				return;
			}
			if (dir == 3) {
				dir = 2;
				return;
			}
			
		}
		if (map[locX][locY] == 3) {
			answer++;
			if (dir == 0) {
				dir = 2;
				return;
			}
			if (dir == 1) {
				dir = 0;
				return;
			}
			if (dir == 2) {
				dir = 3;
				return;
			}
			if (dir == 3) {
				dir = 1;
				return;
			}
			
		}
		if (map[locX][locY] == 4) {
			answer++;
			if (dir == 0) {
				dir = 1;
				return;
			}
			if (dir == 1) {
				dir = 2;
				return;
			}
			if (dir == 2) {
				dir = 3;
				return;
			}
			if (dir == 3) {
				dir = 0;
				return;
			}
			
		}
		if (map[locX][locY] == 5) {
			answer++;
			if (dir == 0) {
				dir = 1;
				return;
			}
			if (dir == 1) {
				dir = 0;
				return;
			}
			if (dir == 2) {
				dir = 3;
				return;
			}
			if (dir == 3) {
				dir = 2;
				return;
			}
			
		}
		
		if (map[locX][locY] >= 6) {
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					if ((i !=locX || j !=locY) && map[i][j] == map[locX][locY]) {
						locX = i;
						locY = j;
						return;
					}
				}
			}
			
		}
		
		
		
		
	}

}

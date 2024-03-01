package SWEA._모의_미생물격리;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			int[][] dir = new int[N][N];
			for (int i =0; i < N; i++) {
				for (int j =0; j< N; j++) {
					dir[i][j] = -1;
				}
			}
			
			for (int i= 0; i< K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				
				int num = sc.nextInt();
				int di = sc.nextInt()-1;
				map[r][c] = num;
				dir[r][c] = di;
			}
			
			int cnt = 0;
			while( cnt <M) {

				int[][] tempDir = copy(dir);
				int[][] tempMap = copy(map);
				
				dir = dirUpdate(tempDir, tempMap);
				map = mapUpdate(tempMap, tempDir);
				cnt++;
			}
			
			int answer = 0;
			for (int i = 0; i< map.length; i++) {
				for (int j= 0; j< map[i].length; j++) {
					answer += map[i][j];
				}
			}
			System.out.printf("#%d %d%n",tc,answer);
		}
		sc.close();
	}
	
	private static int[][] copy(int[][] dir) {
		
		int[][] temp = new int[dir.length][dir.length];
		
		for (int i = 0; i<temp.length; i++) {
			temp[i] = Arrays.copyOf(dir[i], dir[i].length);
		}
		return temp;
	}

	// 점을 기준으로 업데이트
	private static int[][] dirUpdate(int[][] tempdir, int[][] tempmap) {
		int N = tempdir.length;
		int[][] map = copy(tempmap);
		int[][] dir = new int[N][N];
		
		for (int i = 0; i< N; i++) {
			for (int j = 0; j <N; j++) {
				dir[i][j] = -1;
			}
		}
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int[] loc = {i,j};
				if (inBorder(N, loc)) {
					for (int d = 0; d <4; d++) {
						int nr = i +dr[d];
						int nc = j +dc[d];
						
						if (nr >=0 && nr <N && nc >=0 && nc <N && map[nr][nc] !=0 && tempdir[nr][nc] ==d) {
							if (tempdir[nr][nc] == 0 || tempdir[nr][nc] ==1) dir[i][j] = 1 -tempdir[nr][nc];
							else {
								dir[i][j] = 5 - tempdir[nr][nc];
							}
						}
					}
					
				} else {					
					int nowMax = 0;
					for (int d = 0; d <4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >=0 && nr <N && nc >=0 && nc <N && map[nr][nc] !=0 && tempdir[nr][nc] ==d) {
							nowMax = Math.max(nowMax, map[nr][nc]);
							if (nowMax == map[nr][nc]) {
								dir[i][j] = tempdir[nr][nc];
							}
						}
					}
				}
			}
		}
		return dir;
		
		
	}

	private static int[][] mapUpdate(int[][] tempmap, int[][] tempdir) {
		
		int N = tempmap.length;
		int[][] map = new int[N][N];
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		for (int i =0 ; i< N; i++) {
			for (int j = 0; j< N; j++) {
				int[] loc = {i,j};
				if (inBorder(N, loc)) {
					for (int d = 0; d <4; d++) {
						int nr = i +dr[d];
						int nc = j +dc[d];
						
						if(nr >=0 && nr <N && nc >=0 && nc <N && tempdir[nr][nc] ==d) {
							map[i][j] = tempmap[nr][nc] /2;
						}
					}
					
				} else {
					for (int d = 0; d <4; d++) {
						int nr = i +dr[d];
						int nc = j +dc[d];
						
						if(nr >=0 && nr <N && nc >=0 && nc <N && tempdir[nr][nc] ==d) {
							map[i][j] += tempmap[nr][nc];
						}
					}
				}
			}
		}
		
		return map;	
	}

	public static boolean inBorder (int N, int[] loc) {
		
		if(loc[0] ==0 || loc[0] == N-1 || loc[1] == 0 || loc[1] ==N-1) return true;
		return false;
		
	}
	

}

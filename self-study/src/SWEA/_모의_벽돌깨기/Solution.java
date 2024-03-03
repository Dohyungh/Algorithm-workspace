package SWEA._모의_벽돌깨기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[][] originMap;
	static boolean[][] bombed;
	static List<int[]> cases;
	static int answer;
	static int N;
	static int W;
	static int H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T ; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			originMap = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j <W; j++) {
					originMap[i][j] = sc.nextInt();
				}
			}
			answer = Integer.MAX_VALUE;
			

			List<Integer> candidates = new ArrayList<Integer>();

			for (int j = 0; j < W; j++) {
				if (getTop(originMap, j)!=-1) {
					candidates.add(j);
					
				}
			}

			DFS(0,originMap,candidates);
			System.out.printf("#%d %d%n", tc, answer);

		}
	}
	
	private static int countRemain(int[][] map) {
		int cnt = 0;
		for (int i = 0 ; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] !=0) cnt++;
			}
		}
		return cnt;
	}

	
	public static int getTop(int[][] map, int col) {
		for (int i = 0; i <map.length; i++) {
			if (map[i][col] != 0) {
				return i;
			}
		}
		return -1;
	}

	// 복사 남발 금지
	public static void bomb (int row, int col, int[][] map,boolean[][] visited) { // 뭐가 터지는지를 줘야 재귀를 씀

		visited[row][col] =true;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int range = map[row][col];
		if (range ==1) {
			bombed[row][col] = true;
			
			return;
		}
		if (range >=2 ) {
			bombed[row][col] = true;
			for (int r =1; r < range; r++) {
				for (int d = 0; d < 4; d++) {
					int nr = row + dr[d]*r;
					int nc = col + dc[d]*r;
					
					if (nr >=0 && nr <H && nc >=0 && nc <W) {
						bombed[nr][nc] = true;
			
						if (map[nr][nc] >= 2 && !visited[nr][nc]) bomb(nr,nc,map, visited);
					}
					
				}
			}
		}
	}
	
	public static int[][] explosion (int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (bombed[i][j]) map[i][j] = 0;
			}
		}
		
		// 가라앉히고
		out:
		for (int j = 0; j <map[0].length; j++) {
			label:
			for (int i = map.length-1; i>=0; i--) {
				if(map[i][j] == 0) {
					for (int k = i-1; k>=0; k--) {
						if (map[k][j] !=0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							continue label;
						}
					}
					continue out;
				}
			}
		}
		return map;
		
	}
	
	public static void DFS(int depth,int[][] oriMap, List<Integer> candidates) {
		if(candidates.isEmpty()) {
			answer = 0;
			return;
		}
		
		if (depth == N) {
			answer = Math.min(countRemain(oriMap), answer);


			return;
		}
		
		for (int i = 0; i < candidates.size(); i++) {
			int[][] map = new int[H][W];
			for (int k = 0; k < H; k++) map[k] = Arrays.copyOf(oriMap[k], W);
			bombed = new boolean[H][W];
			boolean[][] visited = new boolean[H][W];
			bomb(getTop(map, candidates.get(i)), candidates.get(i), map,visited);
			map = explosion(map);
			
			List<Integer> newCandidates = new ArrayList<Integer>();
			for (int j = 0; j < W; j++) {
				if (getTop(map, j)!=-1) {
					newCandidates.add(j);
					
				}
			}
			
			DFS(depth+1,map,newCandidates);
			
		}
				
	}

}

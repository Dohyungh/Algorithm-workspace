package SWEA._모의_벽돌깨기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[][] originMap;
	static boolean[][] bombed;
	static List<int[]> cases;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T ; tc++) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			
			originMap = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j <W; j++) {
					originMap[i][j] = sc.nextInt();
				}
			}
			
			cases = new ArrayList<int[]>();
			getCases(N,W);
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) map[i] = Arrays.copyOf(originMap[i], originMap[i].length);
			
				
				bombed = new boolean[N][N];
			
			
			
			
			
			
			
		}
	}
	
	//n 자리의 w 진수를 써야함. 비트마스킹
	//일단 여기까지
	private static void getCases(int n, int w) {
		int[] aCase = new int[n];
		for (int i = 0; i<w; i++) {
			for (int j = 0; j<w; j++) {
				
			}
		}
		
	}

	public static void bomb (int row, int col, int[][] oriMap) { // 뭐가 터지는지를 줘야 재귀를 씀
		int N = oriMap.length;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) map[i] = Arrays.copyOf(originMap[i], N);
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int range = map[row][col];
		
		for (int r =0; r < range; r++) {
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d]*r;
				int nc = col + dc[d]*r;
				
				if (nr >=0 && nr <N && nc >=0 && nc <N) {
					bombed[nr][nc] = true;
					if (map[nr][nc] != 0) bomb(nr,nc,oriMap);
				}
				
			}
		}
	}

}

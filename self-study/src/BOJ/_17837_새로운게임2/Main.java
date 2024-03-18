package BOJ._17837_새로운게임2;

import java.util.Scanner;

public class Main {
	
	static int[][] colorMap; // 색깔 맵
	static int[][] numMap; // 쌓인 개수 맵
	static int[][] pieces; // 
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		colorMap = new int[N][N];
		numMap = new int[N][N];
		
		pieces = new int[K][4]; // r, c, stack, dir
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				colorMap[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < K; i++) {
			pieces[i][0] = sc.nextInt()-1;
			pieces[i][1] = sc.nextInt()-1;
			pieces[i][2] = 1; // 2개 이상인 경우는 없다 했다.
			pieces[i][3] = sc.nextInt()-1;
		}
		
		int turn = 0;
		while(true) {
			turn++;
			for (int i = 0; i < K; i++) {
				move(i);
				if(stackCheck()) break;
			}
		}
		
		
		
	}

	private static void move(int i) {
		int r = pieces[i][0];
		int c = pieces[i][1];
		int stack = pieces[i][2];
		int dir = pieces[i][3];
		
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if (colorMap[nr][nc] == 0) { // 흰색
			
			
			
		} else if (colorMap[nr][nc] == 1) { // 빨간색
			
		} else if (colorMap[nr][nc] == 2) { // 파란색
			
		}
	}

	private static boolean stackCheck() {

		
		return false;
	}

}

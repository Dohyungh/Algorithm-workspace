package BOJ._16235_나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int K;
	
	static int[][] S2D2;
	
	static int[][] nutrition;
	
	static int[][][] tree;
	
	public static void main(String[] args) throws IOException {
		
//		0.3s
//		22%
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시뮬 개싫어
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		
		S2D2 = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nutrition = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutrition[i][j] = 5;
			}
		}
		
		
		tree = new int[N][N][]; // 이거 맞아?? 나무가 여러개 //파이썬 마려운 순간! // 배열에 리스트..??
		
		
		for (int m = 0; m < M; m++) {
			
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]) - 1;
			int c = Integer.parseInt(str[1]) - 1;
			tree[r][c] = new int[] {Integer.parseInt(str[2])};
			
		}
		

		for (int k = 0; k < K; k++) {
			
			spring();
			summer();
			fall();
			winter();
			
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				
//				System.out.println(Arrays.toString(tree[i][j]));
//				
//			}
//			
//		}
		
		
		
	}

	private static void spring() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j< N; j++) {
				
				if (tree[i][j] != null) {
					for (int k = 0; k < tree[i][j].length; k++) {
						if(nutrition[i][j] > tree[i][j][k]) {
							nutrition[i][j] -= tree[i][j][k];
							tree[i][j][k]++;
						}
						else {
							tree[i][j][k] = -1;
						}
					}
				}
				
			}
		}
		
		
		
	}

	private static void summer() {
		
		
	}

	private static void fall() {
		
		
	}
	
	private static void winter() {
		
		
	}

	

}

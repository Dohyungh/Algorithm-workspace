package BOJ._12865_평범한배낭;

import java.util.Scanner;

public class Main_fin {
	// 땡스 투 아마존 개발자 무랄맄 씨

	// 내가 특정 무게에서 해볼 수 있는 시도는
	// 그 무게에 들어갈 수 있는 item을
	// 넣거나
	// 빼거나
	
	// 그 무게에 들어갈 수 없는 item을
	// 빼거나
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int K = sc.nextInt();
		
		int[][] items = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		
		int[][] dpMap = new int[N+1][K+1];
		
		for (int i = 0; i < N+1; i++) {
			dpMap[0][i] = dpMap[i][0] = 0;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < K+1; j++) {
				if (items[i-1][0] <= j) {
					dpMap[i][j] = Math.max(items[i-1][1] + dpMap[i-1][j-items[i-1][0]], dpMap[i-1][j]);
					
				} else {
					dpMap[i][j] = dpMap[i-1][j];
				}
			}
		}
		
		System.out.println(dpMap[N][K]);
	}
	

}

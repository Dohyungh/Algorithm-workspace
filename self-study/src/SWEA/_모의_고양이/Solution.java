package SWEA._모의_고양이;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	
	static int[][] map; // 전체 맵
	static int[][] rests; // 쉼터 좌표 입력
	static int N; // 맵 크기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 개수 입력
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			int M = sc.nextInt();
			
			rests = new int[M][2];
			
			map = new int[N][N];
			
			// 맵 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 쉼터 좌표 입력
			for (int i = 0; i < M; i++) {
				rests[i][0] = sc.nextInt();
				rests[i][1] = sc.nextInt();
			}
			
			// 답안을 inf로 초기화
			int answer = Integer.MAX_VALUE;
			// 최솟값을 찾는다.
			// 각 쉼터마다 출발지에서 쉼터까지의 최소 위험도, 쉼터에서 목적지까지의 최소 위험도를 더해주고, 함수의 구조상 쉼터의 값이 한번 더 더해지므로 뺴준다.
			// 그 값이 지금 까지 찾은 답안보다 작은면 업데이트한다.
			for (int i = 0; i < M; i++) {
				answer = Math.min(answer, getMostSafe(new int[] {0,0}, rests[i]) + getMostSafe(rests[i], new int[] {N-1,N-1}) - map[rests[i][0]][rests[i][1]]);
			}
			System.out.printf("#%d %d%n", tc, answer);
			
		}
		
		sc.close();
	}

	private static int getMostSafe(int[] start, int[] end) {
		
		int[][] dp = new int[N][N];
		// 최솟값으로 갱신해야 하므로
		// dp 테이블의 값은 최댓값으로 안전하게 초기화해준다.
		for (int i =0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		// dp 테이블의 오른쪽 아래 목적지는 지도에서 가져온다.
		dp[end[0]][end[1]] = map[end[0]][end[1]];
		
		// dp 테이블의 오른쪽 끝열과 아래쪽 끝행을 초기화 해준다.
		for (int i = end[0]-1; i >=start[0]; i--) {
			
			dp[i][end[1]] = map[i][end[1]] + dp[i+1][end[1]];
		}
		for (int i = end[1]-1; i >=start[1]; i--) {
			dp[end[0]][i] = map[end[0]][i] + dp[end[0]][i+1];
		}
		
		// 행우선순회를 밑에서 위로 도는 역순으로 돌면서 오른쪽과 아래쪽 값 중에 작은 값에 map 상에서 자기의 위험도를 더해
		// dp 테이블을 업데이트 해나간다.
		for (int i = end[0]-1; i>=start[0]; i--) {
			for (int j = end[1]-1; j >= start[1]; j--) {
				dp[i][j] = map[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}
		//마지막에 dp 테이블의 좌상단 값을 리턴하면 최소 위험도를 리턴하게 된다.
		return dp[start[0]][start[1]];
	}

}

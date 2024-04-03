package BOJ._20058_마법사상어와파이어스톰;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N;
	static int Q;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int[] p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = (int) Math.pow(2, sc.nextInt());
		Q = sc.nextInt();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int q = 0; q < Q; q++) {
			simul(sc.nextInt());
		}
		
		System.out.println(sum(map));
		System.out.println(largestFamily(map));
		
		sc.close();
	}

	private static void simul(int nextInt) {
		
		int len = (int) Math.pow(2, nextInt);
		
		for (int i = 0; i < N; i+=len) { 
			for (int j = 0; j < N; j+=len) {
				
				////////////////////////////////// 복제
				int[][] tmp = new int[len][len];
				for (int k = 0; k < len; k++) {
					for (int l = 0; l < len; l++) {
						tmp[k][l] = map[i+k][j+l];
					}
				}
				//////////////////////////////////
				
				for (int k = 0; k < len; k++) {
					for (int l = 0; l < len; l++) {
						
						// 휘바휘바
						map[i+k][j+l] = tmp[len-l-1][k];
						
					}
				}
			}
		}
		
		
		// 또 복제
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = Arrays.copyOf(map[i], map[i].length);
		}
		/////////
		
		
		// 인접한 얼음 개수 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int adjIce = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] >0) adjIce++;
					}
					
				}
				
				if (!(adjIce >=3)) { // 문제 조건에 걸리면
					tmp[i][j] = map[i][j]-1; // 하나 뺴주기
				}
			}
		}
		map = tmp; // tmp 로 map 바꿔주기.
	}

	// 그냥 다 더해주기 (나는 0 지나서도 계속 빼줬기 때문에 살짝 추가됨
	private static int sum(int[][] map) {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer+=Math.max(map[i][j], 0); // 0보다 작으면 그냥 0
			}
		}
		return answer;
	}

	
	private static int largestFamily(int[][] map) {
		
		// 부모 배열
		// 부모의 위치를 배열 {r,c} 로 주기 싫어서 그냥 N²으로 쭉 늘어뜨림
		p = new int[N*N];
		
		// make-set
		for (int i = 0; i < p.length; i++) p[i] = i;
		
		for (int i = 0; i < N*N; i++) {
			// 쭉 늘어뜨리기
			int r = i / N;
			int c = i % N;
			
			for (int d = 0; d < 4; d++) {
				int adjR = r + dr[d];
				int adjC = c + dc[d];
				
				if (adjR < N && adjR >= 0 && adjC < N && adjC >=0) {
					
					// 둘 다 얼음이 있으면 연결!
					if (map[adjR][adjC] > 0 && map[r][c] > 0) {
						
						int p1 = adjR * N + adjC;
						int p2 = i;
						
						union(p1,p2);
						
					}
				}
			}	
		}
		
		
		// 모든 곳이 0. 즉, 얼음이 하나도 없으면 그냥 가장 큰 덩어리의 크기는 0 (!=1)
		out:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 0) break out;
				// 안 걸리고 끝까지 도달
				if (i == N-1 && j == N-1) return 0;
			}
		}
		
		
		//카운팅 배열 각 인덱스는 부모고, 부모가 그 인덱스인 애들 수만큼 카운트가 올라감.
		int[] count = new int [N*N];
		int max = 0;
		
		//
		// 이거 잘 할 수 있는 방법 있을 거 같은데..
		for (int i = 0; i < count.length; i++) {
			int p = find(i); // 부모를 찾아서
			count[p]++; // 카운팅 배열에서 숫자를 올려줌
			max = Math.max(max, count[p]); // 그냥 계속 업데이트 해
		}
		
		return max;
	}

	
	private static void union(int p1, int p2) {
		p[find(p1)] = find(p2);
	}

	private static int find(int p1) {
		if (p[p1] == p1) return p1;
		
		return p[p1] = find(p[p1]); // 패쓰 컴푸레쑌
	}

	
}

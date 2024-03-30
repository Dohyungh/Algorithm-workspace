package BOJ._19237_어른상어;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 오랜만에 객체 구현 말고 Map 구현으로 해보자
	
	static int[][] sharkMap;// sharkMap
	static int[][] smellMap;// smellMap
	static int[][] timeMap;// timeMap
	static int[] sharkDir;
	static int[][][] sharkInfo;
	
	static int N;
	static int M;
	static int K;
	
	static int leftShark;
	
	static boolean[] dead; // 디버깅해보니 실수 발견해서 어쩔 수 없이 넣어줌!
	// 상어가 계속 0,0 에서 리스폰 함..
	// nextLoc 가 계속 새로 생성되다 보니..
	
	static int[] dr = {-1,1,0,0}; // 위/ 아래/ 왼/ 오
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		// 아니 뭐 조건이 이래
		// 드럽게 빡센 시뮬레이션
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // map 크기 
		M = sc.nextInt(); // 상어 마리수
		K = sc.nextInt(); // 냄새 유지
		
		leftShark = M;
		
		sharkMap = new int[N][N];
		smellMap = new int[N][N];
		timeMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int numShark = sc.nextInt();
				sharkMap[i][j] = numShark;
				if (sharkMap[i][j] != 0) {
					timeMap[i][j] = K;
					smellMap[i][j] = numShark;
				}
			}
		}
		sharkInfo = new int[M+1][4][4];
		sharkDir = new int[M+1];
		dead = new boolean[M+1];
		for (int i = 1; i <= M; i++) {
			sharkDir[i] = sc.nextInt()-1;
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					sharkInfo[i][j][k] = sc.nextInt()-1;
				}
			}
		}
//		for (int i = 0; i < M+1; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.println(Arrays.toString(sharkInfo[i][j]));
//				
//			}
//		}
//		System.out.println();
		
		
		
		int cnt = 0;
		while (cnt < 1000) {
			simul();
			cnt++;
			if (leftShark ==1) break;
//			System.out.println(cnt+1);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(sharkMap[i]));
//				
//			}
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(smellMap[i]));
//				
//			}
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(timeMap[i]));
//				
//			}
//			System.out.println();
		}
//		System.out.println(leftShark);
		int answer = leftShark > 1 ? -1 : cnt;
		System.out.println(answer);
		
	}

	private static void simul() {
		int[][] nextLoc = new int[M+1][2];
		
		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				
				if (sharkMap[i][j] != 0) { // 상어네!
					int sharkIdx = sharkMap[i][j];
					int dir = -1;
					boolean foundEmpty = false;
					int nr = -1;
					int nc = -1;
					for (int d = 0; d < 4; d++) {
//						System.out.println(sharkIdx);
//						System.out.println(sharkDir[sharkIdx]);
						
						dir = sharkInfo[sharkIdx][sharkDir[sharkIdx]][d];
						nr = i + dr[dir];
						nc = j + dc[dir];
						if (nr >= 0 && nr < N && nc >= 0 && nc <N) {
							
							if (smellMap[nr][nc] == 0) {
								foundEmpty = true;
								break;
							}
						}
						
					}
					if (!foundEmpty) {
						for (int d = 0; d < 4; d++) {
							dir = sharkInfo[sharkIdx][sharkDir[sharkIdx]][d];
							nr = i + dr[dir];
							nc = j + dc[dir];
							if (nr >= 0 && nr < N && nc >= 0 && nc <N) {
								if (smellMap[nr][nc] == sharkIdx) {
									break;
								}
								
							}
							
						}
					}
					sharkDir[sharkIdx] = dir;
					nextLoc[sharkIdx][0] = nr;
					nextLoc[sharkIdx][1] = nc;
					sharkMap[i][j] = 0;
					
				}
			}
		}
		
		// 모든 상어의 다음 위치를 찾았다.
		
		for (int i = 1; i <= M; i++) {
			for (int j = i+1; j <=M; j++) {
				if (nextLoc[i][0] == nextLoc[j][0] && nextLoc[i][1] == nextLoc[j][1] && !dead[j] && !dead[i]) { // i 도 죽었으면 안되네.. 여기서 한참걸림
					nextLoc[j][0] = -1;
					nextLoc[j][1] = -1;
					dead[j] = true;
					leftShark--;
				}
			}
		}
		
		// 모든 쫓겨날 상어가 쫓겨났다.

		// 상어 이동 완료
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (timeMap[i][j] != 0) {
					if (timeMap[i][j] ==1) {
						smellMap[i][j] = 0;
					}
					timeMap[i][j]--;
				}
			}
		}
		for (int i = 1; i <=M; i++) {
			if (nextLoc[i][0] !=-1 && !dead[i]) {
				sharkMap[nextLoc[i][0]][nextLoc[i][1]] = i;
				timeMap[nextLoc[i][0]][nextLoc[i][1]] = K;	
				smellMap[nextLoc[i][0]][nextLoc[i][1]] = i;
				
			}
		}
//		for (int i = 1; i <= M; i++) {
//			System.out.println(Arrays.toString(nextLoc[i]));
//			
//		}

	}

}

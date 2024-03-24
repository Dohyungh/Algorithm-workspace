package BOJ._12100_2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer[]> cases = new ArrayList<>();
	
	static int[] dirs = {1,2,3,4};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 N = sc.nextInt();
		 
		 int[][] arr = new int[N][N];
		 
		 for (int i = 0; i < N; i++) {
			 for (int j = 0; j < N; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		 
		 Integer[] output = new Integer[5];
		 updateCases(0, output);
		 
		 int final_answer = 0;
		 for (int i = 0; i < cases.size(); i++) {
			 int[][] tempArr = new int[N][N];
			 for (int k = 0; k < N; k++) {
				 tempArr[k] = Arrays.copyOf(arr[k], N);
			 }
			 
			 Integer[] aCase = cases.get(i);
			 
			 for (int c = 0; c < 5; c++) {
				 play(tempArr, aCase[c]);
			 }
			 
			 for (int r = 0; r < N; r++) {
				 for (int c = 0; c< N; c++) {
					 final_answer = Math.max(final_answer, tempArr[r][c]);
				 }
			 }
		 }
		 System.out.println(final_answer);
		 
		 sc.close();
	}
	
	private static void updateCases(int depth, Integer[] output) {
		if (depth ==5) {
			cases.add(Arrays.copyOf(output, output.length));
			return;
		}
		
		for (int i = 1; i <=4; i++) {
			output[depth] = i;
			updateCases(depth+1, output);
		}
	}

	public static void play(int[][] arr, int dir) { // 1,2,3,4 // 상, 하, 좌, 우
		if (dir ==1) {
			for (int j = 0; j < N; j++) {
				int idx = 0;
				int now = -1;
				int before_index = -1;
				while (idx < N) {
					if (arr[idx][j] != 0 && now == -1) { // 최초로 0 이 아닌 원소 탐색 이건 그냥 따로 빼서 써도 되긴 함
						now = arr[idx][j];
						before_index = idx;
						idx++;
						continue;
					}
					if (arr[idx][j] != 0 && now != arr[idx][j]) {
						now = arr[idx][j];
						before_index = idx;
						idx++;
						continue;
					}
					if (arr[idx][j] != 0 && now == arr[idx][j]) {
						arr[before_index][j] *= 2;
						arr[idx][j] = 0;
						now = -1;
						before_index = -1;
						idx++;
						continue;
					}
					idx++;
					
					
				}
				// 이제 다 땡기러 다시 출발
				idx = 0;
				out:
				while(idx < N) {
					if (arr[idx][j] == 0) {
						boolean flag = false;
						for (int k = idx+1; k <N; k++) {
							if (arr[k][j] != 0) {
								arr[idx][j] = arr[k][j];
								arr[k][j] = 0;
								flag = true;
								break;
							}
						}
						if (!flag) break out;
					}
					idx++;
				}
				
			}
			
		}
		if (dir ==2) {
			for (int j = 0; j < N; j++) {
				int idx = N-1;
				int now = -1;
				int before_index = -1;
				while (idx >= 0) {
					if (arr[idx][j] != 0 && now == -1) { // 최초로 0 이 아닌 원소 탐색 이건 그냥 따로 빼서 써도 되긴 함
						now = arr[idx][j];
						before_index = idx;
						idx--;
						continue;
					}
					if (arr[idx][j] != 0 && now != arr[idx][j]) {
						now = arr[idx][j];
						before_index = idx;
						idx--;
						continue;
					}
					if (arr[idx][j] != 0 && now == arr[idx][j]) {
						arr[before_index][j] *= 2;
						arr[idx][j] = 0;
						now = -1;
						before_index = -1;
						idx--;
						continue;
					}
					idx--;
					
					
				}
				// 이제 다 땡기러 다시 출발
				idx = N-1;
				out:
				while(idx >=0) {
					if (arr[idx][j] == 0) {
						boolean flag = false;
						for (int k = idx-1; k >=0; k--) {
							if (arr[k][j] != 0) {
								arr[idx][j] = arr[k][j];
								arr[k][j] = 0;
								flag = true;
								break;
							}
						}
						if (!flag) break out;
					}
					idx--;
				}
				
			}
			
		}
		if (dir ==3) {
			for (int i = 0; i < N; i++) {
				int idx = 0;
				int now = -1;
				int before_index = -1;
				while (idx < N) {
					if (arr[i][idx] != 0 && now == -1) { // 최초로 0 이 아닌 원소 탐색 이건 그냥 따로 빼서 써도 되긴 함
						now = arr[i][idx];
						before_index = idx;
						idx++;
						continue;
					}
					if (arr[i][idx] != 0 && now != arr[i][idx]) {
						now = arr[i][idx];
						before_index = idx;
						idx++;
						continue;
					}
					if (arr[i][idx] != 0 && now == arr[i][idx]) {
						arr[i][before_index] *= 2;
						arr[i][idx] = 0;
						now = -1;
						before_index = -1;
						idx++;
						continue;
					}
					idx++;
					
					
				}
				// 이제 다 땡기러 다시 출발
				idx = 0;
				out:
				while(idx < N) {
					if (arr[i][idx] == 0) {
						boolean flag = false;
						for (int k = idx+1; k < N; k++) {
							if (arr[i][k] != 0) {
								arr[i][idx] = arr[i][k];
								arr[i][k] = 0;
								flag = true;
								break;
							}
						}
						if (!flag) break out;
					}
					idx++;
				}
				
			}
			
		}
		if (dir ==4) {
			for (int i = 0; i < N; i++) {
				int idx = N-1;
				int now = -1;
				int before_index = -1;
				while (idx >= 0) {
					if (arr[i][idx] != 0 && now == -1) { // 최초로 0 이 아닌 원소 탐색 이건 그냥 따로 빼서 써도 되긴 함
						now = arr[i][idx];
						before_index = idx;
						idx--;
						continue;
					}
					if (arr[i][idx] != 0 && now != arr[i][idx]) {
						now = arr[i][idx];
						before_index = idx;
						idx--;
						continue;
					}
					if (arr[i][idx] != 0 && now == arr[i][idx]) {
						arr[i][before_index] *= 2;
						arr[i][idx] = 0;
						now = -1;
						before_index = -1;
						idx--;
						continue;
					}
					idx--;
					
					
				}
			
				// 이제 다 땡기러 다시 출발
				idx = N-1;
				out:
				while(idx >= 0) {
					if (arr[i][idx] == 0) {
						boolean flag = false;
						for (int k = idx-1; k >=0; k--) {
							if (arr[i][k] != 0) {
								arr[i][idx] = arr[i][k];
								arr[i][k] = 0;
								flag = true;
								break;
							}
						}
						if (!flag) break out;
					}
					idx--;
				}
				
			}
			
		}
		
		
		
	}

}

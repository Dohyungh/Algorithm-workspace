package BOJ._15684_사다리조작;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 첫인상
	//깊이가 30 이니까 웬만하면 완탐 아닐 듯.
	//이게 골3?
	//뭔가 있긴 있다
	//시뮬이 아닌거 가틈
	
	// 결론
	// ㄴㄴ 완탐임
	// 머리 굴려서 계산을 좀 하자.
	//재귀류(DFS, DP)로 풀라 하면.. 시간초과 나겠지
	//300 * 300 * 300 / 6 = 450 만 개밖에 안됨.
	
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		M = sc.nextInt();
		int H = sc.nextInt();
		
		int[][] oriSwaps = new int[M][2];
		
		
		for (int m = 0; m < M; m++) {
			oriSwaps[m][0]=sc.nextInt();
			oriSwaps[m][1]=sc.nextInt();
		}
		
		int[] arr = new int[N+1];
		for (int i = 1; i <N+1; i++) {
			arr[i] = i;
		}
		
		
		int[][] swaps;
		
		
		int answer = -1;
		sorts(oriSwaps);

		if (getResult(oriSwaps, arr, 0)) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i<=H; i++) {
			for (int j = 1; j<N; j++) {
				int first = i * N + j;
				swaps= copy(oriSwaps);
				if (contains(swaps,i,j)) continue;
				swaps[M][0] = i;
				swaps[M][1] = j;

				sorts(swaps);
				
				
				if (getResult(swaps, arr, 1)) {
					System.out.println(1);
					return;
				}
				
				
				for (int k = i; k <=H; k++) {
					for (int l = 1; l <N; l++) {
						int second = k*N +l;
						if (second <= first) continue;
						swaps= copy(oriSwaps);

						swaps[M][0] = i;
						swaps[M][1] = j;
						if (contains(swaps,k,l)) continue;
						swaps[M+1][0] = k;
						swaps[M+1][1] = l;

						
						sorts(swaps);
						
						
						if (getResult(swaps,arr,2)) {
							if (answer == -1) answer = 2;
							else {
								answer = Math.min(answer, 2);										
							}
						}
						
						for (int a = k; a <=H; a++) {
							for (int b = 1; b < N; b++) {
								swaps= copy(oriSwaps);
								int third = a*N+b;
								if (third <= first || third <= second) continue;

								swaps[M][0] = i;
								swaps[M][1] = j;
								swaps[M+1][0] = k;
								swaps[M+1][1] = l;
								if (contains(swaps,a,b)) continue;
								swaps[M+2][0] = a;
								swaps[M+2][1] = b;
								sorts(swaps);
								
								
								if (getResult(swaps,arr,3)) {
									if (answer == -1) answer = 3;
									else {
										answer = Math.min(answer, 3);										
									}
								}
								
								
								
//								if(i==3 &&j==2 &&k==4 &&l==1 &&a==4 &&b==3 ) {
//									
//									for (int c = 0 ; c< swaps.length; c++) {
//										System.out.println(Arrays.toString(swaps[c]));
//										return;
//										
//									}
//								}
								
							}
						}
						
						
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean getResult(int[][] swaps, int[] arr, int numAdd) {
		
		int[] tempArr = Arrays.copyOf(arr, arr.length);
		
		
		
		boolean correct = true;
		

		
		for (int n = 0; n < swaps.length; n++) {
			int i = swaps[n][1];
			if(i==0) continue;
			
			int tmp = tempArr[i];
			
			tempArr[i] = tempArr[i+1];
			tempArr[i+1] = tmp;
			
		}
		
		for (int i =0; i<tempArr.length; i++) {
			if (tempArr[i] != i) correct = false;
//			System.out.println(Arrays.toString(tempArr));
		}
		
		return correct;
	}
	
	public static void sorts(int[][] swaps) {
		Arrays.sort(swaps, (o1, o2)-> {
	        return o1[0] - o2[0];

		});
	}
	
	public static int[][] copy(int[][] oriSwaps) {
		int[][] swaps = new int[M+3][2];
		
		for (int i = 0; i<M; i++) {
			swaps[i] = Arrays.copyOf(oriSwaps[i], 2);
		}
		
		return swaps;
	}
	
	public static boolean contains(int[][] swaps, int i, int j) {
		boolean impossible = false;
		for (int k = 0; k < swaps.length; k++) {
			if (swaps[k][0] == i && (swaps[k][1] == j || swaps[k][1] == j-1 || swaps[k][1] == j+1)) {
				impossible = true;
				break;
			}
			
		}
		
		return impossible;
	}
}

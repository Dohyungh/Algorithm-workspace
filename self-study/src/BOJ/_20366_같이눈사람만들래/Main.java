package BOJ._20366_같이눈사람만들래;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] coupleArr = new int[N*N][3];
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				coupleArr[idx][2] = arr[i] + arr[j];
				coupleArr[idx][0] = i;
				coupleArr[idx][1] = j;
				idx++;
			}
		}
		
		Arrays.sort(coupleArr, (o1, o2) -> {return o1[2] - o2[2];});
		
		for (int i = 0; i < N*N; i++) {
			System.out.println(Arrays.toString(coupleArr[i]));			
		}
		
		
		
		sc.close();
		
	}

}

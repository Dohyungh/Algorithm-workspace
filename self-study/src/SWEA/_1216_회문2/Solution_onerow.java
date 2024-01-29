package SWEA._1216_회문2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_onerow {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bf.readLine(); // tc는 버리고
		int N = 100;
		char[][] arr = new char[N][];
		
		for (int i = 0; i<N;i++) {
			arr[i] = bf.readLine().toCharArray();
		}
		
		System.out.println(Arrays.toString(arr[99]));
		int[] new_arr = new int[N];
		
		for (int i =0; i<N-1; i++) {
			if (arr[i] == arr[i+1]) {
				new_arr[i] = 2;
			} else {
				new_arr[i] = 1;
			}
		}
		System.out.println(Arrays.toString(new_arr));
		
		int flag = 1;
		int cycle = 1; // 이전 사이클이 한 사이클
		int max = 0;
		while (flag == 1) {
			flag = 0;
			cycle++;
			System.out.println(cycle);
			for (int i = 1; i<N; i++) {
				if (i+new_arr[i] <N && (new_arr[i]==2*cycle-3 || new_arr[i]==2*cycle-2)) {
					if (arr[i-1]==arr[i+new_arr[i]]) {
						new_arr[i-1] +=2;
						
						flag = 1;
						max = Math.max(max, new_arr[i-1]);
						System.out.println(Arrays.toString(new_arr));
						System.out.println(max);
					}
				}
			}
		}
		
		
		
		

//		
		


	}

}

package BOJ._12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 숫자와 숫자 사이 간격을 이분탐색
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			left = Math.min(left, num);
			right = Math.max(right, num);
			arr[i] = num;
		}
		
		int 
		
		
		
		
	}

}

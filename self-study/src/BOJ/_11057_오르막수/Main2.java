package BOJ._11057_오르막수;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	
	// 시간초과
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		answer = 0;
		
		int[] answers = new int[1001];
		for (int idx = 1; idx <= 10; idx++) {
			
			answer = 0;
			
			for (int start = 0; start <= 9; start++) {
				DP(idx,1,start);		
			}
			
			answers[idx] = answer; 
		}
		
		System.out.println(Arrays.toString(answers));

	}
	
	public static void DP(int r, int i, int now) {
		if (r == i) {
			// 마지막 자리 도달했으면 정답 출력
			answer++;
			return;
		}
		
		// 지금 자리 i에 어떤 수를 넣을 것인가?
		// now 부터 9까지 모두 넣을 수 있지
		for (int j = now; j<=9; j++) {
			DP(r,i+1,j);
		}
	}

}

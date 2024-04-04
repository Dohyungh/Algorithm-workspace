package BOJ._10942_팰린드롬물음표;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 칠판에 쓴 수열 입력
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		
		// 질문 개수 입력
		int Q = sc.nextInt();
		
		// 디피따블로
		// 행은 from
		// 열은 to
		int[][] dpTable = new int[N+1][N+1];
		
		// 자기 자신 에서 자기 자신은 무조건 회문
		for (int i = 1, j = 1; i <= N; i++,j++) {
			dpTable[i][j] = 1;
		}
		
		// 자기 자신에서 바로 다음 꺼까지는 일일히 확인 해줘야함
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i+1]) { // 다음꺼랑 같을 때만 회문
				dpTable[i][i+1] = 1;
			}
		}
		
		// 점화식은
		
		// 회문(from,to) = 회문(from+1, to-1) && arr[from] == arr[to]
		
		// 이제 대각으로 읽어 내려가면서 **왼쪽아래** 친구가 회문이었으면서, from과 to가 같으면 회문!
		for (int i = 3; i <= N; i++) {
			
			for (int k = 1, j = i; j <= N; k++,j++) {
				if (dpTable[k+1][j-1] ==1 && arr[k] == arr[j]) dpTable[k][j] = 1;
			}
			
		}
		
		// 백준 특 
		StringBuilder sb = new StringBuilder();
		
		// 만든 디피따블로에서 그냥 읽기만 하자
		for (int q = 0; q < Q; q++) {
			
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			sb.append(dpTable[from][to] + "\n");
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}

}

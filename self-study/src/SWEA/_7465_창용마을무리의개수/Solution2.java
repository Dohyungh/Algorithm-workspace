package SWEA._7465_창용마을무리의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	
	// 마지막에 parents 배열에 같은 무리에 속한 애들끼리는 모두가 같은 값(루트)을 가지게 하고 싶음
	
	// 자식이 루트에 붙을 때
	// 루트가 자식에 붙을 때
	// 두 가지 경우 모두 다 결국에는 루트로 거슬러 올라간 다음
	// 한쪽 루트가 잡아 먹히고
	// 잡아먹힌 루트 밑으로 모든 자식들도 잡아 먹히는 것을
	// 구현해야 함.
	
	// 단순히 부모 배열에서 마구잡이로 덮어쓰는 느낌이 아니라
	// 재귀를 적극적으로 써서 루트를 찾는 과정이 꼭 있어야 함.
	
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for (int tc = 1; tc <= T; tc++) {
				
				int N = sc.nextInt();
				int M = sc.nextInt();
				
				
				int p[] = new int[N+1];
				// make-set
				for (int i = 1; i < N+1; i++) p[i] = i;
				
				for (int i = 0; i < M; i++) {
					int idx1 = sc.nextInt();
					
					int idx2 = sc.nextInt();
					
					int p1 = -1;
					
					int p2 = -1;
					
					//idx1 의 부모를 찾자
					if (p[idx1] == idx1) p1 = idx1;
					else {
						p1 = idx1;
						while(p[p1] != p1) {
							p1 = p[idx1];
						}
					}
					
					//idx2 의 부모를 찾자
					if (p[idx2] == idx2) p2 = idx2;
					else {
						p2 = idx2;
						while(p[p2] != p2) {
							p2 = p[idx2];
						}
					}
					
					// 자식 사이즈에 따라 누가 누구에게 먹힐지도 정해보자
					// 거느린 자식이 적은 애들이 많은 쪽으로 먹히는 걸로!
					
					List<Integer> famP1 = new ArrayList<>();
					List<Integer> famP2 = new ArrayList<>();
					
					for (int n = 1; n < N+1; n++) {
						if (p[n] == p1) {
							famP1.add(n);
						}
						if (p[n] == p2) {
							famP2.add(n);
						}
					}
					
					List<Integer> bigFam = famP1.size()>=famP2.size() ? famP1 : famP2;
					List<Integer> smallFam = famP1.size()>=famP2.size() ? famP2 : famP1;
					
					int Root = p[bigFam.get(0)];
					
					// 잡아먹힌다.
					for (int sf : smallFam) p[sf] = Root;

				}
				
				int answer = 0;
				boolean[] check = new boolean[N+1];
				for (int i = 1; i< N+1; i++) {
					if (!check[p[i]]) {
						answer++;
						check[p[i]] = true;
						
					}
				}
				
				System.out.println(Arrays.toString(p));
				System.out.printf("#%d %d%n", tc, answer);

				
			}
			
	
	
	
	
	}
	

}

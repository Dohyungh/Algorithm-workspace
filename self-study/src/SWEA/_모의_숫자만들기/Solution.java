package SWEA._모의_숫자만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Queue<Integer> numQ;
	static List<int[]> cases;
	static int[] cards;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			numQ = new LinkedList<>(); // N개
			cases = new ArrayList<>();
			
			cards = new int[4]; // N-1개
			for (int i = 0; i < 4; i++) { //+, -, *, /
				cards[i] = sc.nextInt();
			}
			
			int[] intCards = new int[N-1]; // 0,0,1,2
			
			int idx = 0;
			for (int i = 0; i < cards[0]; i++) {
				intCards[idx] = 0;
				idx++;
			}
			for (int i = 0; i < cards[1]; i++) {
				intCards[idx] = 1;
				idx++;
			}
			for (int i = 0; i < cards[2]; i++) {
				intCards[idx] = 2;
				idx++;
			}
			for (int i = 0; i < cards[3]; i++) {
				intCards[idx] = 3;
				idx++;
			}
			
//			System.out.println(Arrays.toString(intCards));
			for (int i = 0; i < N; i++) {
				numQ.add(sc.nextInt());
			}
			boolean[] visited = new boolean[N-1];
			int[] output = new int[N-1];
			getCases(intCards);
//			for (int i = 0; i < cases.size(); i++) {
//				System.out.println(Arrays.toString(cases.get(i)));
//			}
			// 중복을 해결하지 못했군요
			// 아 메모리 에러가 나네요
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for (int[] aCase : cases) {
				max = Math.max(max, calculator(aCase, numQ));
				min = Math.min(min, calculator(aCase, numQ));
			}
			
			System.out.printf("#%d %d%n", tc, max-min);
			
		}
	}
	
	private static int calculator(int[] aCase, Queue<Integer> numq) {
		int N = numq.size()-1;
				
		int answer = numq.poll();
		numq.add(answer);
		
		for (int i = 0; i < N; i++) {
			int num = numq.poll();
			numq.add(num);
			if (aCase[i] == 0) answer +=num;
			if (aCase[i] == 1) answer -=num;
			if (aCase[i] == 2) answer *=num;
			if (aCase[i] == 3) answer /=num;
		}
		
		
		
		return answer;
	}

	public static void getCases(int[] intCards) {
//		if (depth == r) {
//			cases.add(Arrays.copyOf(output, output.length));					
//		}
//		
//		for (int i = 0; i<intCards.length; i++) {
//			if (!visited[i]) {
//				output[depth] = intCards[i];
//				visited[i] = true;
//				getCases(intCards, output, visited, depth+1, r);
//				visited[i] = false;
//			}
//		}
//		for (int i = 0; i<15; i++) {
//			System.out.println(Arrays.toString(intCards));
//			
//		}
		
		while (intCards != null) {
			cases.add(intCards);
			intCards = nextPermutation(intCards);
		
		}
		
	}
	public static int[] nextPermutation(int[] input) {
		int[] intCards = Arrays.copyOf(input, input.length);
		int N = intCards.length;
		int idx = N-1;
		while(idx >0 && intCards[idx-1] >= intCards[idx]) --idx;
		
		if (idx ==0) return null;
		
		int big = N-1;
		while (intCards[idx-1]>=intCards[big]) {
			--big;
		}
		int temp = intCards[idx-1];
		intCards[idx-1] = intCards[big];
		intCards[big] = temp;
		
		Arrays.sort(intCards, idx, N);
		
		return intCards;
		
	}
	


}

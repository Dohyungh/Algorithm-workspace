package SWEA._1215_회문1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for (int tc = 1; tc<=T;tc++) {
			int n = Integer.parseInt(bf.readLine());
			char[][] arr = new char[8][];
			
			for (int i = 0; i<8;i++) {
				arr[i] = bf.readLine().toCharArray();
			}
			
			int ans = 0;
			
			Deque<Character> deque = new ArrayDeque<>();
			
			//범위가 다르기 때문에 가로 세로를 분리해야함.
			for (int i = 0; i<8; i++) {
				for (int j = 0; j<=8-n; j++) {
					for (int k = 0; k<n; k++) {
						deque.add(arr[i][j+k]);						
					}
					
					boolean isPalindrome = true;
					while (deque.size()>1) {
						char L = deque.pollFirst();
						char R = deque.pollLast();
						
						if (!(L==R)) {
							isPalindrome = !isPalindrome;
							break;
						}
					}
					deque.clear();
					if (isPalindrome) {
						ans++;
					}
					
				}
			}
			
			for (int j = 0; j<8; j++) {
				for (int i = 0; i<=8-n; i++) {
					for (int k = 0; k<n; k++) {
						deque.add(arr[i+k][j]);						
					}
					
					boolean isPalindrome = true;
					while (deque.size()>1) {
						char L = deque.pollFirst();
						char R = deque.pollLast();
						
						if (!(L==R)) {
							isPalindrome = !isPalindrome;
							break;
						}
					}
					deque.clear();
					if (isPalindrome) {
						ans++;
					}
					
				}
			}
			
			System.out.printf("#%d %d%n", tc,ans);
		}
		
		
		
		
		
	}

}

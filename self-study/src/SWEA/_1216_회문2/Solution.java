package SWEA._1216_회문2;

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
			bf.readLine(); // tc는 버리고
			char[][] arr = new char[100][];
			
			for (int i = 0; i<100;i++) {
				arr[i] = bf.readLine().toCharArray();
			}
			
			int max_length = 0;
			for (int i = 0; i<100; i++) {
				
				int temp = func(arr[i]);
				if (temp > max_length) max_length = temp;
				
				
			}
			
			
		}
				
	}
	
	public int func(char[] arr) {
		int ans = 0;
		return ans;
	}

}

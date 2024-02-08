//package SWEA._1216_회문2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Deque;
//
//public class Solution {
//	
//	static int global_count = 0;
//	
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int T = 10; // 10으로!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		int N = 100;
//		
//		for (int tc = 1; tc<=T;tc++) {
//			bf.readLine(); // tc는 버리고
//			char[][] arr = new char[N][];
//			
//			for (int i = 0; i<N;i++) {
//				arr[i] = bf.readLine().toCharArray();
//			}
//			
//			int max_length = 0;
//			for (int i = 0; i<N; i++) {
//				
//				global_count=0;
//				func(arr[i],0,N-1);
//				if (global_count > max_length) max_length = global_count;
//				
//				global_count=0;
//				func(arr[i],1,N-1);
//				if (global_count > max_length) max_length = global_count;
//				
//				global_count=0;
//				func(arr[i],0,N-2);
//				if (global_count > max_length) max_length = global_count;
//	
//			
//			}
//			
//			for (int i =0; i<N; i++) {
//				char[] vertical_arr = new char[N];
//				for (int j = 0; j<N; j++) {
//					vertical_arr[j] = arr[j][i];
//				}
//				
////				System.out.println(Arrays.toString(vertical_arr));
//
//				global_count=0;
//				func(vertical_arr,0,N-1);
//				if (global_count > max_length) max_length = global_count;
//				
//				global_count=0;
//				func(vertical_arr,1,N-1);
//				if (global_count > max_length) max_length = global_count;
//				
//				global_count=0;
//				func(vertical_arr,0,N-2);
//				if (global_count > max_length) max_length = global_count;
//					
//					
//				
//			}
//			System.out.printf("#%d %d%n",tc,max_length);
//			Math.m
//			
//			
//		}
//				
//	}
//
//	
//	
//	public static int longest(char[] arr, int i, int j) {
//		if ((j-i)==1) {
//			if (arr[i] == arr[j]) {
//				return 4;
//				
//			} else return 0;
//			
//		if (j==i) {
//			return 2;
//		}
//		if (i+1<j) {
//			if (arr[i] == arr[j]) {
//				return 0;
//				
//			}
//		}
//		}
//		}
//	}
//
//}
//
//
//

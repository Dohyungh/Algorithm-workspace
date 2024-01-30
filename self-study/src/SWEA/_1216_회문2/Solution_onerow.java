package SWEA._1216_회문2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_onerow {

	public static void main(String[] args) throws IOException {
		

		int N = 100;
		char[] arr = "CCBBCBAABCCCBABCBCAAAACABBACCCCACAABCBBACACAACABCBCCBAABCABBBCCAABBCBBCACABCAAACACABACBCCBAACBCBCAAC".toCharArray();
		
		int left =0;
		int right =0;
		int max = 0;
		for (int i = 0; i<N; i++) {
			left = i;
			right = i;
			while (left>=0 && right<=N-1) {
				if (arr[left] == arr[right]) {
					max = Math.max(right-left+1,max);
					left--;
					right++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(max);
		
		for (int i = 0; i<N-1; i++) {
			left = i;
			right = i+1;
			while (left>=0 && right<=N-1) {
				if (arr[left] == arr[right]) {
					max = Math.max(right-left+1,max);
					left--;
					right++;
				} else {
					break;
				}
			}
		}
		System.out.println(max);
		
		
		
		

//		
		


	}

}

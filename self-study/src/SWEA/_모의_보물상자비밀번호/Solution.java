package SWEA._모의_보물상자비밀번호;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>(16);
		
		hash.put('0', 0);
		hash.put('1', 1);
		hash.put('2', 2);
		hash.put('3', 3);
		hash.put('4', 4);
		hash.put('5', 5);
		hash.put('6', 6);
		hash.put('7', 7);
		hash.put('8', 8);
		hash.put('9', 9);
		hash.put('A', 10);
		hash.put('B', 11);
		hash.put('C', 12);
		hash.put('D', 13);
		hash.put('E', 14);
		hash.put('F', 15);
		
		int T = sc.nextInt();
//		int[] test = {15,15,15,15,15,15,15};
//		System.out.println(getValue(test));
//		System.out.println(Integer.MAX_VALUE);
		
		for (int tc =1 ; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			int K = sc.nextInt();
			
			sc.nextLine();
			
			char[] str = sc.nextLine().toCharArray();
			
			int len = N/4; // 회전 수와 같음
			List<Integer> list = new ArrayList<>();
			for (int i = 0 ; i>-len; i--) {
				
				// 어후 헷갈려
				
				int start = (i+N) %N;
				
				for (int k = start; k < start + len*4; k+=len) {
					
					int[] full = new int[len];
					for (int j = k, l = 0; j < k+len; j++,l++) {
						int idx = j%N;
						full[l] = hash.get(str[idx]);
					}
					list.add(getValue(full));
				}
			}
			
		
			
			Collections.sort(list, (o1, o2) -> {
				return o2-o1;
			});
			int now = list.get(0);
			int cnt = 1;
			for (int i = 0; i<list.size(); i++) {
				if (list.get(i)==now) {
					continue;
				}
				//뭐냐 반례..!
				cnt++;
				now = list.get(i);
				if (cnt == K) {
					System.out.printf("#%d %d%n", tc, list.get(i));
					break;
				}
				
			}
			System.out.println(list);
		}
	}
	
	public static int getValue (int[] full) {
		int answer = 0;
		for (int i = 0; i < full.length; i++) {
			answer += full[full.length-1-i] * (int) Math.pow(16, i);
		}
		return answer;
	}

}

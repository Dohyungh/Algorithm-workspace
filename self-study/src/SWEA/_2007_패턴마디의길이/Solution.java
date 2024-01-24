package SWEA._2007_패턴마디의길이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			
			int ans = 1;
			Out:
			while (true) {
				String temp_str = "";
				for (int i = 0; i<ans;i++) {
//					temp_str += (String)arr[i]; 에러나네
//					temp_str += arr[i].toString(); 에러나네
//					temp_str += Char.toString() 없네
					temp_str += Character.toString(arr[i]);
					String target_str ="";
					for (int j = 0; j<ans;j++) {
						
					}
				}
				
				
				char[] temp_arr = temp_str; 
			}
		}
	}

}

package PRGS._2020Kakao_외벽점검;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1,5,6,10};
		int[] dist = {1,2,3,4};
		
		System.out.println(solution(n,weak,dist));
		
		int[] weak2 = {1,3,4,9,10};
		int[] dist2 = {3,5,7};
		System.out.println(solution(n,weak2,dist2));
		
	}
    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        
        // 거리 매트릭스 // 시계방향 거리와 시계반대방향 거리를 모두 구하자
        //시계,반시계 // 시계,반시계 // ...
        int numWeaks = weak.length;
        
        int[][] distance_matrix = new int[numWeaks][2*numWeaks];
        for (int i = 0; i < numWeaks; i++) {
        	for (int j = 0; j < i; j++) {
        		
        	}
        	
        	for (int j = i+1; j < numWeaks; j++) {
        		
        	}
        }
        
        if (weak[0] == 0) {
        	
        }
//        for (int i = 0; i < weak.length; i++) {
//        	System.out.println(Arrays.toString(distance_matrix[i]));
//        	
//        }
        
        
        // 도달 가능 매트릭스
        
        
        
        // 탐색
        
        return answer;
    }
}
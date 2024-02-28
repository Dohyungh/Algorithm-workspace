package SWEA._1860_진기의최고급붕어빵;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_윤홍 {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            
            int[] customer = new int[N];
            
            for(int i = 0; i < N; i++) {
                customer[i] = sc.nextInt();
            }
            int bread = 0; // 빵 갯수
            int cnt = 0; // 사람 수
            boolean success = false;
            
            Arrays.sort(customer);
            System.out.println(Arrays.toString(customer));
            
            for(int i = 0; true; i++) {
            	System.out.println("시간: "+i);
                if(i % M == 0 && i != 0) {
                    bread += K;
                    System.out.println("빵이 나왔습니다: " + bread);
                }
                for(int j = 0; j < N; j++) {
                    if(i == customer[j]) {
                    	System.out.println("손님이 왔습니다: " + i);
                        bread -= 1;
                        System.out.println("남은 빵개수: "+ bread);
                        cnt ++;
                    }
                }
                
                if(bread < 0) {
                	break;
                }
                if(cnt == N) {
                    success = true;
                    break;
                }
            }

            if(success) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }
            
        }
        
        
        
    }

}


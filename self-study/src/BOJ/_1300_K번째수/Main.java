package BOJ._1300_K번째수;

import java.util.Scanner;

public class Main {

    static long N;
    static long K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long left = 1;
        long right = N*N;
        long mid = (left + right) / 2;

        while(left < right) {

            long loc = getLoc(mid);

            if (loc < K) {
                left = mid + 1;
            } else {
                right = mid;
            }

            mid = (left + right) / 2;

        }

        System.out.println(right);
    }

    // alpha는 몇 번째 수인가?에 대한 답
    static long getLoc(long alpha) {
        long answer = 0;
        long limit = Math.min(alpha, N);

        for (long i = 1; i <= limit; i++) {
            answer += Math.min(alpha/i,N);
        }

        return answer;
    }
}

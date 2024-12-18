package BOJ._11401_이항계수3;

import java.util.Scanner;

public class Main {
    static int x = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // N! / (K! * (N-K)!)
        // 페르마 소정리에 의해
        // N! * (K! * (N-K)!)^10-05 를 10-07로 나눈 나머지를 구하면 된다.

        if (N >= x || K >= x) {
            System.out.println(0);
            return;
        }

        long N_factorial = getFactorial(N);

        long K_factorial = getFactorial(K);
        long N_K_factorial = getFactorial(N-K);

        long power = getPower(K_factorial * N_K_factorial % x, x-2);

        System.out.println(N_factorial * power % x);



    }

    public static long getFactorial(int num) {
        long factorial = 1L;
        while(num > 1) {
            factorial *= num;
            factorial %= x;
            num--;
        }
        return factorial;
    }

    public static long getPower(long num, int pow) {
//        System.out.println(pow);
        if (pow == 0) return 1L;
        long temp = getPower(num, pow/2) % x;
        if (pow % 2 == 1) {
            return temp * temp % x * num % x;
        } else {
            return temp * temp % x;
        }

    }
}
package BOJ._2631_줄세우기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr= new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] minMax = new int[200+1];

        Arrays.fill(minMax, Integer.MAX_VALUE);
        minMax[0] = 0;

        int pointer = 0;

        for (int i = 0; i < N; i++) {
            int curr = arr[i];

//            for (int j = pointer; j>=0; j--) {
//                if (minMax[j] < curr) {
//                    if(minMax[j+1] == Integer.MAX_VALUE) pointer++;
//                    minMax[j+1] = Math.min(minMax[j+1], curr);
//                    break;
//                }
//            }

            if (minMax[pointer] < curr) {
                pointer++;
                minMax[pointer] = curr;
                continue;
            }
            minMax[binarySearch(curr, minMax, pointer)] = curr;
        }
        System.out.println(N-pointer);

    }

    static int binarySearch(int curr, int[] minMax, int pointer) {
        int left = 0;
        int right = pointer;
        int mid = -1;
        int[] arr = minMax;

        while(left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < curr) {
                left = mid+1;
                continue;
            }
            right = mid;

        }
//        System.out.println(left);
        return left;
    }
}

package BOJ._12869_뮤탈리스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 공격 순서에 따른 종류 6가지 고정
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static int[][][] dp = new int[61][61][61];		// 최대 체력 60
    static int answer;		// 최소 공격횟수(답)
    static int[] scv;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // scv 개수, 입력을 받기 위함, 사실 별상관없음
        int N = Integer.parseInt(br.readLine());
        // scv가 3개 미만일 경우에는 초기 체력 0으로 설정할 것이기 때문에, 배열 크기는 3으로 고정
        scv = new int[3];

        // 초기 체력 입력
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(input[i]);
        }

        // 답안 초기화, 최댓값
        answer = Integer.MAX_VALUE;

        // 초기 체력 및 현재 공격횟수 0 인수로 전달
        int[] result = new int[17];
        comb(result, 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void comb(int[] result, int depth, int start) {

        if (depth >= answer) {
            answer = Math.min(answer, cnt(result));
            return;
        }

        if (depth == 17) {
            answer = Math.min(answer, cnt(result));
            return;
        }

        for (int i = start; i < 6; i++) {
            result[depth] = i;
            comb(result, depth+1, i);
        }
    }

    static int cnt(int[] result){
        int[] arr = new int[3];
        if (arr[0] >= scv[0] && arr[1] >= scv[1] && arr[2] >= scv[2]) {
            return 0;
        }
        for (int i = 0; i < 16; i++) {
            int idx = result[i];
            arr[0] += attack[idx][0];
            arr[1] += attack[idx][1];
            arr[2] += attack[idx][2];

            if (arr[0] >= scv[0] && arr[1] >= scv[1] && arr[2] >= scv[2]) {
                return i+1;
            }

        }
        return Integer.MAX_VALUE;

    }


}

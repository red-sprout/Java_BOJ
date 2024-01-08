// 투 포인터 기본문제
package TwoPointer;

import java.io.*;
import java.util.*;

public class BOJ2003 {
    // 입력부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, A));

        br.close();
    }

    // 알고리즘
    private static Long solution(int totalNum, int target, int[] array) {
        Long ans = 0L;
        int left = 0, right = 0;
        int sum = 0;

        while(true) {
            if(sum >= target) {
                sum -= array[left++];
            } else if(right == totalNum) {
                break;
            } else if (sum < target) {
                sum += array[right++];
            }

            if(sum == target) {
                ans++;
            }
        }
        return ans;
    }
}

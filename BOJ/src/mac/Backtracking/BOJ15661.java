package mac.Backtracking;
import java.io.*;
import java.util.*;

public class BOJ15661 {
    static int ans = 1000001;
    static boolean[] visited = new boolean[20];

    static void dfs(int[][] S, int[] arr1, int[] arr2, int cnt, int N, int std) {
        if (std == cnt) {
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    arr1[idx1] = i;
                    idx1++;
                } else {
                    arr2[idx2] = i;
                    idx2++;
                }
            }
            int tmp = Math.abs(sum(S, arr1, N, idx1) - sum(S, arr2, N, idx2));
            if (ans > tmp) ans = tmp;
            return;
        }
        else {
            for (int i = cnt; i < N; i++) {
                boolean flag = true;
                for (int j = N-1; j >= 0; j--) {
                    if (visited[j] && j > i) {
                        flag = false;
                        break;
                    }
                }
                if(!visited[i] && flag) {
                    visited[i] = true;
                    dfs(S, arr1, arr2, cnt + 1, N, std);
                    visited[i] = false;
                }
            }
        }
    }
    static int sum(int[][] S, int[] arr, int N, int idx) {
        int tmp = 0;
        for (int i = 0; i < idx; i++) {
            for (int j = 0 ; j < idx; j++) {
                tmp += S[arr[i]][arr[j]] + S[arr[j]][arr[i]];
            }
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N/2; i++) {
            dfs(S, arr1, arr2, 0, N, i);
            for (int j = 0; j < N; j++) visited[j] = false;
        }
        System.out.println(ans/2);
        br.close();
    }
}

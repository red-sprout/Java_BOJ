package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ15666 {
    static int N, M;
    static int MAX = 10001;
    static int[] ans;
    static boolean[] cand = new boolean[MAX];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            cand[idx] = true;
        }

        dfs(0, 0);

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(String.valueOf(ans[i]) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < MAX; i++) {
            if(cand[i] == true) {
                ans[depth] = i;
                dfs(i, depth + 1);
            }
        }
    }
}

package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ14888 {
    static int N;
    static int result;
    static int MAX = -1000000001;
    static int MIN = 1000000001;
    static int[] A;
    static int[] order = new int[4];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        result = A[0];
        dfs(0);
        System.out.println(MAX);
        System.out.println(MIN);
        br.close();
    }

    private static void dfs(int n) {
        if(n == N-1) {
            MAX = result > MAX ? result : MAX;
            MIN = result < MIN ? result : MIN;
            return;
        } else {
            for(int i = 0; i < 4; i++) {
                int tmp = result;
                if(order[i] == 0) continue;
                if(i == 0) {
                    result = result + A[n + 1];
                    order[i]--;
                    dfs(n+1);
                    order[i]++;
                    result = tmp;
                } else if(i == 1) {
                    result = result - A[n + 1];
                    order[i]--;
                    dfs(n+1);
                    order[i]++;
                    result = tmp;
                } else if(i == 2) {
                    result = result * A[n + 1];
                    order[i]--;
                    dfs(n+1);
                    order[i]++;
                    result = tmp;
                } else {
                    result = result / A[n + 1];
                    order[i]--;
                    dfs(n+1);
                    order[i]++;
                    result = tmp;
                }
            }
        }
    }
}

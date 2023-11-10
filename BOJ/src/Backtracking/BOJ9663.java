// N-queen
package Backtracking;

import java.io.*;

public class BOJ9663 {
    static int result;
    static int n;
    static boolean[][] queen = new boolean[n][n];

    static void dfs(int cnt) {
        if (cnt == n) {
            result++;
            return;
        } else {
            for(int i = cnt; i < n; i++) {
                
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < i; k++) {
                        if (queen[k][j]) continue;
                        if (j == 0 && k != 0);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        n = N;
        dfs(0);
        System.out.println(result);
    }
}

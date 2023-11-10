// N-queen
package Backtracking;

import java.io.*;

public class BOJ9663 {
    static int result;
    static int n;
    static int[] queen = new int[n];

    static void dfs(int cnt) {
        if (cnt == n) {
            result++;
            return;
        } else {
            boolean[] tmp = new boolean[n];
            for(int i = 0; i < n; i++) tmp[i] = true;

            for(int i = cnt; i < n; i++){
                for(int j = 0; j < i; j++) tmp[queen[j]] = false;
                for(int j = 0; j < i; j++) {
                    if (queen[j] - i + j >= 0) tmp[queen[j] - i + j] = false;
                    else if (queen[j] + i - j < n) tmp[queen[j] + i - j] = false;
                }
                for(int j = 0; j < n; j++) {
                    if (tmp[j]) {
                        queen[i] = j;
                        dfs(i+1);
                        queen[i] = -1;
                    }
                }
            }

            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(result);
    }
}

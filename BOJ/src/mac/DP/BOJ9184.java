package mac.DP;

import java.util.*;
import java.io.*;

public class BOJ9184 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = 20;

        int[][][] w = new int[MAX+1][MAX+1][MAX+1];
        for(int i = 0; i <= MAX; i++) {
            for(int j = 0; j <= MAX; j++) {
                for(int k = 0; k <= MAX; k++) {
                    if(i == 0 || j == 0 || k == 0) {
                        w[i][j][k] = 1;
                        continue;
                    }
        
                    if(i < j && j < k) {
                        w[i][j][k] = w[i][j][k-1] + w[i][j-1][k-1] - w[i][j-1][k];
                    } else {
                        w[i][j][k] = w[i-1][j][k] + w[i-1][j-1][k] + w[i-1][j][k-1] - w[i-1][j-1][k-1];
                    }
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int ans;
            if (a <= 0 || b <= 0 || c <= 0) {
                ans = 1;
            } else if (a > MAX || b > MAX || c > MAX) {
                ans = w[MAX][MAX][MAX];
            } else {
                ans = w[a][b][c];
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, ans);
        }

        br.close();
    }
}

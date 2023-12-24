package mac.Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ11660 {
    static int N, M;
    static int[][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N+1][N+1];

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= N; j++) {
                if(j == 0) {
                    table[i][j] = sum;
                    continue;
                }
                sum += Integer.parseInt(st.nextToken());
                table[i][j] = sum;
            }
        }

        int[] pos = new int[4];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                pos[j] = Integer.parseInt(st.nextToken());
            }

            int ans = compute(pos);
            sb.append(String.valueOf(ans));
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static int compute(int[] pos) {
        int ans = 0;
        int minX = Math.min(pos[0], pos[2]);
        int maxX = Math.max(pos[0], pos[2]);
        int minY = Math.min(pos[1], pos[3]);
        int maxY = Math.max(pos[1], pos[3]);

        for(int i = minX; i <= maxX; i++) {
            ans += table[i][maxY] - table[i][minY - 1];
        }

        return ans;
    }
}
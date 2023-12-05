package mac.DP;

import java.util.*;
import java.io.*;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        int[] DP = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++){
            DP[i] = 1;
            for(int j = 0; j < i; j++){
                if(lines[i][1] > lines[j][1]){
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            MAX = Math.max(MAX, DP[i]);
        }

        System.out.println(N - MAX);
    }
}

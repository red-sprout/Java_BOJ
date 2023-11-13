package mac.Backtracking;
import java.io.*;
import java.util.*;

public class BOJ14889 {
    static int result = 100000;
    static int[] cases = new int[10];
    static int sum_1 = 0;
    static int sum_2 = 0;

    static void dfs(int member, int idx) {
        if (member/2 == idx) {
            // dfs_cases(0);
            return;
        } else {
            for (int i = idx; i <= member; i++) {
                boolean flag = true;
                for (int j = 0; j < member/2; j++) {
                    if (idx == cases[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cases[i] = idx;
                    dfs(member, i + 1);
                    cases[i] = 0;
                }
            }
        }
    }

    static void dfs_cases(int member, int cnt) {
        for (int i = 1; i <= member; i++) {
            for (int j = 1; j <= member/2; j++) {

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}

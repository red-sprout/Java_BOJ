// DP
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ9461 {
    static int MAX = 101;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] P = new long[MAX];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        for (int i = 6; i < MAX; i++) P[i] = P[i-1] + P[i-5];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(P[N]);
        }
    }
}

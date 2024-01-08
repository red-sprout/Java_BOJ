package Backtracking;
import java.io.*;

public class BOJ1248 {
    static int[] cand = new int[10];
    static boolean flag1 = false;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n, int cnt, char[] signSeq, char[] seq) {
        if (n == cnt) {
            flag1 = true;
            return;
        } else if (flag1) return;
        else {
            if (signSeq[cnt] == '+') {
                for (int i = 1; i <= 10; i++) {
                    cand[cnt] = i;
                    dfs(n, cnt+1, signSeq, seq);
                }
            } else if (signSeq[cnt] == '-') {
                for (int i = -1; i <= -10; i--) {
                    cand[cnt] = i;
                    dfs(n, cnt+1, signSeq, seq);
                }
            } else {
                cand[cnt] = 0;
                dfs(n, cnt+1, signSeq, seq);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] seq = br.readLine().toCharArray();
        char[] signSeq = new char[n];

        int idx = n + 1, s = 0;
        for(int i = 0; i < seq.length; i = i + idx) {
            signSeq[s] = seq[i];
            s++;
            idx--;
        }

        dfs(n, 0, signSeq, seq);
        for (int i = 0 ; i < n; i++) System.out.println(signSeq[i]);
    }
}

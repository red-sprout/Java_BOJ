package mac.BinarySearch;

import java.util.*;
import java.io.*;

public class BOJ1654 {
    static int K, N;
    static int[] TREE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        TREE = new int[K];

        for(int i = 0; i < K; i++) {
            TREE[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while(start <= end) {
            long mid = (start + end) / 2;
            if(check(mid)) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);

        br.close();
    }
    private static boolean check(long cuttingSize) {
        long cnt = 0;
        for(int i = 0; i < K; i++) {
            cnt += TREE[i] / cuttingSize;
        }
        
        if(cnt >= N) return true;
        else return false;
    }
}

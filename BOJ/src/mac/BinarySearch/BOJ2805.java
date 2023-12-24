package mac.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ2805 {
    static int N, M;
    static int[] height;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            max = Math.max(max, h);
            height[i] = h;
        }

        int start = 0;
        int end = max;
        while(start + 1< end) {
            int mid = (start + end) / 2;

            if(isValid(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
        br.close();
    }

    private static boolean isValid(int cuttingHeight) {
        long sum = 0;

        for(int i = 0; i < N; i++) {
            int h = height[i];
            if(h <= cuttingHeight) continue;
            sum += h - cuttingHeight;
        }

        return (sum >= M);
    }
}
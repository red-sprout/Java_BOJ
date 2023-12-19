package mac.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    static int N, M;
    static int[] CARD;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        CARD = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            CARD[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(CARD);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int ans = upperBound(target) - lowerBound(target);
            sb.append(String.valueOf(ans));
            sb.append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    private static int lowerBound(int target) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start + end) / 2;
            if(target <= CARD[mid]) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private static int upperBound(int target) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start + end) / 2;
            if(target < CARD[mid]) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
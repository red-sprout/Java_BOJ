package BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ2110 {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];

        for(int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int start = 0;
        int end = home[N - 1] - home[0] + 1;

        int ans = upperBound(start, end);
        System.out.println(ans);

        br.close();
    }

    private static int upperBound(int start, int end) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(canInstall(mid) < C) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    private static int canInstall(int distance) {
        int cnt = 1;
        int pastLocation = home[0];
        for(int i = 1; i < N; i++) {
            int nowLocation = home[i];
            if(distance > nowLocation - pastLocation) continue;
            cnt++;
            pastLocation = nowLocation;
        }
        return cnt;
    }
}

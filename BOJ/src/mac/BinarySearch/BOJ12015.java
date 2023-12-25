package mac.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ12015 {
    static int N;
    static int[] A;
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = A[0];
        int length = 1;
        for(int i = 1; i < N; i++) {
            int ele = A[i];
            if(LIS[length - 1] < ele) {
                length++;
                LIS[length - 1] = ele;
            } else {
                int idx = BinarySearch(ele, length);
                LIS[idx] = ele;
            }
        }

        System.out.println(length);
        br.close();
    }

    private static int BinarySearch(int target, int length) {
        int start = 0;
        int end = length;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(LIS[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
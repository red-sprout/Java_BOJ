package BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ1920 {
    static int N, M;
    static int[] A;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(target, 0, N - 1));
        }

        br.close();
    }

    // 재귀
    // private static int binarySearch(int target, int start, int end) {
    //     if(start > end) return 0;
    //     int mid = (start + end) / 2;
    //     if(A[mid] == target) return 1;
    //     else if(A[mid] < target) return binarySearch(target, mid + 1, end);
    //     else return binarySearch(target, start, mid - 1);
    // }

    // 반복문
    private static int binarySearch(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) return 1;
            else if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}

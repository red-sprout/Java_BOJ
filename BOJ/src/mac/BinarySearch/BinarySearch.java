package mac.BinarySearch;

import java.io.*;
import java.util.*;
/*
    길이 N인 배열에서 K 인덱스 찾기
    10 7
    1 3 7 7 7 7 7 13 19 21
 */

public class BinarySearch {
    static int N, K;
    static int[] array;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N];

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int ans1 = normalBinarySearch();
        int ans2 = upperBound();
        int ans3 = lowerBound();

        System.out.println("Binary Search: " + ans1);
        System.out.println("Upper Bound: " + ans2);
        System.out.println("Lower Bound: " + ans3);

        br.close();
    }

    private static int normalBinarySearch() {
        int start = -1;
        int end = N;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > K) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }// 예시의 경우 index = 6, array[index] = 7

    private static int upperBound() {
        int start = -1;
        int end = N;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > K) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }// 예시의 경우 index = 7, array[index] = 13

    private static int lowerBound() {
        int start = -1;
        int end = N;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] >= K) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }// 예시의 경우 index = 2, array[index] = 7
}

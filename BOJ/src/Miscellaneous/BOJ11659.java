package Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            sum += Integer.parseInt(st.nextToken());
            num[i] = sum;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(num[end]-num[start-1]);
        }
    }
}
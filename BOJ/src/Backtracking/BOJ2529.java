package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ2529 {
    static boolean[] visited = new boolean[10];
    static int[] arr = new int[10];
    static int[] small = {9,9,9,9,9,9,9,9,9,9};
    static int[] big = {0,0,0,0,0,0,0,0,0,0};

    static void dfs(int k, int cnt, String[] order, int start, int end) {
        if (k == cnt) {
            compare(k);
            return;
        } else {
            for (int i = start; i <= end; i++) {
                if (!visited[i]) {
                    arr[cnt] = i;
                    visited[i] = true;
                    if (cnt < k-1) {
                        if (order[cnt].equals("<")) dfs(k, cnt+1, order, i, 9);
                        else dfs(k, cnt+1, order, 0, i);
                    } else dfs(k, cnt+1, order, start, end);
                    arr[cnt] = 0;
                    visited[i] = false;
                }
            }
        }
    }

    static void compare(int k) {
        boolean mode1 = false;
        boolean mode2 = false;
        for (int i = 0; i < k; i++) {
            if (!mode1 && small[i] > arr[i]) mode1 = true;
            if (!mode1 && small[i] < arr[i]) break;
            if (mode1) small[i] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            if (!mode2 && big[i] < arr[i]) mode2 = true;
            if (!mode2 && big[i] > arr[i]) break;
            if (mode2) big[i] = arr[i];
        }
    }

    static void printArray(int[] ar, int k) {
        for (int i = 0; i < k; i++) System.out.print(ar[i]);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine()), idx = 0;
        String[] order = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) order[idx++] = st.nextToken();
        
        dfs(k+1, 0, order, 0, 9);
        printArray(big, k+1);
        printArray(small, k+1);
    }
}

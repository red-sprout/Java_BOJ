package Backtracking;

import java.io.*;
import java.util.*;

public class BOJ6603 {
    static int[] result = new int[6];

    static void dfs(int[] arr, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < cnt; i++) System.out.print(result[i] + " ");
            System.out.println();
            return;
        } else {
            for (int i = cnt; i < arr.length; i++) {
                boolean flag = false;
                for (int j = 0; j < 6; j++) {
                    if (result[j] >= arr[i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    result[cnt] = arr[i];
                    dfs(arr, cnt+1);
                    result[cnt] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if (str.equals("0")) break;

            StringTokenizer st = new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];

            for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());
            dfs(arr, 0);
            System.out.println();
        }
        
        br.close();
    }
}

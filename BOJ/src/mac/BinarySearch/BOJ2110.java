package mac.BinarySearch;

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

        br.close();
    }
}

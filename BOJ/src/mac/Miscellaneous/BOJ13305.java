package mac.Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N];
        long[] oilPrice = new long[N];

        StringTokenizer distance = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            road[i] = Long.parseLong(distance.nextToken());
        }

        StringTokenizer station = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            oilPrice[i] = Long.parseLong(station.nextToken());
        }

        long total = 0;
        long nowPrice = oilPrice[0];
        for(int i = 1; i < N; i++) {
            total += nowPrice * road[i];
            if(nowPrice > oilPrice[i]) {
                nowPrice = oilPrice[i];
            }
        }

        System.out.println(total);

        br.close();
    }
}

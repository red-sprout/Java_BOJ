// 진행중
package mac.DP;

import java.io.*;
import java.util.*;

public class BOJ2629 {
    static int MAX = 40000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        boolean[] dp = new boolean[MAX + 1];

        int numberOfWeights = Integer.parseInt(br.readLine());

        int[] weights = new int[numberOfWeights];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < numberOfWeights; i++) {
            int weight = Integer.parseInt(st.nextToken());
            weights[i] = weight;
        }

        int numberOfBalls = Integer.parseInt(br.readLine());

        int[] balls = new int[numberOfBalls];

        for(int i = 1; i <= numberOfBalls; i++) {
            for(int j = 1; j <= MAX; j++) {

            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < numberOfBalls; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
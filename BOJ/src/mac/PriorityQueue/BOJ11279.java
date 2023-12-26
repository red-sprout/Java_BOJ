package mac.PriorityQueue;

import java.io.*;
import java.util.*;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else if (pq.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(pq.poll());
            }
        }

        br.close();
    }
}

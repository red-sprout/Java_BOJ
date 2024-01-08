package PriorityQueue;

import java.io.*;
import java.util.*;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(i == 0) {
                maxPQ.add(x);
            } else if(maxPQ.size() == minPQ.size()) {
                maxPQ.add(x);
                if(maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            } else {
                minPQ.add(x);
                if(maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }

            sb.append(String.valueOf(maxPQ.peek()) + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}

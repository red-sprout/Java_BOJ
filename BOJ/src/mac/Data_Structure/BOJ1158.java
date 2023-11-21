// SILVER 4
// 요세푸스 문제
package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int order = 1;

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        while(!queue.isEmpty()) {
            if (order == K) {
                order = 1;
                sb.append(String.valueOf(queue.poll()));
                if (!queue.isEmpty()) sb.append(", ");
            } else {
                queue.add(queue.poll());
                order++;
            }
        }

        sb.append(">");
        System.out.println(sb);

        br.close();
    }
}
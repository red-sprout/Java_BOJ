// SILVER 2
// 스택 수열
package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int now = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > now) {
                for (int j = now + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                now = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}

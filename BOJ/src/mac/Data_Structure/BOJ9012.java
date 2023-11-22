// SILVER 4
// 괄호
package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            char[] VPS = br.readLine().toCharArray();
            boolean flag = false;
            for (char c : VPS) {
                if (c == '(') {
                    stack.add(c);
                } else if (stack.isEmpty()) {
                    flag = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (flag || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}

// BRONZE 1
// 단어 뒤집기
package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char[] str = st.nextToken().toCharArray();
                Stack<Character> stack = new Stack<>();
                for (char s : str) {
                    stack.add(s);
                }
                for (int j = 0; j < str.length; j++) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}

// SILVER 3
// 단어 뒤집기 2
package mac.Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ17413 {
    static Stack<Character> stack;
    static StringBuilder sb;
    static boolean flag = false;

    static void emptyCheck(){
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int idx = 0;

        sb = new StringBuilder();
        stack = new Stack<>();

        while(idx < string.length) {
            char c = string[idx];
            idx++;
            if (c =='<') {
                emptyCheck();
                flag = true;
                sb.append("<");
                continue;
            } else if (c == '>') {
                flag = false;
                sb.append(">");
                continue;
            }

            if (flag) {
                sb.append(c);
            } else if (c == ' ') {
                emptyCheck();
                sb.append(' ');
            } else {
                stack.push(c);
            } 
        }

        emptyCheck();
        System.out.println(sb);
    }
}

package Data_Structure;

import java.util.*;
import java.io.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        char[] str = br.readLine().toCharArray();
        int M = Integer.parseInt(br.readLine());
        for (char c : str) {
            s1.push(c);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")) {
                if (!s1.isEmpty()) s2.push(s1.pop());
            } else if (command.equals("D")) {
                if (!s2.isEmpty()) s1.push(s2.pop());
            } else if (command.equals("B")) {
                if (!s1.isEmpty()) s1.pop();
            } else {
                char add = st.nextToken().charAt(0);
                s1.push(add);
            }
        }

        while (!s1.empty()) {
            s2.push(s1.pop());
        }

        while (!s2.empty()) {
            sb.append(s2.pop());
        }

        System.out.println(sb);
    }
}

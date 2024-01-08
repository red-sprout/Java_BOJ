// SILVER 4
// 스택
package Data_Structure;

import java.io.*;
import java.util.*;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } 
            
            else if (command.equals("pop")) {
                if (!stack.isEmpty()) bw.write(String.valueOf(stack.pop()) + "\n");
                else bw.write(String.valueOf(-1) + "\n");
            } 
            
            else if (command.equals("size")) {
                bw.write(String.valueOf(stack.size()) + "\n");
            } 
            
            else if (command.equals("empty")) {
                int x = stack.isEmpty() ? 1 : 0;
                bw.write(String.valueOf(x) + "\n");
            } 
            
            else {
                if (!stack.isEmpty()) bw.write(String.valueOf(stack.peek()) + "\n");
                else bw.write(String.valueOf(-1) + "\n");
            }
            bw.flush();
        }

        bw.close();
        br.close();
    }
}

package stack;

import java.util.*;

public class BOJ9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        String str = sc.nextLine();
        String bomb = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if(bomb.length() > stack.size()) continue;
            boolean flag = true;
            for(int j = 0; j < bomb.length(); j++) {
                if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                for(int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

		for(Character c : stack) {
			sb.append(c);
		}

		System.out.println(sb.length()==0? "FRULA" : sb.toString());
        sc.close();
    }
}
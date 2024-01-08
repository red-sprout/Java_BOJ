package Miscellaneous;

import java.util.*;

public class BOJ11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println((int)Math.pow((double)2, (double)N) - 1);
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
        sc.close();
    }
    private static void hanoi(int n, int fromPole, int withPole, int toPole) {
        if (n == 1) {
            addToString(fromPole, toPole);
        } else {
            hanoi(n-1, fromPole, toPole, withPole);
            addToString(fromPole, toPole);
            hanoi(n-1, withPole, fromPole, toPole);
        }
    }
    private static void addToString(int fromPole, int toPole) {
        sb.append(String.valueOf(fromPole));
        sb.append(" ");
        sb.append(String.valueOf(toPole));
        sb.append("\n");
    }
}

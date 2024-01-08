package DnC;

import java.util.*;

public class BOJ1629 {
    static long A, B, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(B));

        sc.close();
    }
    private static long pow(long exponent) {
        if (exponent == 1) {
            return A % C;
        } else {
            long tmp = pow(exponent/2);
            if(exponent % 2 == 1) return (tmp * tmp % C) * A % C;
            return tmp * tmp % C;
        }
    }
}

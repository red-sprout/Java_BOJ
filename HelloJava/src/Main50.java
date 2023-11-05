// BOJ 10757
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main50 {
    static int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = new int[MAX];
        int flag = 0;
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();
        int min = 0;
        int max = 0;

        if(A.length > B.length) {
            min = B.length;
            max = A.length;
        } else {
            min = A.length;
            max = B.length;
        }

        for(int i = 1; i <= max; i++) {
            if(i <= min) {
                int a = A[A.length - i] - '0';
                int b = B[B.length - i] - '0';
                int tmp = a+b+flag;
                if(tmp >= 10) {
                    ans[MAX-i] = tmp - 10;
                    flag = 1;
                } else {
                    ans[MAX-i] = tmp;
                    flag = 0;
                }
            } else if(min == max) break;
            else if(min == A.length){
                int b = B[B.length - i] - '0';
                int tmp = b+flag;
                if(tmp >= 10) {
                    ans[MAX-i] = tmp - 10;
                    flag = 1;
                } else {
                    ans[MAX-i] = tmp;
                    flag = 0;
                }
            } else {
                int a = A[A.length - i] - '0';
                int tmp = a+flag;
                if(tmp >= 10) {
                    ans[MAX-i] = tmp - 10;
                    flag = 1;
                } else {
                    ans[MAX-i] = tmp;
                    flag = 0;
                }
            }
        }

        if(flag == 1) ans[MAX-max-1] = 1;
        int start = flag == 1 ? MAX - max - 1 : MAX - max;
        for(int i = start; i < MAX; i++) {
            System.out.print(ans[i]);
        }
        System.out.println();
    }
}

package Greedy;
// Greedy
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        boolean[] arr = new boolean[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = (arr1[i] == arr2[i]);
        }

        for (int T = 0; T < 2; T++) {
            for (int i = 0; i < n-1; i++) {
                if (i == 0 || i == n-2) {
                    if (!arr[i] || !arr[i+1]) {
                        arr[i] = !arr[i];
                        arr[i+1] = !arr[i+1];
                    }
                } else {
                    if (!arr[i] || !arr[i+1] || !arr[i+2]) {
                        arr[i] = !arr[i];
                        arr[i+1] = !arr[i+1];
                        arr[i+2] = !arr[i+2];
                    }
                }
            }
        }
        
        for (int i = 0; i < n ; i++) {
            if (!arr[i]) {
                System.out.println(-1);
                break;
            } else if (i == n-1) {
                System.out.println(cnt);
            }
        }
    }
}
// 1101000 0011000(idx 1) 0011111(idx 5) 1111111(idx 0)
// 1101000 1101111
// 1101000 0001000 1111000 1111111
// 101 011 100 111
// 000 111
// 001 111
// 010 100 111
// 011 100 111
// 100 111
// 101 011 100 111
// 110 000 111
// 111

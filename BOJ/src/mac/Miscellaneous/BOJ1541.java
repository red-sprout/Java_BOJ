package mac.Miscellaneous;

import java.io.*;
import java.util.*;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subtration = new StringTokenizer(br.readLine(), "-");

        int sum = 0;
        boolean flag = true;

        while(subtration.hasMoreTokens()) {
            StringTokenizer addition = new StringTokenizer(subtration.nextToken(), "+");

            int tmp = 0;

            while(addition.hasMoreTokens()) {
                tmp += Integer.parseInt(addition.nextToken());
            }
            
            if(flag) {
                sum += tmp;
                flag = false;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
        br.close();
    }
}
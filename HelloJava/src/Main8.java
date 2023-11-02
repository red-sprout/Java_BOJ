// BOJ 2558
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main8 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int a = Integer.parseInt(str1);
        int b = Integer.parseInt(str2);

        System.out.println(a + b);
    }
}

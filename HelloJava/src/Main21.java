// BOJ 2935
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main21{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        String tool = br.readLine();
        char[] B = br.readLine().toCharArray();

        if(tool.equals("+")){
            if(A.length < B.length){
                B[B.length - A.length] += 1;
                B.toString();
                System.out.println(B);
            } else{
                A[A.length - B.length] += 1;
                A.toString();
                System.out.println(A);
            }
        } else {
            for(int i = 0; i < A.length + B.length - 1; i++){
                if(i < A.length){
                    System.out.print(A[i]);
                } else{
                    System.out.print('0');
                }
            }
            System.out.println();
        }
    }
}
import java.util.*;

public class BinarySearch {
    private static int[] array;
    private static int Search(int target, int start, int end){
        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] == target) return mid;
            else if(array[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    private static int SearchR(int target, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(array[mid] == target) return mid;
        else if(array[mid] > target) return SearchR(target, start, mid - 1);
        else return SearchR(target, mid + 1, end);
    }
    public static void main(String[] args) {
        // 입력 예시:
        // 10 7
        // 1 3 5 7 9 11 13 15 17 19
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        array = new int[N];

        Scanner arr = new Scanner(System.in);
        for(int i = 0; i < N; i++) {
            array[i] = arr.nextInt();
        }

        int result = Search(target, 0, N - 1);
        int resultR = SearchR(target, 0, N - 1);

        System.out.print("반복문으로 index 찾기: ");
        if(result == -1) {
            System.out.println("None");
        } else {
            System.out.println(result);
        }

        System.out.print("재귀함수로 index 찾기: ");
        if(resultR == -1) {
            System.out.println("None");
        } else {
            System.out.println(resultR);
        }

        sc.close();
        arr.close();
    }
}
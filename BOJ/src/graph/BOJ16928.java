package graph;

import java.io.*;
import java.util.*;

public class BOJ16928 {
    static int N, M;
    static Map<Integer, Integer> ladder, snake;
    static int[] game = new int[101];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder = new HashMap<>();
        snake = new HashMap<>();
        int start, end;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }

        bfs(1);

        System.out.println(game[100]);
        br.close();
    }

    private static void bfs(int startPoint) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startPoint);
        while(!q.isEmpty()) {
            int pastPoint = q.poll();
            for(int dice = 1; dice <= 6; dice++) {
                int nowPoint = pastPoint + dice;
                int pastCnt = game[pastPoint];

                if(nowPoint > 100) continue;
                if(game[nowPoint] != 0) continue;

                boolean isLadderElement = isElement(ladder, nowPoint);
                boolean isSnakeElement = isElement(snake, nowPoint);
                while(isLadderElement || isSnakeElement) {
                    nowPoint = isLadderElement ? ladder.get(nowPoint) : snake.get(nowPoint);

                    if(game[nowPoint] != 0) {
                        nowPoint = pastPoint;
                        break;
                    }
                    
                    game[nowPoint] = pastCnt + 1;
                    isLadderElement = isElement(ladder, nowPoint);
                    isSnakeElement = isElement(snake, nowPoint);
                }

                if(nowPoint == pastPoint) continue;
                
                q.add(nowPoint);
                game[nowPoint] = pastCnt + 1;
            }
        }
    }

    private static boolean isElement(Map<Integer, Integer> map, int cand) {
        for(int i : map.keySet()) {
            if(i == cand) return true;
        }
        return false;
    }
}
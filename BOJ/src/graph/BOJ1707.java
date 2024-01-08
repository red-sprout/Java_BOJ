package graph;
// 진행중
import java.util.*;
import java.io.*;

class Graph {
    class Node {
        int data;
        LinkedList<Node> connected;
        int color;
        public Node(int data) {
            this.data = data;
            this.color = 0;
            this.connected = new LinkedList<>();
        }
    }
    private Node[] nodes;
    Graph(int size) {
        nodes = new Node[size + 1];
        for(int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }
        nodes[1].color = 1;
    }

    public void addEdges(int u, int v) {
        Node n1 = nodes[u];
        Node n2 = nodes[v];
        if(!n1.connected.contains(n2)) {
            n1.connected.add(n2);
        }
        if(!n2.connected.contains(n1)) {
            n2.connected.add(n1);
        }
    }

    public void dfs(Node node) {
        if(node == null) return;
        int color = node.color * (-1);
        for(Node n : node.connected) {
            if(n.color == 0) {
                n.color = color;
                dfs(n);
            }
        }
    }

    public void dfs(int index) {
        Node n = nodes[index];
        dfs(n);
    }

    public boolean isBipartite(int index) {
        Node node = nodes[index];
        int color = node.color;
        for(Node n : node.connected) {
            if(n.color == color) return false;
        }
        return true;
    }
}

public class BOJ1707 {
    static int K, V, E;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= K; K++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            boolean flag = true;

            Graph graph = new Graph(V);
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.addEdges(u, v);
            }

            for(int v = 1; v <= V; v++) {
                graph.dfs(v);
            }

            for(int v = 1; v <= V; v++) {
                if(!graph.isBipartite(v)) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if(flag) {
                System.out.println("YES");
            }
        }

        br.close();
    }
}
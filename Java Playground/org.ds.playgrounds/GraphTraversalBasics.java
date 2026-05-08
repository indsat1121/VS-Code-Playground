import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class GraphTraversalBasics {

    // BFS (Breadth-First Search): explores level by level using a queue.
    // Time: O(V + E), Space: O(V)
    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return order;
    }

    // DFS recursive: goes deep first, then backtracks.
    // Time: O(V + E), Space: O(V) for visited + recursion stack.
    public static List<Integer> dfsRecursive(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        List<Integer> order = new ArrayList<>();
        dfs(graph, start, visited, order);
        return order;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, next, visited, order);
            }
        }
    }

    // DFS iterative using a stack.
    // Time: O(V + E), Space: O(V).
    public static List<Integer> dfsIterative(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            order.add(node);

            List<Integer> neighbors = graph.get(node);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int next = neighbors.get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
        return order;
    }

    private static List<List<Integer>> buildSampleGraph() {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 4, 5);
        return graph;
    }

    private static void addUndirectedEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = buildSampleGraph();
        System.out.println("BFS from 0: " + Arrays.toString(bfs(graph, 0).toArray()));
        System.out.println("DFS recursive from 0: " + Arrays.toString(dfsRecursive(graph, 0).toArray()));
        System.out.println("DFS iterative from 0: " + Arrays.toString(dfsIterative(graph, 0).toArray()));
    }
}

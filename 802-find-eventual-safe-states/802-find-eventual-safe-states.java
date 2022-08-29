class Solution{
    enum State {
    SAFE,
    UNSAFE
}

public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> safeNodes = new ArrayList<>(graph.length);
    State[] states = new State[graph.length];
    for (int node = 0; node < graph.length; node++) {
        if (isSafe(graph, node, states)) {
            safeNodes.add(node);
        }
    }
    return safeNodes;
}

private boolean isSafe(int[][] graph, int node, State[] states) {
    if (states[node] != null) {
        return states[node] == State.SAFE;
    }

    states[node] = State.UNSAFE;

    for (int next : graph[node]) {
        if (!isSafe(graph, next, states)) return false;
    }

    states[node] = State.SAFE;
    return true;
}
}
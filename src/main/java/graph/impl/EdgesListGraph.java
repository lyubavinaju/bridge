package graph.impl;

import drawing.DrawingApi;
import graph.Graph;
import graph.impl.domain.Edge;
import graph.impl.domain.EdgesList;
import graph.impl.domain.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EdgesListGraph extends Graph {
    private final EdgesList edgesList;

    public EdgesListGraph(DrawingApi drawingApi, EdgesList edgesList) {
        super(drawingApi);
        this.edgesList = edgesList;
    }

    @Override
    public void drawGraph() {
        Set<Node> nodes = new HashSet<>();
        for (Edge edge : edgesList.getEdges()) {
            nodes.add(edge.getStart());
            nodes.add(edge.getEnd());
        }
        int nodesCount = nodes.size();
        drawNodes(nodesCount);
        Map<Node, Integer> order = new HashMap<>();
        int i = 0;
        for (Node node : nodes) {
            order.put(node, i);
            i++;
        }
        for (Edge edge : edgesList.getEdges()) {
            int start = order.get(edge.getStart());
            int end = order.get(edge.getEnd());
            int x1 = calculateXForNode(start, nodesCount);
            int y1 = calculateYForNode(start, nodesCount);
            int x2 = calculateXForNode(end, nodesCount);
            int y2 = calculateYForNode(end, nodesCount);
            drawingApi.drawLine(x1, y1, x2, y2);
        }
        drawingApi.showResult();
    }
}

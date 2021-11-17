package graph.impl;

import drawing.DrawingApi;
import graph.Graph;
import graph.impl.domain.AdjacencyMatrix;

public class AdjacencyMatrixGraph extends Graph {

    private final AdjacencyMatrix matrix;

    public AdjacencyMatrixGraph(DrawingApi drawingApi, AdjacencyMatrix matrix) {
        super(drawingApi);
        this.matrix = matrix;
    }

    @Override
    public void drawGraph() {
        int nodesCount = matrix.size();
        drawNodes(nodesCount);
        for (int i = 0; i < nodesCount; i++) {
            for (int j = 0; j < nodesCount; j++) {
                if (matrix.getSource()[i][j] == 1) {
                    int x1 = calculateXForNode(i, nodesCount);
                    int y1 = calculateYForNode(i, nodesCount);
                    int x2 = calculateXForNode(j, nodesCount);
                    int y2 = calculateYForNode(j, nodesCount);
                    drawingApi.drawLine(x1, y1, x2, y2);
                }
            }
        }
        drawingApi.showResult();
    }
}

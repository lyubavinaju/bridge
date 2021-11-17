package graph;

import drawing.DrawingApi;

public abstract class Graph {
    protected static final int GRAPH_RADIUS = 100;
    protected static final int NODE_DIAMETER = 20;
    protected static final int X_START = 2 * GRAPH_RADIUS;
    protected static final int Y_START = 2 * GRAPH_RADIUS;
    private static final int WIDTH = 4 * GRAPH_RADIUS;
    private static final int HEIGHT = 4 * GRAPH_RADIUS;

    /**
     * Bridge to drawing api
     */
    protected DrawingApi drawingApi;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
        drawingApi.setDrawingAreaHeight(HEIGHT);
        drawingApi.setDrawingAreaWidth(WIDTH);
    }

    public abstract void drawGraph();

    protected int calculateXForNode(int i, int n) {
        return (int) Math.ceil(X_START + GRAPH_RADIUS * Math.sin((double) 2 * Math.PI * i / n));
    }

    protected int calculateYForNode(int i, int n) {
        return (int) Math.ceil(Y_START + GRAPH_RADIUS * Math.cos((double) 2 * Math.PI * i / n));
    }

    protected void drawNodes(int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            int x1 = calculateXForNode(i, vertexCount);
            int y1 = calculateYForNode(i, vertexCount);
            drawingApi.drawCircle(x1 - NODE_DIAMETER / 2, y1 - NODE_DIAMETER / 2, NODE_DIAMETER);
        }
    }
}
import drawing.DrawingApi;
import drawing.impl.AwtDrawing;
import drawing.impl.JavaFxDrawing;
import graph.Graph;
import graph.impl.AdjacencyMatrixGraph;
import graph.impl.EdgesListGraph;
import graph.impl.domain.AdjacencyMatrix;
import graph.impl.domain.Edge;
import graph.impl.domain.EdgesList;
import graph.impl.domain.Node;
import java.util.List;

public class Demo {
    private static final EdgesList EDGES_LIST = new EdgesList(List.of(
        new Edge(new Node("1"), new Node("2")),
        new Edge(new Node("3"), new Node("2")),
        new Edge(new Node("4"), new Node("2")),
        new Edge(new Node("3"), new Node("4"))
    ));
    private static final AdjacencyMatrix ADJACENCY_MATRIX = new AdjacencyMatrix(new int[][] {
        {0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0},
        {1, 1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0}
    });

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("2 arguments expected");
        }
        DrawingApi drawingApi;
        switch (args[0]) {
            case "awt":
                drawingApi = new AwtDrawing();
                break;
            case "javaFx":
                drawingApi = new JavaFxDrawing();
                break;
            default:
                throw new IllegalArgumentException(args[0]);
        }
        Graph graph;
        switch (args[1]) {
            case "matrix":
                graph = new AdjacencyMatrixGraph(drawingApi, ADJACENCY_MATRIX);
                break;
            case "list":
                graph = new EdgesListGraph(drawingApi, EDGES_LIST);
                break;
            default:
                throw new IllegalArgumentException(args[1]);
        }

        graph.drawGraph();
    }
}

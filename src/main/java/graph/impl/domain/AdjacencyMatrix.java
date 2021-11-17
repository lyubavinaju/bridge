package graph.impl.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdjacencyMatrix {
    private final int[][] source;

    public int size() {
        return source.length;
    }
}
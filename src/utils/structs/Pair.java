package utils.structs;

public record Pair<S, T>(S first, T second) {
    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

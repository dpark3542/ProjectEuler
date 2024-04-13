package utils.structs;

public record Pair<S, T>(S first, T second) {
    @Override
    public String toString() {
        return '(' + first.toString() + ", " + second.toString() + ')';
    }
}

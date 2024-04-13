package utils.structs;

public record Triple<S, T, U>(S first, T second, U third) {
    @Override
    public String toString() {
        return '(' + first.toString() + ", " + second.toString() + ", " + third.toString() + ')';
    }
}

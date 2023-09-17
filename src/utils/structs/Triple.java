package utils.structs;

public record Triple<S, T, U>(S first, T second, U third) {
    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public U getThird() {
        return third;
    }
}

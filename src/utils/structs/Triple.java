package utils.structs;

public class Triple<S, T, U> {
    public S first;
    public T second;
    public U third;

    public Triple(S s, T t, U u) {
        first = s;
        second = t;
        third = u;
    }
}

package utils;

public class DataStructures {
    public static class Pair<S, T> {
        public S first;
        public T second;

        public Pair(S s, T t) {
            first = s;
            second = t;
        }
    }

    public static class Triple<S, T, U> {
        public S first;
        public T second;
        public U third;

        public Triple(S s, T t, U u) {
            first = s;
            second = t;
            third = u;
        }
    }
}

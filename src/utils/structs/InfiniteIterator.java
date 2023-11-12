package utils.structs;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class InfiniteIterator<E> implements Iterator<E> {
    @Override
    public final boolean hasNext() {
        return true;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove element in infinite iterator");
    }

    @Override
    public final void forEachRemaining(Consumer<? super E> action) {
        throw new UnsupportedOperationException("Cannot act on infinite iterator");
    }
}

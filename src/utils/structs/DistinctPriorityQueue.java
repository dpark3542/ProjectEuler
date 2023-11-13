package utils.structs;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class DistinctPriorityQueue<E> extends AbstractQueue<E>  {
    private final Set<E> s;
    private final PriorityQueue<E> pq;

    public DistinctPriorityQueue(Comparator<? super E> comparator) {
        s = new HashSet<>();
        pq = new PriorityQueue<>(comparator);
    }

    @Override
    public boolean add(E e) {
        return !s.add(e) || pq.add(e);
    }

    @Override
    public boolean offer(E e) {
        return !s.add(e) || pq.offer(e);
    }

    @Override
    public E poll() {
        E e = pq.poll();
        s.remove(e);
        return e;
    }

    @Override
    public E peek() {
        return pq.peek();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final Iterator<E> it = s.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                return it.next();
            }
        };
    }

    @Override
    public int size() {
        return pq.size();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }
}

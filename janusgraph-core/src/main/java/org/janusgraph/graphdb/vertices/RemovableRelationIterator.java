package org.janusgraph.graphdb.vertices;

import org.janusgraph.core.JanusGraphRelation;
import org.janusgraph.graphdb.internal.InternalRelation;

import java.util.Iterator;

public class RemovableRelationIterator<O extends JanusGraphRelation>
        implements Iterator<O> {


    private final Iterator<InternalRelation> iterator;
    private InternalRelation current;

    public RemovableRelationIterator(Iterator<InternalRelation> iter) {
        iterator = iter;
        current = null;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();

    }

    @SuppressWarnings("unchecked")
    @Override
    public O next() {
        current = iterator.next();
        return (O) current;
    }

    @Override
    public void remove() {
        assert current != null;
        //iterator.remove();
        current.remove();
    }


}
package pl.sggw;

import java.util.Iterator;

class CustomIterator<T> implements Iterator<T>
{
    Integer index = 0;
    WzimSet<T> l;
    public CustomIterator(WzimSet<T> ts) {
        l = ts;
    }

    @Override
    public boolean hasNext() {
        return index < l.size();
    }

    @Override
    public T next() {
        if(l.size() == 0) return null;
        index += 1;
        return l.get(index - 1);
    }

    @Override
    public void remove() {
        l.remove(this);
    }
}
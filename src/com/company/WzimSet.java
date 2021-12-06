package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class WzimSet<T> implements Set<T>, Iterable<T>
{

    T[] zbior;
    Integer Len = 0;

    public WzimSet()
    {
        this.zbior = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return Len;
    }

    @Override
    public boolean isEmpty() {
        return Len == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(!isEmpty())
        {
            for(int i = 0; i < zbior.length; i++)
            {
                if(zbior[i] == (T)o) return true;
            }
            return false;
        }
        else return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return zbior;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[])zbior;
    }

    @Override
    public boolean add(T t) {
        if(!contains(t))
        {
            zbior = Arrays.copyOf(zbior,zbior.length + 1);
            zbior[Len] = t;
            Len = zbior.length;
            return true;
        }
        else return false;
    }

    private Integer indexOf(Object o)
    {
        Integer index = -1;
        for(int i = 0; i < zbior.length; i++)
        {
            if(zbior[i] == (T)o) { index = i; return index; }
        }
        return index;
    }

    T get(int index) {
        return zbior[index];
    }

    @Override
    public boolean remove(Object o) {
        if(contains((T)o))
        {
            Integer index = indexOf(o);
            if(zbior.length > 0)
            {
                T pom = zbior[zbior.length - 1];
                zbior = Arrays.copyOf(zbior,zbior.length - 1);
                if(zbior.length != 0) {
                    zbior[index] = pom;
                    Len--;
                }
                else Len = 0;

                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(!this.contains((Object)(c.toArray())[j])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean war = false;
        if(c.toArray().length == 0) return false;
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(this.add((T)c.toArray()[j])) war = true;
        }
        Len = zbior.length;
        return war;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        WzimSet<T> pom = new WzimSet<T>();
        boolean war = false;
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(contains(c.toArray()[j])) {
                pom.add((T)c.toArray()[j]);
                war = true;
            }
        }
        zbior = (T[]) pom.toArray(); // toArray - lokalne
        Len = zbior.length;
        return war;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean war = true;
        for(int j = 0; j < c.toArray().length; j++)
        {
            if(!this.remove(c.toArray()[j])) {
                war = false;
            }
        }
        Len = zbior.length;
        return war;
    }

    @Override
    public void clear() {
        zbior = (T[]) new Object[0];
    }
}
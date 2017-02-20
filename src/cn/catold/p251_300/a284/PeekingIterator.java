package cn.catold.p251_300.a284;

import java.util.Iterator;

/**
 * Created by catold on 15/02/2017.
 */
public class PeekingIterator implements Iterator<Integer> {
    private Integer peekedElement;
    private boolean hasPeeked;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator == null) {
            throw new NullPointerException();
        }
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if(hasPeeked) {
            hasPeeked = false;
            Integer result = peekedElement;
            peekedElement = null;
            return result;
        }
        return iterator.next();
    }

    public Integer peek() {
        if(hasPeeked) {
            return peekedElement;
        }

        hasPeeked = true;
        peekedElement = iterator.next();
        return peekedElement;
    }
}

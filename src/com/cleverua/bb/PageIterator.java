package com.cleverua.bb;



public class PageIterator {
    private int currentIdx = 0;
    private IPage[] pages;
    
    public PageIterator(IPage[] pages) {
        this.pages = pages;
    }
    
    public boolean hasNext() {
        return currentIdx < pages.length - 1;
    }
    
    public IPage getFirst() {
        if (pages.length != 0) {
            currentIdx = 0;
            return getCurrent();
        } else {
            return null;
        }
    }
    
    public IPage getNext() {
        if (currentIdx < pages.length - 1) {
            return pages[++currentIdx];
        } else {
            return null;
        }
    }
    
    public IPage getPrevious() {
        if (currentIdx >= 1) {
            return pages[--currentIdx];
        } else {
            return null;
        }
    }
    
    public IPage getLast() {
        if (pages.length != 0) {
            currentIdx = pages.length - 1;
            return getCurrent();
        } else {
            return null;
        }
    }
    
    public IPage getCurrent() {
        return pages[currentIdx];
    }

    public boolean isFirst() {
        return currentIdx == 0;
    }

    public boolean isLast() {
        return currentIdx == pages.length - 1;
    }
}

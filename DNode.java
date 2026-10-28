
package com.mycompany.sistemaatencionbancaria;

public class DNode<T>{
    private DNode<T> next;
    private DNode<T> prev;
    private T info;
    
    public DNode(T info){
        this.info=info;
        this.prev=null; 
        this.next=null;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}

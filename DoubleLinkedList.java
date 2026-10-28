
package com.mycompany.sistemaatencionbancaria;


public class DoubleLinkedList<T> implements IList<T> {
    
    protected DNode<T> first;
    
    protected int size;
    
    public DoubleLinkedList(){
        this.first=null;   
        this.size=0;
    }

    @Override
    public void add(T t) {  
        DNode<T> node = new DNode<>(t);
        if(isEmpty()){
            first=node;
        }else{
            DNode cursor=first;
            while(cursor.getNext()!=null){
                cursor=cursor.getNext();
            }
            cursor.setNext(node);
            node.setPrev(cursor);
        }
        size++;
        
        
    }

    @Override
    public void add(T t, int index) {
        DNode<T> node = new DNode<>(t);
        if(index < 0){
            throw new UnsupportedOperationException("Introduzca una poscicion valida, actualmente esta fuera de rango."+ index);
        }
        
        if(index==0){
            if(first==null){
                first=node;
            }else{
            first.setPrev(node);
            node.setNext(first);
            first=node;
            }
            size++;
            return;
        }
        if(index>=size){
            add(t);
            System.out.println("Se inserto el elemento en la poscicion: "+size);
            return;
        }
        if(index > 0 || index <size ){
            DNode cursor =first;
            DNode aux = null;
            for (int i = 0; i < index; i++) {
                aux=cursor;
                cursor=cursor.getNext();
            }
            node.setNext(cursor);
            node.setPrev(aux);
            cursor.setPrev(node);
            aux.setNext(node);
            size++;
        }
        
        
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        DNode<T> eliminar;

        if (index == 0) {
            eliminar = first;
            first = first.getNext();
            if (first != null) {
                first.setPrev(null);
            }
        }
        
        else {
            eliminar = obtenerNodo(index);
            DNode<T> anterior = eliminar.getPrev();
            DNode<T> siguiente = eliminar.getNext();

            anterior.setNext(siguiente);
            if (siguiente != null) {
                siguiente.setPrev(anterior);
            }
        }

        eliminar.setNext(null);
        eliminar.setPrev(null);
        size--;

        return eliminar.getInfo();
    }

    @Override
    public T get(int index) {
         if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        return obtenerNodo(index).getInfo();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int clear(){
        int eliminados = size;

        DNode<T> actual = first;
        while (actual != null) {
            DNode<T> siguiente = actual.getNext();
            actual.setNext(null);
            actual.setPrev(null);
            actual = siguiente;
        }

        first = null;
        size = 0;

        return eliminados;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }
   
    private DNode<T> obtenerNodo(int index) {
        DNode<T> actual = first;
        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }
        return actual;
    }
    
}

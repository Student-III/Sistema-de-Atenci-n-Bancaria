
package com.mycompany.sistemaatencionbancaria;

public interface IList<T> {
    void add(T t);
    void add(T t,int index);
    T remove(int index);
    T get(int index);
    int size();
    int clear();
    boolean isEmpty();
    
}

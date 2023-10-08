package datastrukturer.LenketListe;

public interface ILinkedList<T>{
    //what a linked list should contain

    public void add(T val,int index);
    public void addFirst(T val);
    public void remove(int index);
    public void removeFirst();
    public T findValue(T val);
    public T findByIndex(int index);



}

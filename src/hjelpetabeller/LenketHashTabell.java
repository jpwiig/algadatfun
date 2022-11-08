package hjelpetabeller;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LenketHashTabell<T> // implements Beholder<T>
{
    private static class Node<T>      // en indre nodeklasse
    {
        private final T verdi;          // nodens verdi
        private final int hashverdi;    // lagrer hashverdien
        private Node<T> neste;          // peker til neste node

        private Node(T verdi, int hashverdi, Node<T> neste)  // konstruktør
        {
            this.verdi = verdi;
            this.hashverdi = hashverdi;
            this.neste = neste;
        }
    } // class Node

    private Node<T>[] hash;           // en nodetabell
    private final float tetthet;      // eng: loadfactor
    private int grense;               // eng: threshold (norsk: terskel)
    private int antall;               // antall verdier

    public LenketHashTabell(int dimensjon)  // konstruktør
    {
        if (dimensjon < 0) throw new IllegalArgumentException("Negativ dimensjon!");

        hash = new Node[dimensjon];                // bruker raw type
        tetthet = 0.75f;                           // maksimalt 75% full
        grense = (int)(tetthet * hash.length);     // gjør om til int
        antall = 0;                                // foreløpig ingen verdier
    }
    public LenketHashTabell()  // standardkonstruktør
    {
        this(13);  // velger 13 som startdimensjon inntil videre
    }

    public int antall() {
        return antall;
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean fjern (T verdi){
        if (verdi == null) return false;
        int hashverdi  = verdi.hashCode() & 0x7ffffff;
        int index  = hashverdi % hash.length;
        Node <T>  remove = hash[index];
        Node next = null;
        while (remove != null){
            if (verdi.equals(remove.verdi))break;
            remove = (next = remove).neste;
        }
        if (remove==null)return false;
        else if (remove == hash[index]) hash [index] = remove.neste;
        else next.neste = remove.neste;

        antall--;
        return true;
    }

  public boolean nullstil(){
        if (antall > 0) {
            antall = 0;
            for (int i = 0; i < hash.length; i++) {
                hash[i] = null;
            }
        }
return true;
    }
    public Iterator<T> iterator(){
        return new HashTabelliterator();
    }

    private class HashTabelliterator implements Iterator<T>{
    private int index = 0;
    private Node<T> p = null;
    private boolean fjernOK = false;
    private int Iteratorendringer = 0;

    private HashTabelliterator() {
        if (!tom()){
            while(hash[index] == null) index++;
            p = hash[index];
        }
    }
    public boolean hasNext(){
        return p != null;
    }
    public T next(){
        if (!hasNext()) throw new NoSuchElementException("Ingen flere verdier!");
        T verdi = p.verdi;
        while (hash[index] == null) index ++;
        p = hash[index];
        while (++index  < hash.length && hash[index] == null);
        p = index < hash.length ? hash[index] : null;
        return verdi;
    }
    }
    public boolean inneholder (T verdi){
        if (verdi == null) return false;
        int hashverdi = verdi.hashCode() & 0x7fffffff;
        Node <T> p = hash[hashverdi % hash.length];
        while (p != null){
            if (verdi.equals(p.verdi)) return true;
            p = p.neste;
        }
        return false;
    }
    // flere metoder skal inn her
public boolean legginn (T verdi){
    Objects.requireNonNull(verdi, "verdi er null");
    if (antall >= grense){
        utvid();
    }
    int hashverdi = verdi.hashCode() & 0x7ffffff;
    int indeks =  hashverdi % hash.length;
    //legger til første node som hører til indek
    hash[indeks] =  new Node<>(verdi,hashverdi, hash[indeks]);
    antall++;
    return true;
}

    public void utvid() {
        @SuppressWarnings({"rawtypes", "unchecked"})
        Node<T>[] nyhash = new Node[2 * hash.length + 1];
        for (int i = 0; i  < hash.length; i++){
            Node<T> p = hash[i];
            while (p !=  null){
                Node q = p.neste;
                int nyindeks = p.hashverdi % nyhash.length;

                p.neste = nyhash [nyindeks];
                nyhash [nyindeks] = p;
                p = q;
            }
        }
    }

}  // class LenketHashTabell


package hjelpetabeller;

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

    public boolean fjern (T vedi){
        return true;
    }

 /*   public boolean nullstil(){

    }*/
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


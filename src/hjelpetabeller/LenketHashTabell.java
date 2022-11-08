package hjelpetabeller;

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

    public boolean nullstil(){
        Node<T>node = new Node<>(null, hash, node.neste);
        while (node.neste.verdi != null){
            node = node.neste;
            node.verdi = null;
        }
    }
    // flere metoder skal inn her

}  // class LenketHashTabell


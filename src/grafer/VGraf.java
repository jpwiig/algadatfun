package grafer;

import java.util.*;

public final class VGraf implements Iterable<String>
{
    private static final class Kant              // en indre klasse
    {
        private final Node til;                    // noden som kanten går til
        private int vekt;                          // kantens vekt

        private Kant(Node til, int vekt)           // konstruktør
        {
            this.til = til;                          // tilordnes verdi
            this.vekt = vekt;                        // tilordnes verdi
        }

    } // Kant

    private static final class Node              // en indre klasse
    {
        private static final int uendelig = 0x7fffffff;  // maks int-verdi

        private final String navn;                 // navn/identifikator
        private final List<Kant> kanter;           // nodens kanter

        private int avstand = uendelig;            // til senere bruk
        private boolean ferdig = false;            // til senere bruk
        private Node forrige = null;               // til senere bruk

        private Node(String navn)                  // konstruktør
        {
            this.navn = navn;                        // nodens navn
            kanter = new LinkedList<>();             // en tom liste
        }

    } // Node

    private final Map<String, Node> noder;       // en map til å lagre nodene

    public VGraf()                               // standardkonstruktør
    {
        noder = new TreeMap<>();                   // oppretter en TreeMap
    }

    public boolean leggInnNode(String navn)      // ny node
    {
        if (navn == null) throw new IllegalArgumentException("navn er null!");
        if (noder.get(navn) != null) return false;

        noder.put(navn, new Node(navn));
        return true;
    }

    public boolean nodeFinnes(String navn)      // finnes denne noden?
    {
        return noder.get(navn) != null;
    }

    @Override
    public Iterator<String> iterator()
    {
        return noder.keySet().iterator();
    }

    public String[] nodenavn()
    {
        return noder.keySet().toArray(new String[0]);
    }

    public void leggInnKant(String franode, String tilnode, int vekt)
    {
        if (franode.equals(tilnode)) throw    // sjekker om de er like
                new IllegalArgumentException(franode + " er lik " + tilnode + "!");

        Node fra = noder.get(franode);  // henter franode
        if (fra == null) throw new NoSuchElementException(franode + " er ukjent!");

        Node til = noder.get(tilnode);  // henter tilnode
        if (til == null) throw new NoSuchElementException(tilnode + " er ukjent!");

        // sjekker om kanten finnes fra før
        for (Kant kant : fra.kanter)   // går gjennom kantene
        {
            if (kant.til == til)
                throw new IllegalArgumentException("Kanten finnes fra før!");
        }

        fra.kanter.add(new Kant(til, vekt));  // legger til i kantlisten
    }

    public String kanterFra(String node)               // kantene fra node
    {
        Node fra = noder.get(node);                      // henter noden
        if (fra == null) return node + " er ukjent!";

        StringJoiner sj = new StringJoiner(", ");        // bygger en tegnstreng
        for (Kant k : fra.kanter) sj.add(k.toString());  // går gjennom listen
        return sj.toString();
    }

    public static void main(String[] args) {

        for (String node : graf)  // bruker iteratoren i grafen
        {
            System.out.println(node + " -> " + graf.kanterFra(node));
        }

    }

} // VGraf


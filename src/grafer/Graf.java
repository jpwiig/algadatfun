package grafer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;

public final class Graf implements Iterable<String>
{
    private static final class Node             // en indre nodeklasse
    {
        private final String navn;                // navn/identifikator
        private final List<Node> kanter = new LinkedList<>();  // nodens kanter
        private boolean besøkt = false;           // hjelpevariabel til senere bruk
        private Node forrige = null;              // hjelpevariabel til senere bruk

        private Node(String navn)                 // nodekonstruktør
        {
            this.navn = navn;                       // nodens navn
        }

        @Override
        public String toString()                  // navnet
        {
            return navn;
        }

    } // Node

    private final Map<String, Node> noder;      // en map til å lagre nodene

    public Graf()                               // standardkonstruktør
    {
        noder = new TreeMap<>();                  // oppretter en TreeMap
    }

    public Graf(String url) throws IOException  // konstruktør - henter fra fil
    {
        try (BufferedReader inn = new BufferedReader  // leser fra fil
                (new InputStreamReader((new URL(url)).openStream())))
        {
            noder = new TreeMap<>();                 // oppretter en TreeMap

            String linje;
            while ((linje = inn.readLine()) != null)
            {
                String[] navn = linje.split(" ");      // deler opp linjen

                leggInnNode(navn[0]);                  // noden kommer først

                for (int i = 1; i < navn.length; i++)  // så nodene det går kant til
                {
                    leggInnNode(navn[i]);                // navnet på naboen
                    leggInnKant(navn[0], navn[i]);       // legges inn som nabo
                }
            }
        }
    }

    public boolean leggInnNode(String navn)     // ny node
    {
        if (noder.get(navn) != null) return false;
        noder.put(navn, new Node(navn));
        return true;
    }

    public boolean nodeFinnes(String navn)      // finnes denne noden?
    {
        return noder.get(navn) != null;
    }

    public Iterator<String> iterator()          // klassen er iterable
    {
        return noder.keySet().iterator();
    }

    public void leggInnKant(String franode, String tilnode)
    {
        if (franode.equals(tilnode)) throw    // sjekker om de er like
                new IllegalArgumentException(franode + " er lik " + tilnode + "!");

        Node fra = noder.get(franode);  // henter franode
        if (fra == null) throw new NoSuchElementException(franode + " er ukjent!");

        Node til = noder.get(tilnode);  // henter tilnode
        if (til == null) throw new NoSuchElementException(tilnode + " er ukjent!");

        if(fra.kanter.contains(til)) throw
                new IllegalArgumentException("Kanten finnes fra før!");

        fra.kanter.add(til);  // legger til i kantlisten
    }

    public void leggInnKanter(String franode, String... tilnoder)
    {
        for (String tilnode : tilnoder) leggInnKant(franode, tilnode);
    }

    public String kanterFra(String node)
    {
        Node fra = noder.get(node);
        if (fra == null) return node + " er ukjent!";
        return fra.kanter.toString();
    }

    public boolean erKant(String franode, String tilnode)
    {
        Node fra = noder.get(franode);
        if (fra == null) throw new IllegalArgumentException(franode + " er ukjent!");

        Node til = noder.get(franode);
        if (til == null) throw new IllegalArgumentException(franode + " er ukjent!");

        for (Node n : fra.kanter) if (n.navn.equals(tilnode)) return true;
        return false;
    }

    public String[] kantTabellFra(String node)
    {
        Node fra = noder.get(node);
        if (fra == null) return null;
        String[] kanttabell = new String[fra.kanter.size()];
        int i = 0;
        for (Node p : fra.kanter) kanttabell[i++] = p.navn;
        return kanttabell;
    }

    public int grad(String nodenavn)
    {
        Node p = noder.get(nodenavn);
        if (p == null) throw new NoSuchElementException(nodenavn + " er ukjent!");
        return p.kanter.size();
    }

    public int antallNoder()
    {
        return noder.size();
    }

    public boolean erIsolert(String nodenavn)
    {
        Node p = noder.get(nodenavn);
        if (p == null) throw new NoSuchElementException(nodenavn + " er ukjent!");
        if (p.kanter.size() > 0) return false; // ingen kanter fra noden

        for (String navn : noder.keySet())
        {
            Node q = noder.get(navn);
            for (Node n : q.kanter) if (n.navn.equals(nodenavn)) return false;
        }
        return true;
    }

    public void skrivGraf(String filnavn) throws IOException
    {
        PrintWriter ut = new PrintWriter(filnavn);

        for (String nodenavn : this)  // bruker iteratoren i grafen
        {
            ut.print(nodenavn);
            Node node = noder.get(nodenavn);

            // bruker iteratoren i kantlisten
            for (Node til : node.kanter) ut.print(" " + til.navn);
            ut.println();
        }

        ut.close();
    }

    public String[] nodenavn()
    {
        String[] navntabell = new String[noder.size()];
        int i = 0;
        for (String navn : this) navntabell[i++] = navn;
        return navntabell;
    }

    public void dybdeFørstTraversering(String startnode, Consumer<String> oppgave)
    {
        Node p = noder.get(startnode);
        if (p == null) throw new IllegalArgumentException(startnode + " er ukjent!");

        dybdeFørst(p, oppgave);  // kaller den rekursive metoden
    }

    private void dybdeFørst(Node p, Consumer<String> oppgave)
    {
        p.besøkt = true;
        oppgave.accept(p.navn);

        for (Node q : p.kanter)  // forAlle-løkke
        {
            if (!q.besøkt) dybdeFørst(q, oppgave);
        }
    }

    public void nullstill()
    {
        for (Node p : noder.values())
        {
            p.besøkt = false;
            p.forrige = null;
        }
    }

    public void breddeFørstTraversering(String startnode, Consumer<String> oppgave)
    {
        Node p = noder.get(startnode);             // henter startnoden
        if (p == null) throw new IllegalArgumentException(startnode + " er ukjent!");

        Queue<Node> kø = new ArrayDeque<>();       // oppretter en nodekø
        p.besøkt = true;                           // noden p er den første vi besøker
        kø.offer(p);                               // legger noden p i køen

        while (!kø.isEmpty())                      // så lenge køen ikke er tom
        {
            p = kø.poll();                           // tar ut en node fra køen
            oppgave.accept(p.navn);                  // utfører oppgaven

            for (Node q : p.kanter)                  // nodene det går en kant til
            {
                if (!q.besøkt)                         // denne er ikke besøkt
                {
                    q.besøkt = true;                     // nå er den besøkt
                    kø.offer(q);                         // legger noden i køen
                }
            }
        }
    }

}
class main{
    public static void main(String[] args) throws IOException {
        String url = "https://www.cs.hioa.no/~ulfu/appolonius/kap11/1/graf1.txt";
        Graf graf = new Graf(url);

        for (String node : graf)  // bruker iteratoren i grafen
        {
            System.out.println(node + " -> " + graf.kanterFra(node));
        }
    //    String URL2 =
    }
}
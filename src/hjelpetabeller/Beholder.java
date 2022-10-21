package hjelpetabeller;

import java.util.Iterator;

public interface Beholder<T> extends Iterable<T>  // foreløpig versjon
    {
        public boolean leggInn(T verdi);   // legger inn i beholderen
        public Iterator<T> iterator();     // returnerer en iterator

        // andre aktuelle metoder
    }


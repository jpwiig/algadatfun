package eksamen;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class eks2016 {
    public void swap (char[]a, int k, int j){
        char temp = a[k];
        a[k] = a[j];
        a[j] = temp;

    }
    public static int omorganiser(char[] c){

            int antall = 0;
            for (int i = 0; i < c.length - 1; i++) {
                if (c[i] > c[i + 1]) { //sjekker størrelsen og bytter
                    char temp = c[i];
                    c[i] = c[i + 1];
                    c[i + 1] = temp;
                }
                if (Character.isLowerCase(c[i])) antall++;

            }
            return antall;
    }

    public static <T> int compare (List<T>a, List<T>b, Comparator<? super T> comparator){
    int min = Math.min(a.size(), b.size());
        Iterator<T> i = a.iterator();
        Iterator<T> j = b.iterator();
        for (int k = 0; k < min; k++){
        int c = comparator(i.next(), j.next());
        if (c != 0) return c; 
    }
    }

    public interface Liste<T> extends Beholder<T>
    {
        public boolean leggInn(T verdi);           // verdi bakerst
        public void leggInn(int indeks, T verdi);  // verdi på plass indeks
        public boolean inneholder(T verdi);        // er verdi i listen?
        public T hent(int indeks);                 // hent verdi på plass indeks
        public int indeksTil(T verdi);             // hvor ligger verdi?
        public T oppdater(int indeks, T verdi);    // oppdater på plass indeks
        public boolean fjern(T verdi);             // fjern verdi
        public T fjern(int indeks);                // fjern verdi på plass indeks
        public int antall();                       // antallet i listen
        public boolean tom();                      // er listen tom?
        public void nullstill();                   // listen nullstilles (og tømmes)
        public Iterator<T> iterator();             // en iterator
        public String toString();                  // innholdet - først til bakerst
    }
}



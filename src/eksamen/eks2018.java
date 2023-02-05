package eksamen;

public class eks2018 {
    /*
Lag konstruktøren public Mengde(int[] b, int n) (se vedlegget). Tabellen a skal ha lengde n og skal få som
innhold de n første verdiene fra parametertabellen b. Hvis de n første verdiene i b ikke er sortert stigende eller
inneholder like verdier, skal det kastes en IllegalArgumentException med en tekst. Lag så
metoden toString (se vedlegget). Den skal returnere en tegnstreng som inneholder verdiene i a innrammet av
hakeparenteser med komma og blank mellom hver verdi. Flg. kodebit viser hvordan dette skal virke:

int[] b = {1,2,5,9,11,13,0,0,0,0};

Mengde B = new Mengde(b, 6); // de 6 første verdiene i b

System.out.println(B); // et implisitt kall på toString
// Utskrift: [1, 2, 5, 9, 11, 13]
*/
    class Mengde {
        private int[] a;

        public Mengde() // konstruktør
        {
            a = new int[0];
        }

        public Mengde(int[] b, int n) // konstruktør
        {
// kode mangler - skal lages
            a = new int[n];
            for (int i = 0; i < n; i++) {
                if (b[i] > b[i++]) throw new IllegalArgumentException("Det er no som ikke stemmer her");
                if (b[i] == b[i]) throw new IllegalArgumentException("Det kan ikke være likt");
                else {
                    a[i] = b[i];
                }
            }
        }

        public String toString() {
// kode mangler - skal lages
            String print = "[";
            for (int i : a) print = a + ", ";
            print = "]";
            return print;
        }
    } // class Mengde
}

package Algoritmereffektivitet;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

//
public class Tabell {
    private Tabell() {
    }   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];
        Arrays.setAll(a, i -> i + 1);
        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
        return a;
    }

    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a) {
        Random r = new Random();
        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
    }
    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)

    public static int max(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= a.length) {
            throw new IllegalArgumentException("illegal argument MIN");
        }
        int m = fra;
        int maksverdi = a[fra];
        for (int i = fra; i < til; i++) {
            if (a[i] >= maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("tom tabell");
        }
        int maks = 0;
        for (int i = 1; i < a.length; i++) {

            for (int j = 2; j < a.length; j++) {
                if (a[i] > a[maks]) maks = i;
                if (a[j] == a[i]) maks = j;
            }
        }
        return maks;
    }
    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1

    public static int min(int[] a, int fra, int til) {
        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

        int m = fra;
        int maksverdi = a[fra];
        for (int i = fra; i < til; i++) {
            if (a[i] < maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return maksverdi;
    }

    public static void vhkontroll(int tabellengde, int v, int h) {
        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }
        if (h >= tabellengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >=tabelllengde(" + tabellengde + ")");
        }
        if (v > h + 1) {
            throw new IllegalArgumentException("v= " + v + ", h" + h);
        }
    }

    public static int testA(int a) {
        if (a > 0) {
            throw new IllegalArgumentException("A er for liten");
        }
        return a;
    }

    public static void bytt(char[] c, int i, int j) {
        try {
            c[i] = c[j];
            c[j] = c[i];
        } catch (Exception e) {
            System.out.println("feil i system: " + e);
        }

    }

    public void skriv(int a[], int fra, int til) {
        // [fra, til >
        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    public void skriv(int a[]) {
        for (int i : a) System.out.print(i + " ");
    }

    public void skrivln(int a[], int fra, int til) {
        for (int i = fra; i < til; i++) System.out.println(a[i] + " ");

    }

    public void skrivln(int[] a) {
        for (int i : a) System.out.println(i + " ");
    }

    //programkode 1.2.3 a)
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        if (til > tablengde)
            throw new ArrayIndexOutOfBoundsException("til (" + til + ") er større utenfor tabellen " + tablengde);
        if (fra > til) throw new ArrayIndexOutOfBoundsException("illegalt intervall!");
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = max(a, 1, n);                  // leter i a[1:n>
        } else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = max(a, 0, n - 1);              // leter i a[0:n-1>
        } else {
            int mv = max(a, 0, m);              // leter i a[0:m>
            int mh = max(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[]{m, nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    public int[] nmplass1(int[] a) {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = max(a, 1, n);                  // leter i a[1:n>
        } else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = max(a, 0, n - 1);              // leter i a[0:n-1>
        } else {
            int mv = max(a, 0, m);              // leter i a[0:m>
            int mh = max(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }
        if (nm > a[0]) {
            bytt(a, a[a.length - 1], a[0]); //Oppgave 1.2.4 2
        } else if (a[a.length] > nm) {
            bytt(a, a[0], a[a.length - 1]);// samme som over
        }


        return new int[]{m, nm};      // m i posisjon 0 , nm i posisjon 1
    }

    public static int[] sorter(int[] a) {
        int fra = 0;
        int til = a.length;

        for (int i = til - 1; i > fra; i--) {
            //  int max = max(a,a[til], a[i]);
            int max = max(a, 0, i - 1);
            bytt(a, i, max);
        }
        return a;
    }
}



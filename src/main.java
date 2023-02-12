import Algoritmereffektivitet.fakultet;
import Algoritmereffektivitet.maksogmin;

public class main {
    public static void main(String[] args) {
      /*  int[] a = {8, 3, 5, 7, 9, 2, 1, 4};
        fakultet fakkas = new fakultet();
        maksogmin mnm = new maksogmin();
        int fakultet = 4;
        tid time = new tid();

        int[] al = {1, 4, 8, 12, 12, 12, 9};
        System.out.println(mnm.max(a));
        System.out.println(time.maks(a));
        System.out.println("fakultet: " + fakkas.fak(fakultet));
        int[] b = {12, 11, 12, 13, 14, 15, 15, 10, 2};
        int[] bø = mnm.minmaks(a);
        for (int j : bø) System.out.print(j + " ");
        System.out.println("plassering på den seneste max er: " + mnm.samenum(b));
        System.out.println("programkode 1.15: " + time.maks(al));

        //1.2.2 oppgave 2:
        System.out.println("1.2.2 Oppgave 2: ");
        int[] aT = Tabell.randPerm(20); //random array
        for (int k : aT) System.out.print(k + " ");

        int[] nm = Tabell.nestMaks(aT);

        int m = Tabell.maks(aT);
        System.out.println("\nden største verdi ligger på plass: " + m);
        System.out.print("nest størst: ");
        for (int i : nm) System.out.print(i + " ");

        int[] storter = Tabell.sorter(aT);
        System.out.println("sortert: ");
        for (int i : storter) System.out.print(i + " ");
        int[] a2 = {3, 1, 4, 9, 7, 10, 8, 6, 5, 2};        // permutasjon av tallene fra 1 til 10
        Tabell.nestePremutasjon(a2);              // lager neste permutasjon
        System.out.println(Arrays.toString(a2));

        int[] ba = {2, 3, 6, 1, 4, 5};
        Tabell.nestePremutasjon(ba);
        System.out.println("a: " + Arrays.toString(ba));
        int[] bb = {2, 3, 6, 1, 5, 4};
        Tabell.nestePremutasjon(bb);
        System.out.println("b: " + Arrays.toString(bb));
        int [] bd = {2 ,3 , 6 ,5 , 4, 1};
      //  Tabell.nestePremutasjon(bd);
        //  System.out.println("d: " + Arrays.toString(bd));
        int [] inv = {3,5,4,6,8,1,2,9,10};
        System.out.println(Tabell.inversjoner(inv));
*/
       int []ar= Tabell.randPerm(100000);
       int [] arunfucked =Arrays.copyOf(ar, ar.length);
       int test [] = {1,2,3,4,5,6};

       Tabell.utvalgssortering(ar);
       if (arunfucked != ar) System.out.println("damn");
       System.out.println(Arrays.toString(ar));

       int [] aSok = {1,1,1,1,3,4,5,6,7,9};
        System.out.println("linjær søk: " +  Tabell.linjaersok(aSok,4));
    }
}

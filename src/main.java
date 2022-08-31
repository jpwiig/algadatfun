import Algoritmereffektivitet.Tabell;
import Algoritmereffektivitet.fakultet;
import Algoritmereffektivitet.maksogmin;
import Algoritmereffektivitet.tid;

public class main {
public static void main(String[]args){
    int[] a = {8, 3,5, 7, 9, 2, 1, 4};
    fakultet fakkas = new fakultet();
    maksogmin mnm= new maksogmin();
    int fakultet = 4;
    tid time = new tid();

    int [] al = {1, 4, 8, 12, 12, 12, 9};
    System.out.println(mnm.max(a));
    System.out.println(time.maks(a));
    System.out.println("fakultet: " + fakkas.fak(fakultet));
    int [] b = {12, 11, 12, 13, 14, 15, 15, 10, 2};
   int []bø = mnm.minmaks(a);
    for (int j : bø) System.out.print( j + " ");
    System.out.println("plassering på den seneste max er: " + mnm.samenum(b));
    System.out.println("programkode 1.15: " + time.maks(al));

    //1.2.2 oppgave 2:
    System.out.println("1.2.2 Oppgave 2: " );
    int []aT = Tabell.randPerm(20); //random array
    for (int k: aT) System.out.print(k + " ");

    int m = Tabell.maks(aT);
    System.out.println("\nden største verdi ligger på plass: " +m);
}
}

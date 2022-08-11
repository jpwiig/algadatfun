import Algoritmereffektivitet.fakultet;
import Algoritmereffektivitet.maksogmin;

public class main {
public static void main(String[]args){
    int[] a = {8, 3,5, 7, 9, 2, 1, 4};
    fakultet fakkas = new fakultet();
    maksogmin mnm= new maksogmin();
    int fakultet = 10;
    System.out.println(mnm.max(a));

    System.out.println(fakkas.fak(fakultet));
    int [] b = {12, 11, 12, 13, 14, 15, 15, 10, 2};

    System.out.println("plassering på den seneste max er: " + mnm.samenum(b));
}
}

package Algoritmereffektivitet;

public class neststorst {

    //oppgaver 1.2.1 oppgave 1

    public static int min(int [] a, int fra, int  til){
        if (fra < 0 || til > a.length || fra >= a.length){
            throw new IllegalArgumentException("illegal argument");
        }
        int m = fra;
        int maksverdi = a[fra];
        for (int i =  fra; i < til; i ++){
           if (a [i] < maksverdi ){
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

}


package Algoritmereffektivitet;

import javax.swing.*;
import java.util.NoSuchElementException;

public class maksogmin {

    public static int min(int a[]) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("tom tabell");
        }
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[min]) min = i;
        }
        return min;
    }

    public static int max(int a[]) {
        if (a.length < 1) throw new java.util.NoSuchElementException("tom tabell");

        int max = 0;
        for (int j = 1; j < a.length; j++) {
            //legg til en if -setning som sjekker om det er flere like tall, hvis det er flere like tall, så skipper den over den første om sammenligner med den siste
            if (a[j] > a[max]) max = j;
        }
        return max;
    }

    public static int samenum(int a[]) {
        if (a.length < 1) throw new NoSuchElementException("tom");
        int maxnew = 0;
        for (int k = 1; k < a.length; k++) {
            for ( int compare = 0; compare < a.length; compare++){
                if (a[k] == a[compare]) {
                    return compare;
                }
               else  {
                    if (a[k] > a[maxnew]) {
                        maxnew = k;
                    }
                }
            }
            }
        return maxnew;
    }
    public int maxeffect (int a[]) {
        int m =0;
        int maxvalue = a[0];
        for (int i = 1; i<a.length; i++) if(a[i] > maxvalue){
            m = i;
        }
        return m;
    }
}











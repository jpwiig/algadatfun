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

            for (int j = 2; j < a.length; j++) {
                if (a[i] < a[min]) min = i;
                if (a[j] == a[i]) min = j;
            }
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
            for (int compare = 1; compare < a.length; compare++) {
                if (a[k] == a[compare]) {
                    maxnew = compare;
                }
            }
        }
        return maxnew;
    }
    public static int [] minmaks (int b[]){
        int min = b[0];
        int max = b[0];
        int index;
        for (int i = 0; i < b.length; i++){
            index = b[i];
            if ( min < index) min = index;
            if ( max > index) max = index;
        }
         int minmax[] = {min, max};
        return minmax;
    }

}











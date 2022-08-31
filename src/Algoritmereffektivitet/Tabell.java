package Algoritmereffektivitet;

import java.util.Arrays;
import java.util.Random;

//
public class Tabell {
        private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

        // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
        public static void bytt(int [] a, int i, int j){
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
        // Metoden randPerm(int n)                   Programkode 1.1.8 e)
        public static int [] randPerm (int n){
                Random r =  new Random();
                int []a = new int[n];
                Arrays.setAll(a, i -> i +1);
                for (int k = n -1; k > 0; k-- ){
                        int i = r.nextInt(k +1);
                        bytt(a,k,i);
                }
                return a;
        }
        // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
public static void randPerm (int [] a){
                Random r = new Random();
                for(int k= a.length-1; k > 0; k--){
                        int i = r.nextInt(k+1);
                        bytt(a, k, i);
                }
}
        // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)

        public static int max(int [] a, int fra, int  til){
                if (fra < 0 || til > a.length || fra >= a.length){
                        throw new IllegalArgumentException("illegal argument");
                }
                int m = fra;
                int maksverdi = a[fra];
                for (int i =  fra; i < til; i ++){
                        if (a [i] > maksverdi ){
                                m = i;
                                maksverdi = a[m];
                        }
                }
                return m;
        }
        // Metoden maks(int[] a)                     Programkode 1.2.1 c)
        public static int maks(int []a) {
                if (a.length < 1) {
                        throw new java.util.NoSuchElementException("tom tabell");
                }
                int maks = 0;
                for (int i = 1; i < a.length; i++) {

                        for (int j = 2; j < a.length; j++) {
                                if (a[i]  > a[maks]) maks = i;
                                if (a[j] == a[i]) maks = j;
                        }
                }
                return maks;
        }
        // min-metodene - se Oppgave 1 i Avsnitt 1.2.1

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

        public static void bytt(char[] c, int i, int j){
                try     {
                        c[i] = c[j];
                        c[j] = c[i];
                } catch (Exception e){
                        System.out.println("feil i system: " + e);
                }

        }
        public void skriv (int a[], int fra, int til){
                // [fra, til >
                for (int i = fra; i < til; i++) System.out.print(a[i]+ " ");
        }
        public void skriv (int a[]){
                for(int i: a) System.out.print(i + " ");
        }

        public void skrivln(int a[], int fra, int til){
                for (int i= fra; i < til; i++ ) System.out.println(a[i] + " ");

        }
        public void skrivln(int []a){
                for (int i: a) System.out.println(i + " ");
        }
}

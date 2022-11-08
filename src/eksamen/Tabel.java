package eksamen;

import java.util.Comparator;

public class Tabel {
    private Tabel(){};
   public static void fromToControll(int tabellength, int from, int to){
       if (from < 0) throw new ArrayIndexOutOfBoundsException("From(" + from + ") is negative" ); //from is negative
       if (to > tabellength) throw new ArrayIndexOutOfBoundsException("To (" + to + ") > tabel length (" +  tabellength + ")"); //to is outside of the table
       if (from > to) throw new ArrayIndexOutOfBoundsException("from (" + from + ") > to (" + to + ") - illegal interval");
   }
   public static void change(int a[], int i, int j){
       int temp = a[i]; a[i] = a[j]; a[j] = temp; //temp gets i, j gets a i(temp)
   }
   public static void print(int... a){
       for (int k : a) System.out.print(a + " ");
       }
    public static void println(int... a){
       print(a);
        System.out.println();
    }
    public static void print(Object... a){
       for (Object o : a) System.out.print(o + " ");
    }
    public static void println (Object a){
       print(a);
        System.out.println();
    }
    public static int partiton0(int [] a, int l, int r, int pivotval) {
     while (true){
         while(l <= r && a[l] < pivotval ) l++;
         while ( l <= r && a[r] >= pivotval) r++;

         if (l < r) change(a, l++, r--);
         else return l;
        }
    }
    public static int partiton(int[]a, int from, int to, int pivotval){
       fromToControll(a.length,from, to);
       return partiton0(a, from, to - 1, pivotval);
    }
    public static int partiton(int [] a, int pivotval){
       return partiton0(a, 0, a.length -1, pivotval);
    }
    public static int sPartion0(int []a, int l, int r, int index){
       change(a, index, r);
       int pos = partiton0(a, l, r-1, a[r]);
       change(a, pos, r);
       return pos;
    }
    public static int sPartiton(int[]a, int from, int to, int index){
       fromToControll(a.length, from, to);
       if (from == to) throw new IllegalArgumentException("Interval a[" + from + ":" + to + "> is empty!");
       if(index < from || index >= to) throw new IllegalArgumentException("Index (" + index + ") is outside the interval");
       return sPartion0(a, from, to -1, index);
    }

    private static void quicksort0(int []a, int l, int r){
       if (l >= r) return;
       int k = sPartion0(a, l, r, (l + r)/2);
       quicksort0(a, l, k - 1);
       quicksort0(a, k +1, r);
    }
    public static void quicksort(int []a, int from, int to){
       fromToControll(a.length, from, to);
       quicksort0(a, from,to-1);
    }
//mergesort

    private static <T> void merge( T[] a, T[] b, int from, int m, int to, Comparator<? super T> c){
       int n = m - from; // number of elements in a [from : m>
       int  i  = 0, j = m, k = from;
       while (i < n && j < to){
           a[k++] = c.compare(b[i], a[j]) < 0 ?  b[i++] : a[j++];
           while (i < n) a[k++] = b[i++];
       }
    }
    private static <T> void mergesort(T[]a, T[]b, int from, int to, Comparator <? super T> c){
       if (to - from <= 1) return;
       int m = (from + to)/2;
       mergesort(a,b,from,m,c);
       mergesort(a,b,m,from,c);

       merge(a,b,from,m,to,c);
    }

    public static <T> void mergesort(T[] a, Comparator<? super T> c)
    {
        T[] b = (T[]) new Object[a.length/2];  // en hjelpetabell for flettingen
        mergesort(a,b,0,a.length,c);     // kaller metoden over
    }

}


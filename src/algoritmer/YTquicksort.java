package algoritmer;

public class YTquicksort {
    /*
    quicksort flytter mindre elementer til venstre av en skilleverdi og deler tabellen i 2 rekursivt

   beste tid (usortert) = O(n log(n))
   gjennomsnittlig tid = O(n log(n))
   værste tid (sortert) = O(n^2)
   hentet fra: https://www.youtube.com/watch?v=Vtckgz38QHs
     */
    public static void main(String[] args) {
        int []array = {8,2,5,3,9,4,7,6,1};

        quicksort(array, 0,  array.length -1);

        for (int i : array) System.out.print(i);
    }

    private static void quicksort(int []a, int s, int e) {
        if ( e <= s){
            return; //base case

        }
        int pivot = partition(a, s, e);
        quicksort(a, s, pivot -1);
        quicksort(a, pivot + 1, e);
    }
    private static int partition (int []a, int s, int e){
        int pivot = a[e];
        int i = s -1;
        for (int j = s; j <= e - 1; j++){
            if (a[j] < pivot){
                i++;
                int temp = a[i];
                a[i]  = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i]  = a[e];
        a[e] = temp;
        return i;
    }
}

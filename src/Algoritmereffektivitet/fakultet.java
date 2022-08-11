package Algoritmereffektivitet;

public class fakultet {
    public long fak(int n){
        int negN = n -1;
        long sum = 0;
        while (n > 0){
            sum= n * negN;
            n = negN;

        }
        return sum;
    }
        }

package Algoritmereffektivitet;

public class fakultet {
    private long negN;
    private long sum;

    public long fak(int n) {
        long sum = 1;
        for (int i = n; i > 1; i--) {
            sum *= i;
        }
        return sum;
    }
}


package datastrukturer.LenketListe;

public class LinkedListMain {
    public static void main(String[] args) {
        Character [] s = {'i','e'};

        LinkedList ls = new LinkedList(s);

        for (int i = 0; i < ls.length(); i++ ){
            System.out.println(ls.findByIndex(i));
        }
    }
}

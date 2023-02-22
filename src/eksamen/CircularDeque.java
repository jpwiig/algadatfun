package eksamen;

public class CircularDeque {
    private int begin; //< Starten av køen
    private int end; //< slutten av køen
    private int capacity; //< maksimal størrelse på køen
    private int size; //< antall elementer i køen så langt
    char[] values;

    CircularDeque(int capacity) {
        //Denne må du implementere
        this.values= new char [capacity];
        this.begin = 0;
        this.end = 0;
        this.size =  0;


    }

    void pushBack(char value) {

         // Denne må du implementere
        if (size + 1 > capacity) throw new IndexOutOfBoundsException("æ");
        values[end] = value;
        end = (end + 1 )%capacity;
        size = size + 1;

    }

    void pushFront(char value) {
        if (size + 1 > capacity) throw new IndexOutOfBoundsException("Ø");
        begin = begin -1;
        if (begin < 0) begin = size + begin;
        values[begin] =  value;
        size = size + 1;
        // Denne må du implementere

    }

    char popFront() {
        if (size <= 0 ) throw new IndexOutOfBoundsException("ÅÅååååå hold opp");
        char exit = values[begin];
        values[begin] = '*';
        begin = (begin + 1)%capacity;
        return exit;
    }

    char popBack() {
        if (size <= 0)throw new IndexOutOfBoundsException("JEG VIL IKKE MER <3");
        char exit = values[end];
        values[end] = '*';
        size = size -1;
        return exit;
    }
}

package eksamen;

public class circledeque {
    int begin;
    int end;
    int capacity;
    int size;
    char []values;
    public circledeque (int capactiy){
        this.values = new char[capacity];
        this.capacity = capacity;
        this.begin = 0;
        this.end = 0;
        this.size = 0;
    }
    void pushback(char value){
    if(capacity + 1 > size) throw new IndexOutOfBoundsException();
    values[capacity] = value;
    end = value;
    end = (end + 1) % size;
    size++;
    }
    void pushfront(char value){
        if   (capacity + 1 > size) throw new IndexOutOfBoundsException();
        begin = begin -1;
        if (begin < 0 ) begin = size + begin;
        values[begin] = value;
        capacity= capacity +1;
    }
    char popfront (){
        if (size <= 0) throw new IndexOutOfBoundsException();
    char head= values[begin];
    begin = (begin   + 1) % capacity;
    return head;
    }
    char popback(){
    if(size<= 0) throw new IndexOutOfBoundsException();
     end--;
     if (end < 0) end = size + end;
     char tail = values[end];
     values[end]= '*';
     return tail;
    }
}

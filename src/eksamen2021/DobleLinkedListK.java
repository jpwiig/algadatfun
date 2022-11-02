package eksamen2021;

public class DobleLinkedListK {
    public class Node {
        Node next;
        Node prev;
        char value;
    }

    Node head;
    Node tail;

    void addLast(char value) {...}
    void addFirst(char value) {...}
    char removeLast() {...}
    char removeFirst() {...}
    void print() {...}

    void remove(int index) {
        if (index == 0) {
            removeFirst();
        }
        else if (index == size-1) {
            removeLast();
        }
        else {
            //antar at size er noe som eksisterer selvom det ikke er i kildekoden
            Node current = head;
            for (int i  = 0;  i < size - 1; i++){
                Node temp = current; //holds the current value
                current = current.next;// change to the next
                current.prev = temp; //set prev to the current value
                if (i == index){
                    Node deleteNode = current;
                    deleteNode = current.prev;
                    current.next.prev =  current.prev;
                    i--;
                    size --;
                }
            }
        }
    }

    void remove(char value) {
        Node current = head;
        for (int i =  0; i < size -1){
            Node temp = current; //holds the current value
            current = current.next;// change to the next
            current.prev = temp; //set prev to the current value
        if (value == current.value) {
            // o <-> o <-> o <->
        Node deleteNode = current;
        deleteNode = current.prev;
        current.next.prev = current;
        deleteNode.next = current.next;
        size --;
        }
        }
    }
}

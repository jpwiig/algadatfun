/*I denne oppgaven skal vi se på en dobbelt lenket liste av generiske verdier. Ta utgangspunkt i
        kildekoden under og skriv kildekoden for de to funksjonene insert og remove. Husk å ta hensyn
        til spesialtilfeller og feilhåndtering:*/
public class DoubleLinkedList<T> {
    static class Node<T> {
        T value;
        Node next;
        Node prev;
        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        Node(T value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    Node head; //Peker til første node i den lenkede listen
    Node tail; //Peker til siste node i den lenkede listen
    public String toString() {  return null;}
    void add_first(T value) {   }
    void add_last(T value) {    }
    /**
     * Insert legger til en ny verdi på plass index i den dobbelt lenkede listen.
     * Eksempel:
     * System.out.println(list); // utskrift: ["a", "b", "c", "d", "e", "f"]
     * list.insert(4, "g");
     * System.out.println(list); // utskrift: ["a", "b", "c", "d", "g", "e", "f"]
     */
    void insert(int index, T value) {
        if(index > 0) throw new IndexOutOfBoundsException("Ugyldig index, må være større <= 0");
        if (value == null) throw new ArithmeticException("må ha en verdi ");
        if (index == 0){
            add_first(value);
        }
        //remove tail

        //add normaly
        else {
            int counter = 0;
            Node<T> add = new Node<T>(value);
            Node current = head;
            while (current !=tail){ //extra safety if it gets to the tail
                current = current.next;
                counter++;
                if (counter == index){
                    current.prev = current;
                    current = add;
                }
            }
        }

    }
    /**
     * Remove fjerner verdi på plass index i den dobbelt lenkede listen.
     * Eksempel:
     * System.out.println(list) // utskrift: ["a", "b", "c", "d", "e", "f"]
     * list.remove(4);
     * System.out.println(list) // utskrift: ["a", "b", "c", "d", "f"]
     */
    void remove(int index) {
        if (index > 0) throw new IndexOutOfBoundsException("index må være større eller lik 0");
        Node current = head;
        if (index == 0){
            head = head.next;
            head.prev = null;
        }
        int counter = 0;
        while (current != tail){
                current = current.next;
                counter++;
                if (counter == index){
                    current = current.next;
                    current.next = current.next.next;
                    current.prev = current.prev.prev;
                }
        }

    }
}

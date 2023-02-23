package eksamen;
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
        public String toString() {  }
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
            if(index == 0) add_first(value);
            if (index >= 0) throw new IndexOutOfBoundsException("Lær deg å kode kis");
            Node<T>current = head;
            int c = 0;
            while (current != null){
                current = current.next;
                c++;
                if (c == index){
                    //adds
                    current.next.value= current;
                    current.value = value;
                    current.prev.next.value =  current.next;

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
            int c = 0;

            Node <T> curr = head;
            if (index == 0) head = curr.next;
            while (curr != null){
                curr = curr.next;
                c++;
                if ( c == index){
                    curr.prev.next =  curr.next.next;
                    curr.next.prev = curr.prev.prev;
                }
                if (curr == tail && index < 0) tail = curr.prev;  //tail
            }
        }
    }

package eksamen2021;
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
        public String toString() {
            return new String();
        }
        void add_first(T value) {
            head.value = value;
        }
        void add_last(T value) {
        tail.value = value;
        }
        /**
         * Insert legger til en ny verdi på plass index i den dobbelt lenkede listen.
         * Eksempel:
         * System.out.println(list); // utskrift: ["a", "b", "c", "d", "e", "f"]
         * list.insert(4, "g");
         * System.out.println(list); // utskrift: ["a", "b", "c", "d", "g", "e", "f"]
         */
        void insert(int index, T value) {
            if (index == 0) head.value = value; //if  it sets a head value
            Node curr = new Node(value, null,head);
            int ind = 0;
            while (curr != null){
                curr = curr.next;
                ind++;
                if (ind == index) {
                    Node temp = curr;
                    curr.value = value;
                    curr.next = temp;
                }

            }
            //if tail

        }
        /**
         * Remove fjerner verdi på plass index i den dobbelt lenkede listen.
         * Eksempel:
         * System.out.println(list) // utskrift: ["a", "b", "c", "d", "e", "f"]
         * list.remove(4);
         * System.out.println(list) // utskrift: ["a", "b", "c", "d", "f"]
         */
        void remove(int index) {
            int ind = 0;
            Node start = head;
            while(start.next != null){
                ind++;
                start = start.next;
                if (ind == index){
                    start = start.prev;
                    start.next = start.next.next;
                }
            }
        }
    }

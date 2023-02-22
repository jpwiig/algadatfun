package eksamen;

public class Eks20192 {
    static class LinkedList {
        /**
         * En node i den lenkede listen
         */
        public static class Node {
            Node next;
            char value;
            /**
             * Konstruktør som lager en ny node
             * @param value Verdien dene noden skal ha
             */
            Node(char value) {
                this.value = value;
            }
        }
        //Peker til hode (første element i listen)
        Node head;
        /**
         * Konstruktør
         */
        LinkedList() {
            head = null;
        }
        /**
         * Funksjon som legger til en verdi i den lenkede listen
         * @param value
         */
        void add(char value) {
            Node new_node = new Node(value);
            new_node.next = head;
            head = new_node;
        }
        /**
         * Funksjon som skriver ut ved å iterere gjennom listen
         */
        public void printIterative() {
            //Her skal din kode komme i oppgave c
            if (head.equals(null)) {
                throw new IllegalArgumentException("the list is empty");
            }
            Node c = head; //c gets head
            while (c != null){
                System.out.println(c.value);
                c = c.next; //iterates until c is null
            }
        }
        /**
         * Funksjon som skriver ut ved å bruke rekursjon
         */
        public void printRecursive() {
            //Her skal din kode komme i oppgave d (del 1 av 2)
            Node d = head;
            System.out.println(d);
            while (d.next != null){
                d = d.next;
                printRecursive();
            }

        }
        /**
         * Hjelpemetode for den rekursive utskriftsfunksjonen
         * @param node
         */
        private void printRecursive(Node node) {
            //Her skal din kode komme i oppgave d (del 2 av 2)
            while (head.next != null){
                printRecursive(head);
            }
        }
    }

}

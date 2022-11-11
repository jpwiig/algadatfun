package eksamen;

public class Eksamen2019 {
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
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.print(currentNode.value + " ");
    }

    /**
     * Funksjon som skriver ut ved å bruke rekursjon
     */
    public void printRecursive() {
        //Her skal din kode komme i oppgave d (del 1 av 2)
    }

    /**
     * Hjelpemetode for den rekursive utskriftsfunksjonen
     * @param node
     */

}
    private void printRecursive(Node node) {
    if (node == null) return;//base case, stops the call if the node gets null, same as  the while loop as in print iterative
        System.out.print(node.value + " ");
        printRecursive(node);
        node = node.next; //enkelt kall
    }

    public static void main(String[] args) {
        LinkedList liste = new LinkedList();
        char values[] = "ABCDEFGHIJ".toCharArray();

        for (char val : values) {
            liste.add(val);
        }

        System.out.println("Rekursiv utskrift: ");
        liste.printRecursive();

        System.out.println("Iterativ utskrift: ");
        liste.printIterative();
    }

}

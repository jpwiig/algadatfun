package eksamen;

public class Kont2020 {
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
            if(index== 0) add_first(value);
             //legg til sist
            Node addNode = new Node(value);
            Node TNode = head;
            int currIndex = 0;
            while (TNode != null){
                TNode = TNode.next;
                currIndex ++;
                if(TNode.next == null) add_last(value);
            TNode.prev = TNode;
            TNode = addNode;
            TNode.next = TNode.next.next;
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
            Node removeNode = head;
            int curr=0;
            if(index == 0){
                head = head.next;
                head.next = head.next.next;
                head.prev = null;
            }
            while(removeNode != null){
                curr++;
                removeNode = removeNode.next;
                if (curr == index){
                    removeNode = removeNode.next;
                    removeNode.next = removeNode.next.next;
                    removeNode.prev= removeNode.prev.prev; en
                    //standard
                }
                if (removeNode.next == null){
                    removeNode = removeNode.prev;
                    removeNode.prev = removeNode.prev.prev;
                    removeNode.next = null;
                    //last
                }
            }
        }
    }
}

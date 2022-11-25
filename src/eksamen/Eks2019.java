package eksamen;

public class Eks2019 {
    public static class DoubleLinkedList {
        public class Node { Node next; Node prev; char value;
        } Node head; Node tail; void addLast(char value) {...}
        void addFirst(char value) {...} char removeLast() {...}
        char removeFirst() {...}
        void print() {...}
        void remove(int index) {
            if (index == 0) { removeFirst(); }
            else if (index == size-1) { removeLast(); }
            else {
                Node current = head; //starter på head
                int currindex= 0;
                while (current != null){
                    current = current.next;
                    currindex ++;
                    if(currindex == index){
                        current = current.prev;
                        current.next = current.next.next;
                        current.prev = current.prev.prev;
                        currindex --;
                    }
                }
                 } }
        void remove(char value) {
        Node currNode = head;
        if (currNode.value == value){
            currNode = currNode.prev;
            currNode.next = currNode.next.next;
            currNode.prev = currNode.prev.prev;
        }
            }
                }
}

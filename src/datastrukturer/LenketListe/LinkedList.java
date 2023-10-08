package datastrukturer.LenketListe;

public class LinkedList <T>implements ILinkedList<T> {
    public static class Node<T>{
      private  T val;
        private Node<T> next;
   //     private Node<T> head;

        //Two Constructors so i can over active overloading
        private Node(T val, Node n/* ,Node h*/){
            this.val = val;
            n = next;
           // h = head;
        }
        private Node(T val)
        {
            this.val= val;
        }
    }
    private Node<T> head, tail;
    private int length; //length of the list
    Node <T> p = head;

    public LinkedList(T [] arr){
        if (arr.length == 0) addFirst(arr[0]);
        //initialized the List with a array
        length = arr.length;
        //head.val = arr[0];

        for (int i = 0; i  <= arr.length -1; i++){
            add(arr[i], i);
        }
    }
    public int length(){
        return length;
    }
    public void add(T val, int index){
        int addIndex = 0;
        Node CurrentNode = head;
    if (index == 0) addFirst(val);
     while (addIndex != length){
         CurrentNode = CurrentNode.next;
         if (index == addIndex){
             //points to next
             CurrentNode = CurrentNode.next;
             CurrentNode.val = val;
         }
     }
     length++;
    }

    @Override
    public void addFirst(T val) {
        head.next = head;
        head.val = val;
        length++;

    }

    @Override
    public void remove(int index) {
    //removes the pointer && and sets the value to the next
        //last Node
        Node c = head;
        if (index == length) tail = null; //since the pointer is allready at null, we do not need to mess with the pointer
        if (index == 0){
         removeFirst();
        }
        int insideindex= 0;
        while (index != length)
        {

            if (insideindex == index){
                //removes stuff instide here
                c = c.next;
                c.next.next = c.next;
            }

        }
        length --;
    }

    @Override
    public void removeFirst() {
    head =  head.next;
    head.next = head.next.next;
    length --;
    }

    @Override
    public T findValue(T val) {
      //  Node y = new Node(null, null);
        Node current = head;
        if (val == head.val) return head.val;
        while (current.next != null){
            current = current.next;
            if ( current.val == val) return (T) current.val;
        }
    return null;
    }

    @Override
    public T findByIndex(int index) {
        if (index==0) return head.val;
        int insideIndex = 0;
        Node Current  =  head;
        while (Current.next != null){
            Current = Current.next;
            insideIndex++;
            if (insideIndex == index){
                return (T) Current.val;
            }
        }
        return null;
    }

}

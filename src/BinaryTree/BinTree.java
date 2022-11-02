package BinaryTree;

public class BinTree<T> {
    private static final class Node<T> {
        private T val;
        private Node<T> Leftchild;
        private Node<T> Rightchild;

        public Node(T val, Node<T> leftchild, Node<T> rightchild) {
            this.val = val;
            Leftchild = leftchild;
            Rightchild = rightchild;
        }

        private Node(T val) {
            this.val = val;
        }
    }

    private Node<T> root;
    private int count;

    public BinTree() {
        root = null;
        count = 0;
    }

    public BinTree(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i], verdi[i]);
    }

    public final void leggInn(int posisjon, T verdi) {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = root, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0) {
            q = p;
            p = (posisjon & filter) == 0 ? p.Leftchild : p.Rightchild;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);          // ny node

        if (q == null) root = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.Leftchild = p;                // venstre barn til q
        else
            q.Rightchild = p;                  // høyre barn til q

        count++;                       // en ny verdi i treet
    }

    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
        if (posisjon < 1) return null;

        Node<T> p = root;   // nodereferanse
        int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

        for (; p != null && filter > 0; filter >>= 1)
            p = (posisjon & filter) == 0 ? p.Leftchild : p.Rightchild;

        return p;   // p blir null hvis posisjon ikke er i treet
    }

    public boolean finnes(int posisjon) {
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon) {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.val;
    }

    public T oppdater(int posisjon, T nyverdi) {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.val;
        p.val = nyverdi;

        return gammelverdi;
    }

    public int count() {
        return count;
    }

    public boolean tom() {
        return count == 0;
    }

    public T fjern (int posisjon){
        Node<T> removeNode = finnNode(posisjon);
        boolean notOkRemove = true;
        if (removeNode.Leftchild != null|| removeNode.Rightchild != null){
            throw new UnsupportedOperationException("Du kan ikke fjerne en node som ikke er bladnode");
        } else {
            //check if it is a right child or left child
            if (posisjon % 2 == 0){
                //left child
                Node<T> parent = finnNode(posisjon/2);
                removeNode = null;
                parent.Rightchild = null;
            }
            if (posisjon % 2 != 0){
                //right child
                Node<T> parent = finnNode((posisjon - 1)/2);
                parent.Leftchild = null;
                removeNode = null;
            }
            //the branch?

        }

        return removeNode.val;
    }
}

class mainBinTree {
    public static void main(String[] args) {
        Character[] treeeins1 = {'D', 'I', 'H', 'L', 'O', 'B', 'A', 'E', 'N', 'G', 'K', 'M', 'J', 'F', 'C'};
        int[] positions1 = {1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 21, 24, 25, 42, 43};
        BinTree<Character> bintree1 = new BinTree(positions1, treeeins1);
        bintree1.fjern(43);
        System.out.println(bintree1.toString());

        Character[] treeins2 = {'E', 'I', 'B', 'G', 'A', 'H', 'K', 'L', 'O', 'D', 'N', 'M', 'C', 'J', 'F'};
        int[] positions2 = {1, 2, 3, 4, 5, 6, 7, 10, 11, 13, 14, 22, 23, 28, 29};
        BinTree<Character> bintree2 = new BinTree(positions2, treeins2);

        Integer [] onlyInts = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int []onlyIntsposition = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
        BinTree<Integer>onLefts = new BinTree(onlyIntsposition, onlyInts);
    }
}

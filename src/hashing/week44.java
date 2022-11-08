package hashing;

public class week44 {


    public static void main(String[] args) {
        String [] s ={"A"};
        String a = "A", b =  "A", c = new String ("A"), d = s[0];
        boolean lik1 = (a == b), lik2 = (a==c), lik3 = (a == d);
        boolean eq1 = a.equals(b), eq2 = b.equals(c), eq3 = c.equals(d);
        System.out.println(" a == b : " + eq1 + "\n b==c : " +eq2 + "\n" + " c==d: " + eq3);
        System.out.println("--------------------------------");
        for (String i: s) System.out.print(i+ " \n");
        System.out.println("________________________________");
        int h1 = a.hashCode(), h2 = b.hashCode(), h3 = c.hashCode(), h4 = d.hashCode();
        System.out.println("h1: " + h1 + " h2: "+h2 + " h3: " +h3 + " h4: " + h4);


         String a1 = "ab";
         String a2 = "ba";
         boolean hashchck = (a1.hashCode() == a2.hashCode());
        System.out.println("lik hash: " + hashchck);
    }
}

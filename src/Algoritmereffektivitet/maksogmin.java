package Algoritmereffektivitet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class maksogmin {



  public static void main (String[]args){
       int[] a = {8, 3,5, 7, 9, 2, 1, 4, 555};

      IntStream s = Arrays.stream(a);

      OptionalInt resultat = s.max();
      if (resultat.isPresent()) System.out.println(resultat.getAsInt());
      else System.out.println("null ferdi lmao");

  }
}

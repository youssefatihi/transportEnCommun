package collecte;
import java.util.ArrayList;

public class CollecteArrayList implements Collecte {

   public ArrayList<int[]> collector;
   private int[] counter = {0, 0, 0};


   public CollecteArrayList(){
      collector = new ArrayList<int[]>();

   }

   public void uneEntree(){
      counter[0]++;
   }
      
   public void uneSortie(){
      counter[1]++;
   }

   public void changerArret(){
      counter[2] = collector.size();
      collector.add(counter);
      counter=generateCounter();
   }

   private int[] generateCounter(){
      return new int[3];
   }

   public String toString(){
      System.out.println("collecte = [");
         for (int[] ele : collector) {
               System.out.println("[ nb_montee: " + ele[0] + ", nb_sortis: " + ele[1] + ", numero_arret: " + ele[2] + "]");
         }
         System.out.println("]");
      return "";   
   }
}


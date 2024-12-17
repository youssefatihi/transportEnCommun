package tec;
import collecte.CollecteArrayList;
import collecte.CollecteFile;
import collecte.Collecte;
public class GreffonEstUn extends Autobus {

   private Collecte collecte; 
   GreffonEstUn(int nbPlaceAssise, int nbPlaceDebout, Collecte typeCollecte){
      super( nbPlaceAssise,  nbPlaceDebout);
      collecte=typeCollecte;
   }


   public void allerArretSuivant(){
      collecte.changerArret();
      super.allerArretSuivant();
      
   }


   public void monteeDemanderAssis(Passager p){
      super.monteeDemanderAssis(p);
      collecte.uneEntree();
   }

   public void monteeDemanderDebout(Passager p){
      super.monteeDemanderDebout(p);
      collecte.uneEntree();
   }


public void arretDemanderSortie(Passager p){
   super.arretDemanderSortie(p);
   collecte.uneSortie();
}

public void arretDemanderAssis(Passager p){
   super.arretDemanderAssis(p);
}

public void arretDemanderDebout(Passager p){
   super.arretDemanderDebout(p);
}


 public void printCollect(){
        System.out.println(collecte);
    }
   public String toString(){
      return super.toString() ;
   }
   
   public Collecte getCollecte(){
   	return collecte;}

}

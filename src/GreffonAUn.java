package tec;
import collecte.Collecte;

public class GreffonAUn implements Vehicule,Transport{
   private Transport bus;
   private Collecte collecte;

   GreffonAUn(Collecte c, Transport b){
      bus = b;
      collecte=c;
   }

   
   public void allerArretSuivant(){
      collecte.changerArret();
      bus.allerArretSuivant();
   }

   public void monteeDemanderAssis(Passager p){
      Vehicule v  = (Vehicule) bus;
      v.monteeDemanderAssis(new PassagerGreffon(p,this));
      collecte.uneEntree();
   }
   //...... le reste du code

   public void monteeDemanderDebout(Passager p){      
      Vehicule v  = (Vehicule) bus;
      v.monteeDemanderDebout(new PassagerGreffon(p,this));
      collecte.uneEntree();
   }


   public void arretDemanderSortie(Passager p){
      Vehicule v  = (Vehicule) bus;
      v.arretDemanderSortie(p);
      collecte.uneSortie();
   }

    public void arretDemanderDebout(Passager p) {
      Vehicule v  = (Vehicule) bus;
        v.arretDemanderDebout(p);
    }

    public void arretDemanderAssis(Passager p) {
      Vehicule v  = (Vehicule) bus;
      v.arretDemanderAssis(p);
    }


    public boolean aPlaceAssise() {
         Vehicule v  = (Vehicule) bus;
         return v.aPlaceAssise();
    }

    public boolean aPlaceDebout() {
      Vehicule v  = (Vehicule) bus;
        return v.aPlaceDebout();
    }
    public void printCollect(){
        System.out.println(collecte);
    }
   public String toString(){
      Vehicule v  = (Vehicule) bus;
      return v.toString() ;
   }
}

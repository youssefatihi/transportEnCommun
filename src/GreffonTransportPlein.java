package tec;
import collecte.CollecteArrayList;
import collecte.CollecteFile;
import collecte.Collecte;
public class GreffonTransportPlein extends Autobus{

private static Collecte collecte; 

 GreffonTransportPlein(int nbPlaceAssise, int nbPlaceDebout, Collecte typeCollecte){
    super( nbPlaceAssise,  nbPlaceDebout);
    collecte=typeCollecte;
 }


public void allerArretSuivant(){
   collecte.changerArret();
   super.allerArretSuivant();
   
}


public void monteeDemanderAssis(Passager p){
    if(super.aPlaceAssise()){
        super.monteeDemanderAssis(p);
        collecte.uneEntree();
    }
}

public void monteeDemanderDebout(Passager p){
    if(super.aPlaceDebout()){
        super.monteeDemanderDebout(p);
        collecte.uneEntree();
    }
}

public void arretDemanderAssis(Passager p){
   if(super.aPlaceAssise()){
        super.arretDemanderAssis(p);
   }
}

public void arretDemanderDebout(Passager p){
    if(super.aPlaceDebout()){
        super.arretDemanderDebout(p);
    }
}


public void arretDemanderSortie(Passager p){
   super.arretDemanderSortie(p);
   collecte.uneSortie();
}

public static Collecte getCollecte(){
   	return collecte;
 }


}

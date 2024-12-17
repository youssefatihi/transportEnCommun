package tec;
class ArretAgoraphobe implements ComportementArret {

    ArretAgoraphobe(){

    }

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if(!v.aPlaceAssise() || !v.aPlaceDebout())
            v.arretDemanderSortie(p);    
        }

}
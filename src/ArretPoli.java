package tec;

class ArretPoli implements ComportementArret{

    ArretPoli(){

    }
    
    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){

            if(!v.aPlaceAssise())
                p.changerEnDebout();
            if(distanceDestination==1)
                v.arretDemanderSortie(p);  


    }


}